package application.entities.operational;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import application.entities.nonoperational.CustomerData;
import application.entities.nonoperational.Name;
import application.entities.nonoperational.Sex;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Customer {
	
	@Id @Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer customerId;
	
	@Valid @Embedded
	@Column(name = "name")
	private Name customerName;
	
	@Column(name = "sex")
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Sex value is mandatory")
	private Sex customerSex;
	
	@Column(name = "mobile")
	@NotNull(message = "Mobile number is mandatory")
	@Length(min = 10, max = 10, message = "Mobile number should be of 10 charcters")
	private String mobileNumber;
	
	@Column(name = "dob")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull(message = "D.O.B. is mandatory")
	private Date dateOfBirth;
	
	@Valid @Embedded
	private CustomerData customerData;
	
	@OneToOne
	@ToString.Exclude
	@JoinColumn(name = "accountNumber")
	private SavingsAccount customerAccount;
	
}
