package application.entities.operational;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import application.entities.nonoperational.AccountType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Account {

	// Static Part
	@Getter	@Setter
	private static BigDecimal minAccountBalance=new BigDecimal(1000);
	
	@Getter	@Setter
	private static BigDecimal approvalAmountLimit=new BigDecimal(200000);
	
	// Instance Part
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String accountNumber;
	
	@Column(name = "isActive")
	@NotNull(message = "Account active status is mandatory") 
	private Boolean accountActiveStatus;
	
	@Column(name = "balance")
	@NotNull(message = "Account balance is mandatory")
	@DecimalMin(value = "0.00", message = "Balance cannot be less than 0")
	private BigDecimal accountBalance;
	
	@Column(name = "creationDate")
	@NotNull(message = "Account creation date is mandatory")
	private Date accountCreationDate;
	
	@Column(name = "accType")
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Account type is mandatory")
	private AccountType accountType;
	
	@OneToMany
	@ToString.Exclude
	private List<Transaction> accountTransactions;
	
	public Account() {
		this.accountActiveStatus = true;
		this.accountCreationDate = new Date();
	}
	
	public Account(String accountNumber, BigDecimal accountBalance) {
		this();
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
	}

	protected void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	
	
}
