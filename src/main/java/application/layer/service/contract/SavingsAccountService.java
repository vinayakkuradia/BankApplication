package application.layer.service.contract;

import java.util.List;

import application.entities.operational.SavingsAccount;

public interface SavingsAccountService {
	public List<String> getAllSavingsAccountsNumbers();
	public List<SavingsAccount> getAllSavingsAccounts();
	public SavingsAccount getSavingsAccountById(String savingsAccountNumber);
	public SavingsAccount addSavingsAccount(SavingsAccount newSavingsAccountObj);
	public SavingsAccount updateSavingsAccount(SavingsAccount updatedSavingsAccountObj);
	public void deleteSavingsAccount(String savingsAccountNumber);
}
