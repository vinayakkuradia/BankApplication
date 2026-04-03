package application.entities.nonoperational;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Name {
	
	@NotNull @Length(min = 3, max = 15, message = "First Name should be between 3-15 characters")
	public String firstName;
	
	@Length(max = 15, message = "Middle Name cannot be greater than 15 characters")
	public String middleName;
	
	@NotNull @Length(min = 3, max = 15, message = "Last Name should be between 3-15 characters")
	public String lastName;

	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getName() {
		StringBuilder nameBuilder = new StringBuilder();
		nameBuilder.append(firstName).append(" ").append(lastName);
		return nameBuilder.toString();
	}

	public String getFullName() {
		StringBuilder nameBuilder = new StringBuilder();
		nameBuilder.append(firstName).append(" ").append(middleName).append(" ").append(lastName);
		return nameBuilder.toString();
	}

	public void setName(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void setFullName(String firstName, String middleName, String lastName) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(firstName);
		if(middleName!=null) {
			builder.append(" "+middleName);
		}
		builder.append(" "+lastName);
		return builder.toString();
	}
	
	
}