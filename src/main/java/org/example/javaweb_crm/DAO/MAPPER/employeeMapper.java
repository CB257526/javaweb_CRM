package org.example.javaweb_crm.DAO.MAPPER;

import org.apache.ibatis.annotations.*;
import org.example.javaweb_crm.domain.Employee;
import org.example.javaweb_crm.domain.User;

import java.util.List;

@Mapper
public interface employeeMapper {
    /**
     * 查询所有员工
     * @return 员工列表
     */
    @Select("select * from employee")
    List<Employee> selectAll();

    /**
     * 删除用户
     * @param id 用户ID
     * @return 删除成功返回1，否则返回0
     */
    @Delete("delete from employee where id=#{id}")
    int deleteEmployee(@Param("id") int id);



    @Insert("insert into employee(name,sex,birth_date,department,position,phone_number,email,remark) values(#{name},#{sex},#{birthDate},#{department},#{position},#{phoneNumber},#{email},#{remark})")
    int insertEmployee(Employee employee);



    @Update("update employee set name=#{name},sex=#{sex},birth_date=#{birthDate},department=#{department},position=#{position},phone_number=#{phoneNumber},email=#{email},remark=#{remark} where id=#{id}")
    int updateEmployee(Employee employee);


    /**
     * 模糊搜索员工
     * @param name 员工名
     * @return 员工列表
     */
    @Select("select * from employee where name like #{name}")
    List<Employee> searchEmployee(@Param("name") String name);

    //根据ID查询员工
    @Select("select * from employee where id=#{id}")
    Employee selectEmployeeById(@Param("id") int id);
}
