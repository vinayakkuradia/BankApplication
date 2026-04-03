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
public class SingleAccountTransactionDto {
	
	@Pattern(regexp="^[a-zA-Z0-9]+$", message="Account number can only contain numbers and letters")
	String accountNumber;
	
	@NotNull(message = "Amount cannot be null")
	BigDecimal amount;
	
}
