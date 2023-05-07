package com.geekster.Employee.Address.service;

import com.geekster.Employee.Address.model.Address;
import com.geekster.Employee.Address.model.Employee;
import com.geekster.Employee.Address.repository.IEmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    IEmployeeRepository employeeRepository;

    public void add(Employee employies) {
        employeeRepository.save(employies);
    }

    public Iterable<Employee> getAllEmployeeDetails() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeesId(Long id) {
        return employeeRepository.findById(id);
    }
    @Transactional
    public String updateEmployeeNow(Employee employee, Long id) {
        employeeRepository.updateEmployee(employee.getFirstName() , employee.getLastName() , id);
        return "Employee Updated!!";
    }

    public String deleteEmployeeDetails(Long id) {
        employeeRepository.deleteById(id);
        return "Employee deleted!!";
    }

}