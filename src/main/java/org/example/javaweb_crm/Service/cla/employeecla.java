package org.example.javaweb_crm.Service.cla;

import org.example.javaweb_crm.DAO.MAPPER.employeeMapper;
import org.example.javaweb_crm.Service.iml.employeeIml;
import org.example.javaweb_crm.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class employeecla implements employeeIml {

    @Autowired
    private employeeMapper employeeMapper;

    @Override
    public Employee selectEmployeeById(int id) {
        return employeeMapper.selectEmployeeById(id);
    }

    @Override
    public List<Employee> searchEmployee(String name) {
        // 模糊搜索员工
        name = "%" + name + "%";
        return employeeMapper.searchEmployee(name);
    }

    @Override
    public int updateEmployee(Employee employee) {
        return employeeMapper.updateEmployee(employee);
    }

    @Override
    public int insertEmployee(Employee employee) {
        return employeeMapper.insertEmployee(employee);
    }

    @Override
    public int deleteEmployee(int id) {
        return employeeMapper.deleteEmployee(id);
    }

    @Override
    public List<Employee> selectAll() {
        return employeeMapper.selectAll();
    }
}
