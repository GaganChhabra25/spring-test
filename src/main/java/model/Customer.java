package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Customer {

	private String fName;
	private String lName;

	public Customer(String fName, String lName) {
		this.fName = fName;
		this.lName = lName;
	}
}
