package org.example.javaweb_crm.Service.cla;

import org.example.javaweb_crm.DAO.MAPPER.UserDao;
import org.example.javaweb_crm.Service.iml.loginiml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class logincla implements loginiml {
    @Autowired
    private UserDao userDao;

    @Override
    public boolean loginIS(String name, String password) {
        System.out.println("logincla loginIS name=" + name + " password=" + password);
        int i = userDao.loginIS(name, password);
        System.out.println("logincla loginIS i=" + i);
        return i != 0;
    }
}
