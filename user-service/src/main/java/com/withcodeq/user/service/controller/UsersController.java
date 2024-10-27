package com.withcodeq.user.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.withcodeq.user.service.entity.Users;
import com.withcodeq.user.service.service.UsersService;
import com.withcodeq.user.service.vo.ResponseTemplateVo;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UsersController {
    
    @Autowired
    private UsersService usersService;

    @PostMapping("/add")
    public Users saveUser(@RequestBody Users users){
        log.info("inside saveinfo of UsersController");
        return usersService.saveUser(users);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVo getUserWithDepartment(@PathVariable("id")long userId){
        log.info("inside getUserWithDepartment of UsersController");
        return usersService.getUserWithDepartment(userId);
    }

}
