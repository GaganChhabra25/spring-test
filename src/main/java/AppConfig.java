import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import model.Employee;

@Configuration
@ComponentScan(basePackages = {"model", "repository", "service"})
public class AppConfig {

	@Bean
	public Employee setFirstName() {
		Employee employee = new Employee();
		employee.setfName("employee");
		return employee;
	}
}
