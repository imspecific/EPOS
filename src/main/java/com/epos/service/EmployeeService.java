package com.epos.service;

import com.epos.model.Employee;
import com.epos.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee addEmployee(Employee emp) {
		return employeeRepo.save(emp);
    }

    public Employee findByEmployeeId(long employeeId) {
        return employeeRepo.findById(employeeId).get();
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }
}
