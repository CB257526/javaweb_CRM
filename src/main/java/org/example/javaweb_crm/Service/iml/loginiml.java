package org.example.javaweb_crm.Service.iml;

public interface loginiml {
    /**
     * 用户登录
     * @param name 用户名
     * @param password 密码
     * @return 登录成功返回1，否则返回0
     */
     boolean loginIS(String name,String password);
}
