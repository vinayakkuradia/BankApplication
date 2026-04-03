package application.layer.service.contract;

import java.util.List;

import application.entities.nonoperational.TransactionStatus;
import application.entities.nonoperational.TransactionType;
import application.entities.operational.Transaction;

public interface TransactionService {
	public List<Integer> getAllTransactionsIds();
	public List<Transaction> getAllTransactionsByAccount(String accountNumber);
	public List<Transaction> getAllTransactionsByStatus(TransactionStatus transactionStatus);
	public List<Transaction> getAllTransactionsByType(TransactionType transactionType);
	public List<Transaction> getAllTransactions();
	public Transaction getTransactionById(Integer transactionId);
	public Transaction addTransaction(Transaction newTransactionObj);
	public Transaction updateTransaction(Transaction updatedTransactionObj);
	public void deleteTransaction(Integer transactionId);
	public Transaction approveTransaction(Integer pendingTransactionId);
	public Transaction rejectTransaction(Integer pendingTransactionId);
}
