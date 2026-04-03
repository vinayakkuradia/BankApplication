package application.entities.nonoperational;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum Sex {
	MALE("M"), FEMALE("F"), TRANS("T"), OTHER("O");
	@Setter
	private String sex;

	private Sex() {
		this.sex = "";
	}
	
}
