package org.example.javaweb_crm.DAO.MAPPER;

import org.apache.ibatis.annotations.*;
import org.example.javaweb_crm.domain.User;
import org.example.javaweb_crm.domain.Account;

import java.util.List;

@Mapper
public interface accountMapper {

    //查询所有用户
    @Select("select * from account")
    List<Account> selectAll();

    //删除用户
    @Delete("delete from account where id=#{id}")
    int deleteUser(@Param("id") int id);
    //删除用户相关的密码
    @Delete("delete from accountpassword where name in (SELECT name FROM account WHERE id = #{id})")
    int deletePassword(@Param("id") int id);

    //添加用户
    @Insert("insert into account(name,status,role,last_change_time,create_time) values(#{Name},#{Status},#{Role},#{lastChangeTime},#{createTime})")
    int insertUser(Account account);
    //添加用户密码
    @Insert("insert into accountpassword(name,password) values(#{Name},#{Password})")
    int insertPassword(@Param("Name") String name, @Param("Password") String password);


    //更新用户
    @Update("update account set name=#{Name},status=#{Status},last_change_time=#{lastChangeTime},role=#{Role} where id=#{id}")
    int updateUser(Account account);
    //更新用户密码
    @Update("update accountpassword set password=#{Password} where name=(SELECT name FROM account WHERE id = #{id})")
    int updatePassword(@Param("id") int id, @Param("Password") String password);


    //禁用该用户
    @Update("update account set status='disabled' where id=#{id}")
    int disableUser(@Param("id") int id);
    //启用该用户
    @Update("update account set status='enabled' where id=#{id}")
    int enableUser(@Param("id") int id);

    //根据用户名模糊查询用户
    @Select("select * from account where name like #{name}")
    List<Account> searchUser(@Param("name") String name);
}
