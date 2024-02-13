package repository.implementation;

import model.Employee;
import model.Manager;
import repository.ManagerRepository;

import java.util.List;

public class ManagerRepositoryImp implements ManagerRepository {
    @Override
    public Manager getManagerById(int id) {
        return null;
    }

    @Override
    public List<Manager> getAllManager() {
        return null;
    }

    @Override
    public List<Employee> getManagersEmployees(Manager manager) {
        return null;
    }

    @Override
    public void createManager(Manager manager) {

    }

    @Override
    public void updateManager(int id, Manager manager) {

    }

    @Override
    public void deleteManager(int id) {

    }
}
