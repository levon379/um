package com.example.usermanagement.controller.dto.request;

import java.io.Serializable;

public class SaveRoleRequest implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
