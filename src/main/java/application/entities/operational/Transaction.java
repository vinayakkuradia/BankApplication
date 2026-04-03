package application.entities.operational;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import application.entities.nonoperational.TransactionStatus;
import application.entities.nonoperational.TransactionType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "`transaction`")
public class Transaction {

	@Id @Column(name = "txnId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer transactionId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sourceAccNo")
	private Account sourceAccount;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "targetAccNo")
	private Account targetAccount;
	
	@Column(name = "type")
	private TransactionType transactionType;
	
	@NotNull(message = "Transaction amount cannot be null")
	@DecimalMin(value = "0.00", message = "Transaction amount cannot be less than 0")
	private BigDecimal transactionAmount;
	
	@NotNull(message = "Transaction amount cannot be null")
	@DecimalMin(value = "0.00", message = "Balance cannot be less than 0")
	private BigDecimal closingBalance;
	
	@NotNull(message = "Transaction time stamp is mandatory")
	private LocalDateTime transactionTimeStamp;
	
	@NotNull(message = "Transaction status cannot be null")
	private TransactionStatus transactionStatus;
	
	
	public Transaction() {
		this.transactionTimeStamp = LocalDateTime.now();
	}


	public Transaction(TransactionType transactionType, BigDecimal transactionAmount, BigDecimal closingBalance, TransactionStatus transactionStatus) {
		this();
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.closingBalance = closingBalance;
		this.transactionStatus = transactionStatus;
	}	
	
}
