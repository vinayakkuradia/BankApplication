package application.entities.nonoperational;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum TransactionType {
	DEPOSIT("DEPOSIT"), WITHDRAW("WITHDRAW"), TRANSFER("TRANSFER");
	@Setter
	private String transactionType;

	private TransactionType() {
		this.transactionType = "";
	}
}
