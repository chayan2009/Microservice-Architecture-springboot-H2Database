package com.withcodeq.user.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.withcodeq.user.service.entity.Users;
import com.withcodeq.user.service.repository.UsersRepository;
import com.withcodeq.user.service.vo.Department;
import com.withcodeq.user.service.vo.ResponseTemplateVo;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class UsersService {
    
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Users saveUser(Users users) {
        log.info("inside saveinfo of UsersController");
        return usersRepository.save(users);
    }

    public ResponseTemplateVo getUserWithDepartment(long userId) {
        log.info("inside getUserWithDepartment of UsersService");
        ResponseTemplateVo responseTemplateVo = new ResponseTemplateVo();
        
        // Fetch user by ID
        Users users = usersRepository.findByUserId(userId);
        
        // Check if the user is found, otherwise throw an exception or handle gracefully
        if (users == null) {
            log.error("User with ID " + userId + " not found");
            throw new RuntimeException("User not found with ID: " + userId); // or handle as needed
        }
    
        // Fetch department details using RestTemplate
        Department department = restTemplate.getForObject(
            "http://localhost:9001/departments/" + users.getDepartmentId(), 
            Department.class
        );
    
        // Set the user and department in the response
        responseTemplateVo.setUsers(users);
        responseTemplateVo.setDepartment(department);
    
        return responseTemplateVo;
    }
    
}
