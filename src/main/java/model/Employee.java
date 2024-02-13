package model;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class Employee {
    private int id;
    private String name;
    private PositionAtWork positionAtWork;
    private int Salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PositionAtWork getPositionAtWork() {
        return positionAtWork;
    }

    public void setPositionAtWork(PositionAtWork positionAtWork) {
        this.positionAtWork = positionAtWork;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }
}
