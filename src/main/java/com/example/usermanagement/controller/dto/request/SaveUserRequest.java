package com.example.usermanagement.controller.dto.request;

import java.io.Serializable;
import java.util.List;

public class SaveUserRequest implements Serializable {

    private String name;

    private List<Integer> roleIds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }
}
