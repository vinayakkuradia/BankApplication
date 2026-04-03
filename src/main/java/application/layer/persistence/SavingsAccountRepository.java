package application.layer.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import application.entities.operational.SavingsAccount;

@Repository
public interface SavingsAccountRepository extends JpaRepository<SavingsAccount, String> {
	@Query("select sa.accountNumber from SavingsAccount sa")
	public List<String> getAllSavingsAccountsNumbers();
}
