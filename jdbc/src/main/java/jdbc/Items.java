package jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("Items")
public class Items {
   
	@Autowired
	@Qualifier("p0")
   	Pen p0;
	
	@Autowired
	JdbcTemplate jdbctemp;
   
   @Autowired
   @Qualifier("p1")
    Pen p1;
   
    Pen p2 = new Pen("Pen2");
		
 public List<Pen> getItems(){
	ArrayList<Pen> listPen = new ArrayList<Pen>();
	listPen.add(p0);
	listPen.add(p1);
	listPen.add(p2);
	return listPen;
	
	
 }
 
 List getListFromDB(){
	 //jdbctemp.execute("select * from Employees");
	 List l= jdbctemp.queryForList("select * from Employees");
	 return l;
 }
 
 public static void main(String[] args) {
	 Items item = new Items();
	System.out.println(item.getItems()); 
 }
}
