package application.layer.service.implementation;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import application.entities.nonoperational.TransactionStatus;
import application.entities.nonoperational.TransactionType;
import application.entities.operational.Account;
import application.entities.operational.Transaction;
import application.exception.EntityNotFoundException;
import application.layer.persistence.AccountRepository;
import application.layer.persistence.TransactionRepository;
import application.layer.service.contract.TransactionService;

@Primary
@Repository
@Transactional
public class TransactionServiceImpl implements TransactionService {

	private AccountRepository accountRepository;
	private TransactionRepository transactionRepository;
	
	@Autowired
	public TransactionServiceImpl(AccountRepository accountRepository, TransactionRepository transactionRepository) {
		this.accountRepository = accountRepository;
		this.transactionRepository = transactionRepository;
	}

	@Override
	public List<Integer> getAllTransactionsIds() {
		return transactionRepository.getAllTransactionsIds();
	}

	@Override
	public List<Transaction> getAllTransactionsByAccount(String accountNumber) {
		Account account = accountRepository.findById(accountNumber).orElseThrow(()->new EntityNotFoundException("Account not found"));
		return transactionRepository.getAllTransactionsByAccount(account);
	}
	
	@Override
	public List<Transaction> getAllTransactionsByStatus(TransactionStatus transactionStatus) {
		return transactionRepository.getAllTransactionsByStatus(transactionStatus);
	}
	
	@Override
	public List<Transaction> getAllTransactionsByType(TransactionType transactionType) {
		return transactionRepository.getAllTransactionsByType(transactionType);
	}
	
	@Override
	public List<Transaction> getAllTransactions() {
		return transactionRepository.findAll();
	}

	@Override
	public Transaction getTransactionById(Integer transactionId) {
		return transactionRepository.findById(transactionId).orElseThrow(()->new EntityNotFoundException("Transaction not found"));
	}

	@Override
	public Transaction addTransaction(Transaction newTransactionObj) {
		return transactionRepository.save(newTransactionObj);
	}

	@Override
	public Transaction updateTransaction(Transaction updatedTransactionObj) {
		return transactionRepository.save(updatedTransactionObj);
	}

	@Override
	public void deleteTransaction(Integer transactionId) {
		transactionRepository.delete(getTransactionById(transactionId));
	}

	@Override
	public Transaction approveTransaction(Integer pendingTransactionId) {
		Transaction pendingTransaction = getTransactionById(pendingTransactionId);
		if(pendingTransaction.getTransactionStatus().equals(TransactionStatus.PENDING)) {
			System.err.println("Entered in approveTransaction");;
			Account sourceAccount = pendingTransaction.getSourceAccount();
			BigDecimal sourceAccountCurrentBalance = sourceAccount.getAccountBalance();
			Account targetAccount = pendingTransaction.getTargetAccount();
			BigDecimal targetAccountCurrentBalance = targetAccount.getAccountBalance();
			BigDecimal transactionAmount = pendingTransaction.getTransactionAmount();
			TransactionStatus transactionStatus = TransactionStatus.PENDING;
			if(sourceAccountCurrentBalance.subtract(transactionAmount).compareTo(Account.getMinAccountBalance())>=0) {
				System.err.println("Transferring funds");;
				sourceAccount.setAccountBalance(sourceAccountCurrentBalance.subtract(transactionAmount));
				targetAccount.setAccountBalance(targetAccountCurrentBalance.add(transactionAmount));
				accountRepository.save(sourceAccount);
				accountRepository.save(targetAccount);
				System.err.println("Source: "+sourceAccount);
				System.err.println("Target: "+targetAccount);
				transactionStatus = TransactionStatus.APPROVED;
			}
			pendingTransaction.setClosingBalance(sourceAccount.getAccountBalance());
			pendingTransaction.setTransactionStatus(transactionStatus);
			updateTransaction(pendingTransaction);
		}
		return pendingTransaction;
	}

	@Override
	public Transaction rejectTransaction(Integer pendingTransactionId) {
		Transaction pendingTransaction = getTransactionById(pendingTransactionId);
		if(pendingTransaction.getTransactionStatus().equals(TransactionStatus.PENDING)) {
			if(pendingTransaction.getTransactionStatus().equals(TransactionStatus.PENDING)) {
				transactionRepository.save(pendingTransaction);
			}
		}
		pendingTransaction.setTransactionStatus(TransactionStatus.REJECTED);
		return pendingTransaction;
	}
	
	

}
