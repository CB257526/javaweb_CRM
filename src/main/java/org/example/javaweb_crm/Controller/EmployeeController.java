package org.example.javaweb_crm.Controller;

import jakarta.servlet.http.HttpSession;
import org.example.javaweb_crm.Service.iml.UserByIml;
import org.example.javaweb_crm.Service.iml.employeeIml;
import org.example.javaweb_crm.domain.Employee;
import org.example.javaweb_crm.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private employeeIml employeeIml;



    /**
     * 查询所有员工
     * @return 员工列表
     */
    @RequestMapping("/selectAll")
    public List<Employee> selectAll() {
        return employeeIml.selectAll();
    }

    /**
     * 删除员工
     * @param id 员工ID
     * @return 删除成功返回1，否则返回0
     */
    @RequestMapping("/deleteUser")
    public int deleteUser(int id) {
        return employeeIml.deleteEmployee(id);
    }


    /**
     * 插入员工
     * @param employee 员工对象
     * @return 插入成功返回1，否则返回0
     */
    @RequestMapping("/insertUser")
    public int insertUser(Employee employee) {
        return employeeIml.insertEmployee(employee);
    }


    /**
     * 更新员工
     * @param employee 员工对象
     * @return 更新成功返回1，否则返回0
     */
    @RequestMapping("/updateUser")
    public int updateUser(Employee employee) {
        return employeeIml.updateEmployee(employee);
    }

    //模糊搜索
    /**
     * 模糊搜索员工
     * @param name 员工名
     * @return 员工列表
     */
    @RequestMapping("/searchUser")
    public List<Employee> searchUser(@RequestParam("name") String name) {
        return employeeIml.searchEmployee(name);
    }

    //查看员工详细信息
    /**
     * 根据ID查询员工
     * @param id 员工ID
     * @return 员工对象
     */
    @RequestMapping("/selectUserById")
    public Employee selectUserById(int id) {
        return employeeIml.selectEmployeeById(id);
    }
}
