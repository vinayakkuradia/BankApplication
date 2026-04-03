package application.layer.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("SiteController")
@RequestMapping(path = "/")
public class SiteController {

	@GetMapping(path = "")
	public String loginController() {
		return "site/login";
	}
	
	@GetMapping(path = "home")
	public String homeController() {
		return "site/home";
	}
	
}
