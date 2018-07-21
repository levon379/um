package com.example.usermanagement.controller;

import com.example.usermanagement.controller.dto.request.SaveRoleRequest;
import com.example.usermanagement.controller.dto.response.RoleData;
import com.example.usermanagement.entity.Role;
import com.example.usermanagement.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/role")
public class RoleController {


    @Autowired
    private RoleRepository roleRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<RoleData>> getRoleList()
    {


        return new ResponseEntity<>(roleRepository.findAll().stream().map(RoleData::new).collect(Collectors.toList()), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<RoleData> createRole(@RequestBody SaveRoleRequest saveRoleRequest)
    {

        Role role = new Role();
        role.setName(saveRoleRequest.getName());


        Role stored = roleRepository.save(role);

        return new ResponseEntity<>(new RoleData(stored), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<RoleData> updateRole(@PathVariable final Integer id, @RequestBody SaveRoleRequest saveRoleRequest)
    {

        Role role = roleRepository.getOne(id);
        role.setName(saveRoleRequest.getName());


        Role stored = roleRepository.save(role);

        return new ResponseEntity<>(new RoleData(stored), HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<RoleData> getRole(@PathVariable final Integer id)
    {

        Role role = roleRepository.getOne(id);
        return new ResponseEntity<>(new RoleData(role), HttpStatus.OK);
    }


}
