package application.entities.operational;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.lang.NonNull;

import application.entities.nonoperational.AccountType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class SavingsAccount extends Account {
	
	// Static Part
	@Getter	@Setter
	private static BigDecimal interestRate;

	// Instance Part
	@NonNull
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customerId")
	private Customer accountOwner;

	public SavingsAccount() {
		setAccountType(AccountType.SAVINGS);
	}
		
}
