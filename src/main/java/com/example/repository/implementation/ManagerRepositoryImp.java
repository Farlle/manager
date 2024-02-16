package com.example.repository.implementation;

import com.example.model.Employee;
import com.example.model.Manager;
import com.example.repository.ManagerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ManagerRepositoryImp implements ManagerRepository {

    private List<Manager> managers = new ArrayList<>();
    private int id = 0;
    private EmployeeRepositoryImp employeeRepositoryImp = new EmployeeRepositoryImp();

    {
        List<Employee> employees = employeeRepositoryImp.getAllEmployees();
        managers.add(new Manager(id++, "Anton", "Credit", employees));
    }

    @Override
    public Manager getManagerById(int id) {
        return managers.stream()
                .filter(manager -> manager.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Manager> getAllManager() {
        return managers;
    }

    @Override
    public List<Employee> getManagersEmployees(Manager manager) {
        return manager.getEmployees();
    }

    @Override
    public void createManager(Manager manager) {
        managers.add(manager);
    }

    @Override
    public void updateManager(int id, Manager updManager) {
        Optional<Manager> optionalManager = managers.stream()
                .filter(manager -> manager.getId() == id)
                .findFirst();

        if (optionalManager.isPresent()) {
            Manager existingManager = optionalManager.get();
            existingManager.setName(updManager.getName());
            existingManager.setDepartment(updManager.getDepartment());
            existingManager.setEmployees(updManager.getEmployees());
        }
    }

    @Override
    public void deleteManager(int id) {
        managers.removeIf(manager -> manager.getId() == id);
    }
}
