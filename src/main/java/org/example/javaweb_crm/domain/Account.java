package org.example.javaweb_crm.domain;

import lombok.Data;

@Data
public class Account {
    private int id;
    private String Name;
    private String Status;
    private String lastChangeTime;
    private String Role;
    private String createTime;
}
