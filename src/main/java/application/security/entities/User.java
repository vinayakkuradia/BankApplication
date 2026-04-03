package application.security.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "SecurityUser")
public class User {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true)
	@NotNull(message = "Username is mandatory")
	@Length(min = 3, max = 15, message = "Username should be between 3 - 15 charcters")
	private String username;
	
	@NotNull(message = "Password is mandatory")
	@Length(min = 1, message = "Password hash cannot be of 0 length")
	private String password;
	
	@NotNull(message = "User role is mandatory")
	private String role;
	
	public User(String username, String password, String role) {
		this.username = username.trim().toLowerCase();
		this.password = password;
		this.role = role.toUpperCase();
	}

	public void setRole(String role) {
		this.role = role.trim().toUpperCase();
	}

	public void setUsername(String username) {
		this.username = username.trim().toLowerCase();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", username=");
		builder.append(username);
		builder.append(", role=");
		builder.append(role);
		builder.append("]");
		return builder.toString();
	}
	
}
