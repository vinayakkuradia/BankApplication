package application.entities.nonoperational;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum TransactionStatus {
	APPROVED("APPROVED"), PENDING("PENDING"), REJECTED("REJECTED"), NA("NA");
	
	@Setter
	private String transactionStatus;

	private TransactionStatus() {
		this.transactionStatus = "";
	}
}
