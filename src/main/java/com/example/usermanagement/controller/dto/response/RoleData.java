package com.example.usermanagement.controller.dto.response;

import com.example.usermanagement.entity.Role;
import java.io.Serializable;

public class RoleData implements Serializable {

    private Integer id;

    private String name;

    protected RoleData()
    {
        //for de-serialization
    }

    public RoleData(Role role)
    {
        this.id = role.getId();
        this.name = role.getName();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
