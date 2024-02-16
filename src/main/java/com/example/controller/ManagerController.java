package com.example.controller;

import com.example.model.Employee;
import com.example.model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.repository.ManagerRepository;

import java.util.List;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    private ManagerRepository managerRepository;

    @Autowired
    public ManagerController(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @GetMapping("/list")
    public String getAllManager(Model model) {
        model.addAttribute("managers", managerRepository.getAllManager());
        return "manager-list";
    }

    @GetMapping("/add")
    public String addManagerPage(Model model) {
        model.addAttribute("manager", new Manager());
        return "manager-page";
    }

    @PostMapping("/add")
    public String addManager(@ModelAttribute("manager") Manager manager) {
        managerRepository.createManager(manager);
        return "redirect:/manager/list";
    }

    @GetMapping("/update/{id}")
    public String updateManagerPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("manager", managerRepository.getManagerById(id));
        return "manager-page";
    }

    @PostMapping("/edit/{id}")
    public String updateManager(@ModelAttribute("manager") Manager manager, @PathVariable("id") int id){
        managerRepository.updateManager(id, manager);
        return "redirect:/manager/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteManager(@PathVariable("id") int id){
        managerRepository.deleteManager(id);
        return "redirect:/manager/list";
    }

    @GetMapping("/{id}/employees")
    public String getEmployee(@PathVariable("id") int managerId, Model model){
        Manager manager = managerRepository.getManagerById(managerId);
        List<Employee> employees = managerRepository.getManagersEmployees(manager);
        model.addAttribute("manager", manager);
        model.addAttribute("employees", employees);
        return "manager-employee-list";
    }

}
