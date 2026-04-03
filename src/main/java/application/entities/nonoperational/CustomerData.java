package application.entities.nonoperational;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
@Embeddable
public class CustomerData {
	
	@Column(name = "Aadhaar")
	@NotNull(message = "Aaadhaar number is mandatory")
	@Pattern(regexp="^[0-9]{12}$", message="Aaadhaar number is of XXXX-XXXX-XXXX form in digits")
	private String aadhaarNumber;
	
	@Column(name = "PAN")
	@NotNull(message = "PAN number is mandatory")
	@Pattern(regexp="^[A-Z]{5}[0-9]{4}[A-Z]{1}$", message="PAN number is of ABCDE0000F form")
	private String panNumber;
	
	@Valid @Embedded
	private Address customerAddress;

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber.toUpperCase();
	}
	
}
