package repository.implementation;

import model.Employee;
import model.enums.PositionAtWork;
import org.springframework.stereotype.Repository;
import repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepositoryImp implements EmployeeRepository {

    private List<Employee> employees = new ArrayList<>();
    private int id = 0;

    {
        employees.add(new Employee(id++,"Oleg", PositionAtWork.CLEANER, 20_000));
        employees.add(new Employee(id++,"Sashok", PositionAtWork.PROGRAMMER, 200_000));
        employees.add(new Employee(id++,"Oleg", PositionAtWork.SUBMANAGER, 500_000));
    }

    @Override
    public Employee getEmployeeById(int id) {
        return (Employee) employees.stream()
                .filter(employee -> employee.getId()==id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public void createEmployee(Employee employee) {
       // employee.setId(id++);
        employees.add(employee);
    }

    @Override
    public void updateEmployee(Employee updatedEmployee) {
        Optional<Employee> optEmployee = employees.stream()
                .filter(employee -> employee.getId()==updatedEmployee.getId())
                .findFirst();

        if(optEmployee.isPresent()){
            Employee employee = optEmployee.get();
            employee.setName(updatedEmployee.getName());
            employee.setPositionAtWork(updatedEmployee.getPositionAtWork());
            employee.setSalary(updatedEmployee.getSalary());
        }
    }

    @Override
    public void deleteEmployee(int id) {
        employees.removeIf(employee -> employee.getId()==id);
    }
}
