package com.maria.users.management.system.controller;

import com.maria.users.management.system.conversions.UserConvertion;
import com.maria.users.management.system.dtos.UserDto;
import com.maria.users.management.system.model.User;
import com.maria.users.management.system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@CrossOrigin
public class UsersRestController {

    @Autowired
    private UserService service;

    @GetMapping()
    public ResponseEntity<List<UserDto>> allUsers(){
        return new ResponseEntity<>(service.findAllUsers().stream().map(UserConvertion::entityToDto).toList(), HttpStatus.OK);
    }

    @GetMapping("{username}")
    public ResponseEntity<UserDto> findUser(@PathVariable("username") String username){
        return new ResponseEntity<>(UserConvertion.entityToDto(service.findUserByUsername(username)), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto u){
        return new ResponseEntity<>(UserConvertion.entityToDto(service.createUser(UserConvertion.dtoToEntity(u))), HttpStatus.CREATED);
    }

    @PutMapping("/{username}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("username") String username, @RequestBody User u){
        return new ResponseEntity<>(UserConvertion.entityToDto(service.updateUser(u)), HttpStatus.OK);
    }

    @DeleteMapping("/{username}")
    public void deleteUser(@PathVariable("username") String username) {
        service.deleteUserByUsername(username);
    }
}
