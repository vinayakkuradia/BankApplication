package application.layer.service.contract.facade;

import application.layer.service.contract.AccountService;
import application.layer.service.contract.CustomerService;
import application.layer.service.contract.SavingsAccountService;
import application.layer.service.contract.TransactionService;

public interface BankFacade extends AccountService, CustomerService, SavingsAccountService, TransactionService {
	
}
