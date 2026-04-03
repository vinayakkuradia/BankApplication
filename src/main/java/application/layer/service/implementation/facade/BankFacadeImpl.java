package application.layer.service.implementation.facade;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import application.entities.nonoperational.TransactionStatus;
import application.entities.nonoperational.TransactionType;
import application.entities.operational.Customer;
import application.entities.operational.SavingsAccount;
import application.entities.operational.Transaction;
import application.layer.service.contract.AccountService;
import application.layer.service.contract.CustomerService;
import application.layer.service.contract.SavingsAccountService;
import application.layer.service.contract.TransactionService;
import application.layer.service.contract.facade.BankFacade;

@Repository
@Transactional
public class BankFacadeImpl implements BankFacade {

	private AccountService accountService;
	private CustomerService customerService;
	private SavingsAccountService savingsAccountService;
	private TransactionService transactionService;
	
	@Autowired
	public BankFacadeImpl(AccountService accountService, CustomerService customerService, SavingsAccountService savingsAccountService, TransactionService transactionService) {
		this.accountService = accountService;
		this.customerService = customerService;
		this.savingsAccountService = savingsAccountService;
		this.transactionService = transactionService;
	}

	// Accounts
	
	@Override
	public BigDecimal withdraw(String accountNumber, BigDecimal amount) {
		return accountService.withdraw(accountNumber, amount);
	}

	@Override
	public BigDecimal deposit(String accountNumber, BigDecimal amount) {
		return accountService.deposit(accountNumber, amount);
	}

	@Override
	public BigDecimal transfer(String sourceAccountNumber, String targetAccountNumber, BigDecimal amount) {
		return accountService.transfer(sourceAccountNumber, targetAccountNumber, amount);
	}
	
	@Override
	public void changeAccountActiveStatus(String accountNumber) {
		accountService.changeAccountActiveStatus(accountNumber);
	}

	// Customers
	
	@Override
	public List<Integer> getAllEligibleCustomersIds() {
		return customerService.getAllEligibleCustomersIds();
	}
	
	@Override
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	@Override
	public Customer getCustomerById(Integer customerId) {
		return customerService.getCustomerById(customerId);
	}

	@Override
	public Customer addCustomer(Customer newCustomerObj) {
		return customerService.addCustomer(newCustomerObj);
	}

	@Override
	public Customer updateCustomer(Customer updatedCustomerObj) {
		return customerService.updateCustomer(updatedCustomerObj);
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		customerService.deleteCustomer(customerId);
	}
	
	// Saving Accounts
	
	@Override
	public List<String> getAllSavingsAccountsNumbers() {
		return savingsAccountService.getAllSavingsAccountsNumbers();
	}
	
	@Override
	public List<SavingsAccount> getAllSavingsAccounts() {
		return savingsAccountService.getAllSavingsAccounts();
	}

	@Override
	public SavingsAccount getSavingsAccountById(String savingsAccountNumber) {
		return savingsAccountService.getSavingsAccountById(savingsAccountNumber);
	}

	@Override
	public SavingsAccount addSavingsAccount(SavingsAccount newSavingsAccountObj) {
		return savingsAccountService.addSavingsAccount(newSavingsAccountObj);
	}
	
	@Override
	public SavingsAccount updateSavingsAccount(SavingsAccount updatedSavingsAccountObj) {
		return savingsAccountService.updateSavingsAccount(updatedSavingsAccountObj);
	}

	@Override
	public void deleteSavingsAccount(String savingsAccountNumber) {
		savingsAccountService.deleteSavingsAccount(savingsAccountNumber);
	}

	// Transactions
	
	@Override
	public List<Integer> getAllTransactionsIds() {
		return transactionService.getAllTransactionsIds();
	}

	@Override
	public List<Transaction> getAllTransactionsByAccount(String accountNumber) {
		return transactionService.getAllTransactionsByAccount(accountNumber);
	}

	@Override
	public List<Transaction> getAllTransactionsByStatus(TransactionStatus transactionStatus) {
		return transactionService.getAllTransactionsByStatus(transactionStatus);
	}
	
	@Override
	public List<Transaction> getAllTransactionsByType(TransactionType transactionType) {
		return transactionService.getAllTransactionsByType(transactionType);
	}

	@Override
	public List<Transaction> getAllTransactions() {
		return transactionService.getAllTransactions();
	}

	@Override
	public Transaction getTransactionById(Integer transactionId) {
		return transactionService.getTransactionById(transactionId);
	}

	@Override
	public Transaction addTransaction(Transaction newTransactionObj) {
		return transactionService.addTransaction(newTransactionObj);
	}

	@Override
	public Transaction updateTransaction(Transaction updatedTransactionObj) {
		return transactionService.updateTransaction(updatedTransactionObj);
	}

	@Override
	public void deleteTransaction(Integer transactionId) {
		transactionService.deleteTransaction(transactionId);
	}

	@Override
	public Transaction approveTransaction(Integer pendingTransactionId) {
		return transactionService.approveTransaction(pendingTransactionId);
	}

	@Override
	public Transaction rejectTransaction(Integer pendingTransactionId) {
		return transactionService.rejectTransaction(pendingTransactionId);
	}

}
