package com.example.repository;

import com.example.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    Employee getEmployeeById(int id);

    List<Employee> getAllEmployees();

    void createEmployee(Employee employee);

    void updateEmployee(int id, Employee employee);

    void deleteEmployee(int id);

    List<Employee> getAllEmployeeIds(List<Integer> ids);

}
