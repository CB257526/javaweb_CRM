package org.example.javaweb_crm.Controller;


import jakarta.servlet.http.HttpSession;
import org.example.javaweb_crm.Service.iml.UserByIml;
import org.example.javaweb_crm.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;


// 角色管理控制器
@RestController
@RequestMapping("/role")
public class RoleManagementController {
    @Autowired
    private UserByIml userby;

    /**
     * 查询所有角色
     * @return 角色列表
     */
    @RequestMapping("/selectAll")
    public List<User> selectAll() {
        return userby.selectAll();
    }

    /**
     * 删除角色
     * @param id 角色ID
     * @return 删除成功返回1，否则返回0
     */
    @RequestMapping("/deleteUser")
    public int deleteUser(int id) {
        return userby.deleteUser(id);
    }


     /**
      * 插入用户
      * @param name 角色名
      * @param status 状态
      * @param Remarks 备注
      * @return 插入成功返回1，否则返回0
      */
    @RequestMapping("/insertUser")
    public int insertUser(@RequestParam("name") String name, @RequestParam("status") String status, @RequestParam("Remarks") String Remarks, HttpSession session) {
        User user = new User();
        user.setName(name);
        user.setStatus(status);
        user.setRemarks(Remarks);
        //获取当前时间
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String nowStr = LocalDateTime.now().format(f);
        user.setLastChangeTime(nowStr);
        //获取提交人的用户名
        String operator = (String) session.getAttribute("username");
        user.setOperator(operator);
        return userby.insertUser(user);
    }


     /**
      * 更新角色
      * @param id 角色ID
      * @param name 角色名
      * @param status 状态
      * @param Remarks 备注
      * @return 更新成功返回1，否则返回0
      */
    @RequestMapping("/updateUser")
    public int updateUser(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("status") String status, @RequestParam("Remarks") String Remarks) {
        //获取当前时间
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String nowStr = LocalDateTime.now().format(f);
        return userby.updateUser(id, name, status, Remarks, nowStr);
    }

    //模糊搜索
     /**
      * 模糊搜索角色
      * @param name 角色名
      * @return 角色列表
      */
    @RequestMapping("/searchUser")
    public List<User> searchUser(@RequestParam("name") String name) {
        return userby.searchUser(name);
    }







}
