package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import model.Customer;

@Service("defaultCustomerServiceImpl")
@Primary
public class DefaultCustomerServiceImpl implements CustomerService {

	@Override
	public List<Customer> findAll() {
		Customer customer = new Customer("Default", "customer from service");
		List<Customer> customerList = new ArrayList<Customer>();
		customerList.add(customer);
		return customerList;
	}
}
