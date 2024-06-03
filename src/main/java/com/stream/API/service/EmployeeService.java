package com.stream.API.service;

import com.stream.API.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    Employee minSalary(int department);
    Employee maxSalary(int department);
    List<Employee> employeeDepartment(int department);
    Map<Integer, List<Employee>> employeeSlashDepartment();



}
