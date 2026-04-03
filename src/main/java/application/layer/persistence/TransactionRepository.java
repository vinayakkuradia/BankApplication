package application.layer.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import application.entities.nonoperational.TransactionStatus;
import application.entities.nonoperational.TransactionType;
import application.entities.operational.Account;
import application.entities.operational.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	@Query("select t.transactionId from Transaction t")
	public List<Integer> getAllTransactionsIds();
	
	@Query("from Transaction where transactionType= :transactionType")
	public List<Transaction> getAllTransactionsByType(@Param("transactionType") TransactionType transactionType);
	
	@Query("from Transaction where transactionStatus= :transactionStatus")
	public List<Transaction> getAllTransactionsByStatus(@Param("transactionStatus") TransactionStatus transactionStatus);
	
	@Query("from Transaction where sourceAccount= :account or targetAccount= :account")
	public List<Transaction> getAllTransactionsByAccount(@Param("account") Account account);
}
