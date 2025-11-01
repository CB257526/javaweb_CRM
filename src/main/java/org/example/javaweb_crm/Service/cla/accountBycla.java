package org.example.javaweb_crm.Service.cla;

import org.example.javaweb_crm.DAO.MAPPER.accountMapper;
import org.example.javaweb_crm.Service.iml.accountByIml;
import org.example.javaweb_crm.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class accountBycla implements accountByIml {
    @Autowired
    private accountMapper accountmapper;

    @Override
    public List<Account> selectAll() {
        return accountmapper.selectAll();
    }

    @Override
    public int deleteUser(int id) {
        int b = accountmapper.deletePassword(id);
        int a = accountmapper.deleteUser(id);
        return a&b;
    }

    @Override
    public int addUser(Account account, String password) {
        int a = accountmapper.insertUser(account);
        int b = accountmapper.insertPassword(account.getName(), password);
        return a&b;
    }

    @Override
    public int updateUser(Account account, String password) {
        int a = accountmapper.updateUser(account);
        int b = accountmapper.updatePassword(account.getId(), password);
        return a&b;
    }

    @Override
    public int disableUser(int id) {
        return accountmapper.disableUser(id);
    }

    @Override
    public int enableUser(int id) {
        return accountmapper.enableUser(id);
    }

    @Override
    public List<Account> searchUser(String name) {
        // 模糊搜索用户
        name = "%" + name + "%";
        return accountmapper.searchUser(name);
    }
}
