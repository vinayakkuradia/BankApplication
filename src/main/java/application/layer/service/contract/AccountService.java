package application.layer.service.contract;

import java.math.BigDecimal;

public interface AccountService {
	public BigDecimal withdraw(String accountNumber, BigDecimal amount);
	public BigDecimal deposit(String accountNumber, BigDecimal amount);
	public BigDecimal transfer(String sourceAccountNumber, String targetAccountNumber, BigDecimal amount);
	public void changeAccountActiveStatus(String accountNumber);
}
