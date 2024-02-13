package repository;

import model.Employee;
import model.Manager;

import java.util.List;

public interface ManagerRepository {
    Manager getManagerById(int id);
    List<Manager> getAllManager();
    List<Employee> getManagersEmployees(Manager manager);
    void createManager(Manager manager);
    void updateManager(int id, Manager manager);
    void deleteManager(int id);
}
