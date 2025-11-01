package org.example.javaweb_crm.Service.cla;

import org.example.javaweb_crm.DAO.MAPPER.UserDao;
import org.example.javaweb_crm.Service.iml.UserByIml;
import org.example.javaweb_crm.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBycla implements UserByIml {
    @Autowired
    private UserDao userDao;

    @Override // 实现查询所有用户的方法
    public List<User> selectAll() {
        return userDao.selectAll();
    }

    @Override // 实现删除用户的方法
    public int deleteUser(int id) {
        return userDao.deleteUser(id);
    }

    @Override // 实现插入用户的方法
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override // 实现更新用户的方法
    public int updateUser(int id, String name, String status, String remarks, String lastChangeTime) {
        return userDao.updateUser(id, name, status, remarks, lastChangeTime);
    }

     @Override // 实现模糊搜索用户的方法
     public List<User> searchUser(String name) {
        // 模糊搜索用户
        name = "%" + name + "%";
        return userDao.searchUser(name);
     }
}
