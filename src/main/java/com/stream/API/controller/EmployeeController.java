package com.stream.API.controller;

import com.stream.API.Employee;
import com.stream.API.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/min")
    public Employee minSalary(int department) {
        return employeeService.minSalary(department);
    }
    @GetMapping("/max")
    public Employee maxSalary(int department){
        return employeeService.maxSalary(department);
    }
    @GetMapping("/allDepartment")
    public List<Employee> employeeDepartment(int department) {
        return employeeService.employeeDepartment(department);
    }
    @GetMapping("/all")
    public Map<Integer, List<Employee>> employeeSlashDepartment(){
        return employeeService.employeeSlashDepartment();
    }




}
