package org.example.javaweb_crm.Service.iml;

import org.example.javaweb_crm.domain.User;

import java.util.List;

public interface UserByIml {
    /**
     * 查询所有用户
     * @return 用户列表
     */
    List<User> selectAll();

     /**
      * 删除用户
      * @param id 用户ID
      * @return 删除成功返回1，否则返回0
      */
    int deleteUser(int id);

      /**
       * 插入用户
       * @param user 用户对象
       * @return 插入成功返回1，否则返回0
       */
    int insertUser(User user);

     /**
      * 更新用户
      * @param id 用户ID
      * @param name 用户名
      * @param status 状态
      * @param remarks 备注
      * @param lastChangeTime 最后修改时间
      * @return 更新成功返回1，否则返回0
      */
    int updateUser(int id, String name, String status, String remarks, String lastChangeTime);


     /**
      * 模糊搜索用户
      * @param name 用户名
      * @return 用户列表
      */
    List<User> searchUser(String name);
}
