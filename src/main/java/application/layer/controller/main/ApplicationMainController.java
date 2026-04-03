package application.layer.controller.main;

import application.security.entities.AuthRole;

public class ApplicationMainController {

	public static void main(String[] args) {
		AuthRole aa = AuthRole.ADMIN;
		System.out.println(aa.getPlainRole());
	}
	
	
}
