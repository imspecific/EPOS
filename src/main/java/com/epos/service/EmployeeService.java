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

    public Employee findByE_Id(long e_Id) {
        return employeeRepo.findById(e_Id).get();
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }
}
