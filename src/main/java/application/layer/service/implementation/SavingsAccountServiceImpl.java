package application.layer.service.implementation;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import application.entities.operational.SavingsAccount;
import application.layer.persistence.SavingsAccountRepository;

@Repository
@Transactional
public class SavingsAccountServiceImpl implements application.layer.service.contract.SavingsAccountService {

	private SavingsAccountRepository savingsAccountRepository;
	
	public SavingsAccountServiceImpl(SavingsAccountRepository savingsAccountRepository) {
		this.savingsAccountRepository = savingsAccountRepository;
	}

	@Override
	public List<String> getAllSavingsAccountsNumbers() {
		return savingsAccountRepository.getAllSavingsAccountsNumbers();
	}
	
	@Override
	public List<SavingsAccount> getAllSavingsAccounts() {
		return savingsAccountRepository.findAll();
	}

	@Override
	public SavingsAccount getSavingsAccountById(String savingsAccountNumber) {
		return savingsAccountRepository.findById(savingsAccountNumber).orElseThrow(null);
	}

	@Override
	public SavingsAccount updateSavingsAccount(SavingsAccount updatedSavingsAccountObj) {
		return savingsAccountRepository.save(updatedSavingsAccountObj);
	}

	@Override
	public void deleteSavingsAccount(String savingsAccountNumber) {
		savingsAccountRepository.delete(getSavingsAccountById(savingsAccountNumber));;
	}

	@Override
	public SavingsAccount addSavingsAccount(SavingsAccount newSavingsAccountObj) {
		return savingsAccountRepository.save(newSavingsAccountObj);
	}

}
