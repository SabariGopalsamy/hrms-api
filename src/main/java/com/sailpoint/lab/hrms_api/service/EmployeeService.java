package com.sailpoint.lab.hrms_api.service;

import com.sailpoint.lab.hrms_api.entity.Employee;
import com.sailpoint.lab.hrms_api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get employee by ID
    public Employee getEmployeeById(Integer id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElse(null);
    }
    // Create Employee
    public Employee createEmployee(Employee employee) {
    return employeeRepository.save(employee);
}
// Update Employee
public Employee updateEmployee(Integer id, Employee employee) {

    Employee existingEmployee = employeeRepository.findById(id).orElse(null);

    if (existingEmployee == null) {
        return null;
    }

    existingEmployee.setEmployeeNumber(employee.getEmployeeNumber());
    existingEmployee.setFirstName(employee.getFirstName());
    existingEmployee.setLastName(employee.getLastName());
    existingEmployee.setEmail(employee.getEmail());
    existingEmployee.setDepartment(employee.getDepartment());
    existingEmployee.setDesignation(employee.getDesignation());
    existingEmployee.setStatus(employee.getStatus());

    return employeeRepository.save(existingEmployee);
}
// Delete Employee
public String deleteEmployee(Integer id) {

    Employee employee = employeeRepository.findById(id).orElse(null);

    if (employee == null) {
        return "Employee not found";
    }

    employeeRepository.delete(employee);

    return "Employee deleted successfully";
}
}