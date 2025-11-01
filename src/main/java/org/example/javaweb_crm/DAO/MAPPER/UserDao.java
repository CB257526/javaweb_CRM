package org.example.javaweb_crm.DAO.MAPPER;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.javaweb_crm.domain.User;

@Mapper
public interface UserDao {
    /**
     * 用户登录
     * @param name 用户名
     * @param password 密码
     * @return 登录成功返回1，否则返回0
     */
    @Select("select COUNT(*) from crmuser where name=#{name} and password=#{password}")
    int loginIS(@Param("name") String name, @Param("password") String password);
}
