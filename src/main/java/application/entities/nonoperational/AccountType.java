package application.entities.nonoperational;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum AccountType {
	SAVINGS("SAV"), CURRENT("CUR");
	
	private String accountType;

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
}
