package com.geekster.Employee.address.controller;

import com.geekster.Employee.Address.model.Address;
import com.geekster.Employee.Address.model.Employee;
import com.geekster.Employee.Address.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/addEmployees")
    public void AddEmployees(@RequestBody Employee employies){
        employeeService.add(employies);
    }

    @GetMapping(value = "/getAllEmployee")
    public Iterable<Employee> GetAllEmployee(){
        return employeeService.getAllEmployeeDetails();
    }

    @GetMapping("/getAllEmployeesById/{id}")
    public Optional<Employee> GetAllEmployeesById(@PathVariable Long id){
        return employeeService.getEmployeesId(id);
    }

    @PutMapping(value = "/updateEmployee/{id}")
    public String UpdateEmployee(@RequestBody Employee employee , @PathVariable Long id)
    {
        return employeeService.updateEmployeeNow(employee , id);
    }

    @DeleteMapping(value = "/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployeeDetails(id);
    }

}