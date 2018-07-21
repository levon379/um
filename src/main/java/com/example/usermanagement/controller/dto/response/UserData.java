package com.example.usermanagement.controller.dto.response;

import com.example.usermanagement.entity.Role;
import com.example.usermanagement.entity.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserData implements Serializable {

    private Integer id;

    private String name;

    private List<RoleData> roleList;

    protected UserData()
    {
        //for de-serialization
    }

    public UserData(User user)
    {
        this.id = user.getId();
        this.name = user.getName();
        if(user.getRoleList() != null)
        {
            roleList = new ArrayList<>();
            for(Role role : user.getRoleList())
            {
                roleList.add(new RoleData(role));
            }
        }
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

    public List<RoleData> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<RoleData> roleList) {
        this.roleList = roleList;
    }
}
