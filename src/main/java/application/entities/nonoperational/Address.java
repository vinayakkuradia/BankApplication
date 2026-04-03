package application.entities.nonoperational;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
public class Address {
	
	@Column(name = "house")
	@NotNull(message = "House number cannot be null")
	@Length(min = 1, max = 10, message = "House no. should be between 3-10 characters")
	public String houseNumber;
	
	@NotNull(message = " cannot be null")
	@Length(min = 5, max = 35, message = "Locality name should be between 5-35 characters")
	public String locality;
	
	@NotNull(message = "Landmark cannot be null")
	@Length(min = 5, max = 35, message = "Landmark should be between 5-35 characters")
	public String landmark;
	
	@NotNull(message = "City cannot be null")
	@Length(min = 3, max = 20, message = "City name should be between 3-20 characters")
	public String city;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "District cannot be null")
	public District district;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "State cannot be null")
	public State state;
	
	@Pattern(regexp="^[0-9]{6}$", message="PIN code contains total 6 digits")
	public String pinCode;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(houseNumber).append(" ");
		if(locality!=null)
		builder.append(locality).append(" ");
		if(landmark!=null)
		builder.append(landmark).append(" ");
		if(city!=null)
		builder.append(city).append(" ");
		builder.append(district).append(" ");
		builder.append(state).append(" ");
		if(pinCode!=null)
		builder.append(pinCode);
		return builder.toString();
	}
	
	
}