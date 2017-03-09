package model;


import lombok.Getter;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("employee")
@Getter
@NoArgsConstructor
@PropertySource(value = "classpath:Employee.properties")
public class Employee {

	@Value("${first.name}")
	private String fName;
	private String lName;

	public Employee(String fName, String lName) {
		this.fName = fName;
		this.lName = lName;
	}

	@Required
	public void setfName(String fName) {
		this.fName = fName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}
}
