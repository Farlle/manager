package service;

import model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmployeeById(int id);
    List<Employee> getAllEmployees();
    void createEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);
}
