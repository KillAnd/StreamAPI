package com.stream.API.service;

import com.stream.API.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    Map<String, Employee> employees = new HashMap<>(Map.of(
            "Логинов Виктор", new Employee("Логинов", "Виктор", 1, 256_000),
            "Ларионова Наталья", new Employee("Ларионова", "Наталья", 2, 156_000),
            "Смуглый Игорь", new Employee("Смуглый", "Игорь", 2, 254_000),
            "Сидоров Илья", new Employee("Сидоров", "Илья", 3, 22_000),
            "Могилев Виктор", new Employee("Могилев", "Виктор", 3, 211_000),
            "Проворов Семен", new Employee("Проворов", "Семен", 4, 153_000),
            "Иванов Иван", new Employee("Иванов", "Иван", 4, 234_444),
            "Имранов Сигизмунд", new Employee("Имранов", "Сигизмунд", 4, 133_455)
    ));
    @Override
    public Employee minSalary(int department) {
        return employees.values()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Employee maxSalary(int department) {
        return employees.values()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public List<Employee> employeeDepartment(int department) {
        return employees.values()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .toList();
    }

    @Override
    public Map<Integer, List<Employee>> employeeSlashDepartment() {
        return employees.values()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
