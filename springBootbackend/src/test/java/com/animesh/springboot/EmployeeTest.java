package com.animesh.springboot;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.animesh.springboot.model.Employee;
import com.animesh.springboot.repository.EmployeeRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class EmployeeTest {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Test
	@Rollback(false)
	public void testCreate() {
		Employee employee = new Employee("chetan","tingase","chetan@yahoo.in");
		Employee saveEmp = employeeRepository.save(employee);
		assertNotNull(saveEmp);
	}
	
	@Test
	@Rollback(false)
	public void testUpdate() {
		Employee employee = new Employee("chetan","tingase","chetan@yahoo.in");
		employee.setId(3);
		employeeRepository.save(employee);
		
		Optional<Employee> updatedEmployee = employeeRepository.findById((long) 9);
		assertThat(updatedEmployee.equals(employee));
	}
	
	@Test
	public void testGetAllEmployees() {
		List<Employee> employee = (List<Employee>)employeeRepository.findAll();
		for(Employee emp : employee) {
			System.out.println(emp);
		}
		assertThat(employee).size().isGreaterThan(0);
	}
	
}
