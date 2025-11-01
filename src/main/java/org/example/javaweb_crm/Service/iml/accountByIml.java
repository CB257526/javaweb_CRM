package org.example.javaweb_crm.Service.iml;

import org.example.javaweb_crm.domain.Account;

import java.util.List;

public interface accountByIml {
    //查询所有用户
    List<Account> selectAll();

    //删除用户
    int deleteUser(int id);

    //添加用户
    int addUser(Account account, String password);

    //更新用户
    int updateUser(Account account, String password);

    //禁用该用户
    int disableUser(int id);

    //启用该用户
    int enableUser(int id);

    //根据用户名模糊查询用户
    List<Account> searchUser(String name);
}
