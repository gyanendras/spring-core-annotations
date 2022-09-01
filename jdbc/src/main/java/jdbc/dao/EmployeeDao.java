package jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.model.Employee;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;  

@Component
public class EmployeeDao {
	@Autowired
	JdbcTemplate jdbctemp;

	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return getListFromDB();
	}
	
	
	 List<Employee> getListFromDB(){
		 //jdbctemp.execute("select * from Employees");
		 String s = "select * from Employees";
		 List l= jdbctemp.queryForList("select * from Employees");
		 List<Employee> emp = jdbctemp.query(s,new RowMapper<Employee>(){

			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				 Employee e=new Employee();  
			        e.setfName(rs.getString(2));
			        e.setlName(rs.getString(3));
			        return e; 
			}
			    
		 });
		 return emp; 
	 }
		
}


