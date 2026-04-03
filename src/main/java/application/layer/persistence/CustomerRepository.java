package application.layer.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import application.entities.operational.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	@Query("select c.customerId from Customer c where c.customerAccount=null or length(c.customerAccount)<2")
	public List<Integer> getAllEligibleCustomersIds();
}
