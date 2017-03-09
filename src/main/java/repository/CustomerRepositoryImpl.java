package repository;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import model.Customer;
import service.CustomerService;

@Repository("customerRepository")
@Scope("prototype")
public class CustomerRepositoryImpl implements CustomerRepository {
	/*
		CIRCULAR DEPENDENCY ERRORS
	* */
	@Autowired
	CustomerService customerService;

	public List<Customer> findAll() {
		List<Customer> customerList = new ArrayList<Customer>();
		Customer customer = new Customer("Gagan", "Chhabra");
		customer.setFName("Gagan");
		customer.setLName("Chhabra");
		customerList.add(customer);
		return customerList;
	}
}
