package org.example.javaweb_crm.Service.iml;

import org.apache.ibatis.annotations.*;
import org.example.javaweb_crm.domain.Employee;

import java.util.List;

public interface employeeIml {
    /**
     * 查询所有员工
     * @return 员工列表
     */
    List<Employee> selectAll();

    /**
     * 删除用户
     * @param id 用户ID
     * @return 删除成功返回1，否则返回0
     */
    int deleteEmployee(int id);

    int insertEmployee(Employee employee);

    int updateEmployee(Employee employee);


    /**
     * 模糊搜索员工
     * @param name 员工名
     * @return 员工列表
     */
    List<Employee> searchEmployee(String name);

    //根据ID查询员工
    Employee selectEmployeeById(int id);
}
