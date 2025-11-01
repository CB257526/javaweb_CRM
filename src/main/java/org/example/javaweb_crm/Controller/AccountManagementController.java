package org.example.javaweb_crm.Controller;
import org.example.javaweb_crm.Service.iml.accountByIml;
import org.example.javaweb_crm.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountManagementController {
    @Autowired
    private accountByIml accountby;

    /**
     * 查询所有用户
     * @return 用户列表
     */
    @RequestMapping("/selectAll")
    public List<Account> selectAll() {
        return accountby.selectAll();
    }

    /**
     * 删除用户和相关密码
     * @param id 用户ID
     * @return 删除成功返回1，否则返回0
     */
    @RequestMapping("/deleteUser")
    public int deleteUser(int id) {
        return accountby.deleteUser(id);
    }


    /**
     * 插入用户
     * @param name 用户名
     * @param status 状态
     * @param password 密码
     * @param role 角色
     * @return 插入成功返回1，否则返回0
     */
    @RequestMapping("/insertUser")
    public int insertUser(@RequestParam("name") String name, @RequestParam("status") String status, @RequestParam("password") String password,@RequestParam("role") String role) {
        Account account = new Account();
        account.setName(name);
        account.setStatus(status);
        //获取当前时间
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String nowStr = LocalDateTime.now().format(f);
        account.setLastChangeTime(nowStr);
        account.setCreateTime(nowStr);
        account.setRole(role);
        return accountby.addUser(account, password);
    }


    /**
     * 更新用户
     * @param account 用户对象
     * @param password 密码
     * @return 更新成功返回1，否则返回0
     */
    @RequestMapping("/updateUser")
    public int updateUser(Account account,@RequestParam("password") String password) {
        //获取当前时间
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String nowStr = LocalDateTime.now().format(f);
        account.setLastChangeTime(nowStr);
        return accountby.updateUser(account, password);
    }

    //模糊搜索
    /**
     * 模糊搜索用户
     * @param name 用户名
     * @return 用户列表
     */
    @RequestMapping("/searchUser")
    public List<Account> searchUser(@RequestParam("name") String name) {
        return accountby.searchUser(name);
    }


    //禁用该用户
    @RequestMapping("/disableUser")
    public int disableUser(int id) {
        return accountby.disableUser(id);
    }

    //启用该用户
    @RequestMapping("/enableUser")
    public int enableUser(int id) {
        return accountby.enableUser(id);
    }
}
