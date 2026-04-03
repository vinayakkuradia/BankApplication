package application.entities.nonoperational;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum State {
	
	ANDAMAN_AND_NICOBAR("Andaman & Nicobar"), ANDHRA_PRADESH("Andhra Pradesh"), ARUNACHAL_PRADESH("Arunachal Pradesh"),
	ASSAM("Assam"),	BIHAR("Bihar"),	CHANDIGARH("Chandigarh"), CHHATTISGARH("Chhattisgarh"), DADRA_NAGAR_HAVELI("Dadra-Nagar Haveli"),
	DELHI("Delhi"),	GOA("Goa"), GUJARAT("Gujarat"), HARYANA("Haryana"), HIMACHAL_PRADESH("Himachal Pradesh"),
	JAMMU_AND_KASHMIR("Jammu and Kashmir"),	JHARKHAND("Jharkhand"),	KARNATAKA("Karnataka"),	KERALA("Kerala"),
	LADAKH("Ladakh"), LAKSHADWEEP("Lakshadweep"), MADHYA_PRADESH("Madhya Pradesh"), MAHARASHTRA("Maharashtra"),
	MANIPUR("Manipur"), MEGHALAYA("Meghalaya"), MIZORAM("Mizoram"), NAGALAND("Nagaland"), ODISHA("Odisha"),
	PUDUCHERRY("Puducherry"), PUNJAB("Punjab"), RAJASTHAN("Rajasthan"), SIKKIM("Sikkim"), TAMIL_NADU("Tamil Nadu"),
	TELANGANA("Telangana"),	TRIPURA("Tripura"), UTTAR_PRADESH("Uttar Pradesh"), UTTARAKHAND("Uttarakhand"), WEST_BENGAL("West Bengal");
	
	private final String state;

	private State() {
		this.state = "";
	}
	
}
