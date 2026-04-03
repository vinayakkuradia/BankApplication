package application.entities.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TransferDto {
	
	@Pattern(regexp="^[a-zA-Z0-9]+$", message="Source account number can only contain numbers and letters")
	String sourceAccountNumber;
	
	@Pattern(regexp="^[a-zA-Z0-9]+$", message="Target account number can only contain numbers and letters")
	String targetAccountNumber;
	
	@NotNull(message = "Amount cannot be null")
	BigDecimal amount;
	
}
