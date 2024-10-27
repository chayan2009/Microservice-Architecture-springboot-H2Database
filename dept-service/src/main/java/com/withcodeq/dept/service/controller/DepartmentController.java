package com.withcodeq.dept.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.withcodeq.dept.service.entity.Department;
import com.withcodeq.dept.service.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/departments")
@Slf4j
@Tag(name = "Department Controller", description = "Controller for Department-related operations")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/add")
    @Operation(summary = "Add a new department", description = "Adds a new department to the system")
    public Department saveDepartment(@RequestBody Department department) {
        log.info("Inside saveDepartment method in DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find department by ID", description = "Retrieves a department by its ID")
    public Department findDepartmentById(@PathVariable("id") Long departmentId) {
        log.info("Inside findDepartmentById method in DepartmentController");
        return departmentService.findDepartmentById(departmentId);
    }
}
