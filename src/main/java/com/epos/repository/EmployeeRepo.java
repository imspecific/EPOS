package com.epos.repository;

import com.epos.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	//public Employee getEmployee(long e_Id);
}
