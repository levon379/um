package com.example.usermanagement.controller;

import com.example.usermanagement.controller.dto.request.SaveUserRequest;
import com.example.usermanagement.controller.dto.response.UserData;
import com.example.usermanagement.entity.Role;
import com.example.usermanagement.entity.User;
import com.example.usermanagement.repository.RoleRepository;
import com.example.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/user")
public class UserController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<UserData>> getUserList()
    {


        return new ResponseEntity<>(userRepository.findAll().stream().map(UserData::new).collect(Collectors.toList()), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<UserData> createUser(@RequestBody SaveUserRequest saveUserRequest)
    {

        User user = new User();
        user.setName(saveUserRequest.getName());


        if(saveUserRequest.getRoleIds() != null) {
            user.setRoleList(new ArrayList<>());
            for (Integer roleId : saveUserRequest.getRoleIds()) {
                Role role = roleRepository.getOne(roleId);
                user.getRoleList().add(role);
            }
        }


        User stored = userRepository.save(user);

        return new ResponseEntity<>(new UserData(stored), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UserData> updateUser(@PathVariable final Integer id, @RequestBody SaveUserRequest saveUserRequest)
    {

        User user = userRepository.getOne(id);
        user.setName(saveUserRequest.getName());


        User stored = userRepository.save(user);

        return new ResponseEntity<>(new UserData(stored), HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserData> getUser(@PathVariable final Integer id)
    {

        User user = userRepository.getOne(id);
        return new ResponseEntity<>(new UserData(user), HttpStatus.OK);
    }


}
