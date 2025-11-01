package org.example.javaweb_crm.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Employee {
    // 自增主键
    private Integer id;
    // 姓名
    private String name;
    // 性别
    private String sex;
    // 出生日期（对应表中的 birth_date）
    private String birthDate;
    // 部门（对应表中的 department）
    private String department;
    // 职位（对应表中的 position）
    private String position;
    // 电话号码（对应表中的 phone_number）
    private String phoneNumber;
    // 邮箱（对应表中的 email）
    private String email;
    // 备注（对应表中的 remark）
    private String remark;
}
