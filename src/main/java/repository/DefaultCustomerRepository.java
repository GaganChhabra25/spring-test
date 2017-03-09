package repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import model.Customer;

@Repository("defaultCustomerRepository")
public class DefaultCustomerRepository implements CustomerRepository {

	@Override
	public List<Customer> findAll() {
		Customer customer = new Customer("Default", "customer from repository");
		List<Customer> customerList = new ArrayList<Customer>();
		customerList.add(customer);
		return customerList;
	}
}
