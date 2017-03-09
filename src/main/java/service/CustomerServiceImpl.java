package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Customer;
import repository.CustomerRepository;

@Service("customerServiceImpl")
public class CustomerServiceImpl implements CustomerService {

/*	// PROBLEM : Harcoded object
	CustomerRepository customerRepository = new HibernateCustomerRepository();*/

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

}
