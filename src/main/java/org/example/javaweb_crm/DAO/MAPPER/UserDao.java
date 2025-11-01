package org.example.javaweb_crm.DAO.MAPPER;


import org.apache.ibatis.annotations.*;
import org.example.javaweb_crm.domain.User;

import java.util.List;

@Mapper
public interface UserDao {
    /**
     * 用户登录
     * @param name 用户名
     * @param password 密码
     * @return 登录成功返回1，否则返回0
     */
    @Select("select COUNT(*) from accountpassword where name=#{name} and password=#{password}")
    int loginIS(@Param("name") String name, @Param("password") String password);


     /**
      * 查询所有用户
      * @return 用户列表
      */
    @Select("select * from crmuser")
    List<User> selectAll();

     /**
      * 删除用户
      * @param id 用户ID
      * @return 删除成功返回1，否则返回0
      */
    @Delete("delete from crmuser where id=#{id}")
    int deleteUser(@Param("id") int id);



    @Insert("insert into crmuser(name,status,last_change_time,operator,Remarks) values(#{Name},#{Status},#{lastChangeTime},#{Operator},#{Remarks})")
    int insertUser(User user);



    @Update("update crmuser set name=#{name},status=#{status},last_change_time=#{lastChangeTime},Remarks=#{remarks} where id=#{id}")
    int updateUser(@Param("id") int id, @Param("name") String name, @Param("status") String status, @Param("remarks") String remarks, @Param("lastChangeTime") String lastChangeTime);


     /**
      * 模糊搜索用户
      * @param name 用户名
      * @return 用户列表
      */
    @Select("select * from crmuser where name like #{name}")
    List<User> searchUser(@Param("name") String name);
}
