package com.withcodeq.user.service.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Operation(summary = "Add a new user", description = "Saves a new user into the system")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "User saved successfully",
                content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Users.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input",
                content = @Content),
        @ApiResponse(responseCode = "500", description = "Internal server error",
                content = @Content)
    })
    @PostMapping("/add")
    public Users saveUser(@RequestBody Users users) {
        log.info("inside saveUser method of UsersController");
        return usersService.saveUser(users);
    }

    @Operation(summary = "Get user with department", description = "Fetches user details along with associated department information by user ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "User found",
                content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ResponseTemplateVo.class))),
        @ApiResponse(responseCode = "404", description = "User not found",
                content = @Content),
        @ApiResponse(responseCode = "500", description = "Internal server error",
                content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseTemplateVo getUserWithDepartment(@PathVariable("id") long userId) {
        log.info("inside getUserWithDepartment method of UsersController");
        return usersService.getUserWithDepartment(userId);
    }
}
