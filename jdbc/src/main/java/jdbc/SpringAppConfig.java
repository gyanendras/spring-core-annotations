package jdbc;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

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
	}
	
	@Bean("p0")
	Pen
	getPen(){
		return new Pen("ConfigPen0");
	}
	@Bean("p1")
	Pen getPen2(){
		return new Pen("ConfigPen1");
	}
   
}
