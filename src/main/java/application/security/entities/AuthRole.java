package application.security.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum AuthRole {
	ADMIN("ROLE_ADMIN"), USER("ROLE_USER");
	
	@Setter
	private String role;

	private AuthRole() {
		this.role = "";
	}
	
	public String getPlainRole() {
	return role.split("_")[1];
	}
}