package jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jdbc.dao.EmployeeDao;
import jdbc.model.Employee;

@Component
public class EmployeeService {

	@Autowired
	EmployeeDao empDao;
	
	public List<Employee> getEmployee(){
		return empDao.getEmployees();
		
	}
}
