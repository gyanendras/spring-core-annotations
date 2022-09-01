package jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configurable
@ComponentScan
public class SpringAppConfig {

	public static void main(String[] args) {
	ApplicationContext context = 
			new AnnotationConfigApplicationContext(SpringAppConfig.class);
    
	
	 Items it = (Items)context.getBean("Items");
	 System.out.println(it.getItems());
	 for(Pen p:it.getItems()) {
		 System.out.println(p.getName());
	 }
	 
	 List l = it.getListFromDB();
	 System.out.println(l);
	}
	
	@Bean("p0")
	Pen
	getPen(){
		return new Pen("ConfigPen0");
	}
	
	@Bean("p1")
	Pen getPen2(){
		return new PenSub();
	}
	
	@Bean
	  public DataSource dataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    //MySQL database we are using
	    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost:3306/hr");//change url
	    dataSource.setUsername("root");//change userid
	    dataSource.setPassword("full2work");//change pwd
	    return dataSource;

	    }
	 
	 @Bean
	  public JdbcTemplate jdbcTemplate() {
	    JdbcTemplate jdbcTemplate = new JdbcTemplate();
	    jdbcTemplate.setDataSource(dataSource());
	    return jdbcTemplate;
	  }
	//DataSource
	//Jdbctemplate
	
   
}
