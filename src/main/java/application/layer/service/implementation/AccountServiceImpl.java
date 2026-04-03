package application.layer.service.implementation;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import application.entities.nonoperational.TransactionStatus;
import application.entities.nonoperational.TransactionType;
import application.entities.operational.Account;
import application.entities.operational.Transaction;
import application.exception.EntityNotFoundException;
import application.exception.InactiveAccountException;
import application.exception.InsufficientFundsException;
import application.layer.persistence.AccountRepository;
import application.layer.service.contract.AccountService;
import application.layer.service.contract.TransactionService;


@Repository
@Transactional
public class AccountServiceImpl implements AccountService {

	AccountRepository accountRepository;
	TransactionService transactionService;

	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository, TransactionService transactionService) {
		this.accountRepository = accountRepository;
		this.transactionService = transactionService;
	}

	@Override
	public BigDecimal withdraw(String accountNumber, BigDecimal amount) {
		Account account = accountRepository.findById(accountNumber).orElseThrow(() -> new EntityNotFoundException("Account not found"));
		if (account.getAccountActiveStatus()) {
			BigDecimal currentBalance = account.getAccountBalance();
			if (currentBalance.subtract(amount).compareTo(Account.getMinAccountBalance()) >= 0) {
				account.setAccountBalance(currentBalance.subtract(amount));
				accountRepository.save(account);
			} else {
				throw new InsufficientFundsException("Minimum account balance condition being violated");
			}

			Transaction withdrawTransaction = new Transaction(TransactionType.WITHDRAW, amount,
					account.getAccountBalance(), TransactionStatus.NA);
			withdrawTransaction.setSourceAccount(account);
			transactionService.addTransaction(withdrawTransaction);
		}
		else throw new InactiveAccountException("Account is inactive!");

		return account.getAccountBalance();
	}

	@Override
	public BigDecimal deposit(String accountNumber, BigDecimal amount) {
		Account account = accountRepository.findById(accountNumber).orElseThrow(() -> new EntityNotFoundException("Account not found"));
		if (account.getAccountActiveStatus()) {
			BigDecimal currentBalance = account.getAccountBalance();
			account.setAccountBalance(currentBalance.add(amount));
			accountRepository.save(account);

			Transaction depositTransaction = new Transaction(TransactionType.DEPOSIT, amount, account.getAccountBalance(),
					TransactionStatus.NA);
			depositTransaction.setTargetAccount(account);
			transactionService.addTransaction(depositTransaction);
		}
		else throw new InactiveAccountException("Account is inactive!");
		
		return account.getAccountBalance();
	}

	@Override
	public BigDecimal transfer(String sourceAccountNumber, String targetAccountNumber, BigDecimal amount) {
		Account sourceAccount = accountRepository.findById(sourceAccountNumber).orElseThrow(() -> new EntityNotFoundException("Source Account not found"));
		Account targetAccount = accountRepository.findById(targetAccountNumber).orElseThrow(() -> new EntityNotFoundException("Target Account not found"));
		if (sourceAccount.getAccountActiveStatus() && targetAccount.getAccountActiveStatus()) {
			if (sourceAccount.getAccountBalance().subtract(amount).compareTo(Account.getMinAccountBalance()) >= 0) {
				BigDecimal sourceAccountCurrentBalance = sourceAccount.getAccountBalance();
				BigDecimal targetAccountCurrentBalance = targetAccount.getAccountBalance();
				TransactionStatus transactionStatus = TransactionStatus.PENDING;

				if (Account.getApprovalAmountLimit().compareTo(amount) >= 0) {
					if (sourceAccountCurrentBalance.subtract(amount).compareTo(Account.getMinAccountBalance()) >= 0) {
						sourceAccount.setAccountBalance(sourceAccountCurrentBalance.subtract(amount));
						targetAccount.setAccountBalance(targetAccountCurrentBalance.add(amount));
						accountRepository.save(sourceAccount);
						accountRepository.save(targetAccount);
						transactionStatus = TransactionStatus.NA;
					}
				}

				Transaction transferTransaction = new Transaction(TransactionType.TRANSFER, amount,
						sourceAccount.getAccountBalance(), transactionStatus);
				transferTransaction.setSourceAccount(sourceAccount);
				transferTransaction.setTargetAccount(targetAccount);
				transactionService.addTransaction(transferTransaction);
			} 
			else throw new InsufficientFundsException("Minimum account balance condition being violated");
		}
		else throw new InactiveAccountException("Source or Target account is inactive!");
		
		return sourceAccount.getAccountBalance();
	}

	@Override
	public void changeAccountActiveStatus(String accountNumber) {
		Account account = accountRepository.findById(accountNumber).orElseThrow(() -> new EntityNotFoundException("Account not found"));
		account.setAccountActiveStatus(!account.getAccountActiveStatus());
		accountRepository.save(account);
	}

}
