package application.layer.service.implementation;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import application.entities.operational.Customer;
import application.layer.persistence.CustomerRepository;
import application.layer.service.contract.CustomerService;

@Repository
@Transactional
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@Override
	public List<Integer> getAllEligibleCustomersIds() {
		return customerRepository.getAllEligibleCustomersIds();
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(Integer customerId) {
		return customerRepository.findById(customerId).orElseThrow(null);
	}

	@Override
	public Customer updateCustomer(Customer updatedCustomerObj) {
		return customerRepository.save(updatedCustomerObj);
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		customerRepository.delete(getCustomerById(customerId));;
	}

	@Override
	public Customer addCustomer(Customer newCustomerObj) {
		return customerRepository.save(newCustomerObj);
	}

}
