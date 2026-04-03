package application.layer.service.contract;

import java.util.List;

import application.entities.operational.Customer;

public interface CustomerService {
	public List<Integer> getAllEligibleCustomersIds();
	public List<Customer> getAllCustomers();
	public Customer getCustomerById(Integer customerId);
	public Customer addCustomer(Customer newCustomerObj);
	public Customer updateCustomer(Customer updatedCustomerObj);
	public void deleteCustomer(Integer customerId);
}
