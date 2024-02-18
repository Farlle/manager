package com.example.repository.implementation;

import com.example.model.Employee;
import com.example.model.enums.PositionAtWork;
import org.springframework.stereotype.Repository;
import com.example.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepositoryImp implements EmployeeRepository {

    private List<Employee> employees = new ArrayList<>();
    private int id = 0;

    {
        employees.add(new Employee(id++, "Oleg", PositionAtWork.CLEANER, 20_000));
        employees.add(new Employee(id++, "Sashok", PositionAtWork.PROGRAMMER, 200_000));
        employees.add(new Employee(id++, "Dimas", PositionAtWork.SUBMANAGER, 500_000));
    }

    @Override
    public Employee getEmployeeById(int id) {
        return (Employee) employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Employee with id " + id + " not found"));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public void createEmployee(Employee employee) {
        employee.setId(id++);
        employees.add(employee);

    }

    @Override
    public void updateEmployee(int id, Employee updatedEmployee) {
        Optional<Employee> optionalEmployee = employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst();

        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();
            existingEmployee.setName(updatedEmployee.getName());
            existingEmployee.setSalary(updatedEmployee.getSalary());
            existingEmployee.setPositionAtWork(updatedEmployee.getPositionAtWork());
        } else {
            throw new IllegalArgumentException("Employee with id " + id + " not found");
        }
    }

    @Override
    public void deleteEmployee(int id) {
        boolean remowed = employees.removeIf(employee -> employee.getId() == id);
        if (!remowed) {
            throw new IllegalArgumentException("Employee with id " + id + " not found");
        }

    }

    @Override
    public List<Employee> getAllEmployeeIds(List<Integer> ids) {
        return employees.stream()
                .filter(employee -> ids.contains(employee.getId()))
                .collect(Collectors.toList());
    }
}
