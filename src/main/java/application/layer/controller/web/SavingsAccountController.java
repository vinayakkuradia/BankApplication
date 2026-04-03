package application.layer.controller.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import application.entities.nonoperational.District;
import application.entities.nonoperational.Sex;
import application.entities.nonoperational.State;
import application.entities.operational.Customer;
import application.entities.operational.SavingsAccount;
import application.layer.service.contract.facade.BankFacade;

@Controller("SavingsAccount")
@RequestMapping(path = "/savingsAccount/")
public class SavingsAccountController {

	private BankFacade bankFacade;

	List<Sex> sexTypes = new ArrayList<Sex>( Arrays.asList(Sex.values()));
	List<District> districts = new ArrayList<District>( Arrays.asList(District.values()));
	List<State> states = new ArrayList<State>( Arrays.asList(State.values()));
	
	@Autowired
	public SavingsAccountController(BankFacade bankFacade) {
		this.bankFacade = bankFacade;
	}
	
	@GetMapping(path = "/addSavingsAccount")
	public String addSavingsAccount(ModelMap map) {
		List<Integer> customerIds = bankFacade.getAllEligibleCustomersIds();
		map.addAttribute("customerIds", customerIds);
		return "savingsaccount/addSavingsAccountStep1";
	}

	@PostMapping(path = "/addSavingsAccountStep1")
	public String addSavingsAccountStep1(HttpServletRequest httpServletRequest, ModelMap map) {
		String selectedCustomerId = httpServletRequest.getParameter("selectedCustomerId");

		if (selectedCustomerId != null) {
			Customer selectedCustomer = bankFacade.getCustomerById(Integer.parseInt(selectedCustomerId));
			SavingsAccount newSavingsAccountObj = new SavingsAccount();
			newSavingsAccountObj.setAccountOwner(selectedCustomer);
			map.addAttribute("sexTypes", sexTypes);
			map.addAttribute("districts", districts);
			map.addAttribute("states", states);
			map.addAttribute("savingsAccount", newSavingsAccountObj);
			return "savingsaccount/addSavingsAccountStep2";
		}
		return "redirect:/savingsAccount/addSavingsAccount";
	}

	@PostMapping(path = "/addSavingsAccountStep2")
	public String addSavingsAccountStep2(ModelMap map, @Valid @ModelAttribute(name = "savingsAccount") SavingsAccount savingsAccount, BindingResult br) {
		if (br.hasErrors()) {
			map.addAttribute("sexTypes", sexTypes);
			map.addAttribute("districts", districts);
			map.addAttribute("states", states);
			return "savingsaccount/addSavingsAccountStep2";
		} else {
			bankFacade.addSavingsAccount(savingsAccount);
			Customer accountOwner = savingsAccount.getAccountOwner();
			accountOwner.setCustomerAccount(savingsAccount);
			bankFacade.updateCustomer(accountOwner);
			return "redirect:/savingsAccount/";
		}
		
	}

	@GetMapping(path = "")
	public String showAllSavingsAccounts(ModelMap map) {
		List<SavingsAccount> savingsAccounts = bankFacade.getAllSavingsAccounts();
		map.addAttribute("savingsAccounts", savingsAccounts);
		return "savingsaccount/showAllSavingsAccounts";
	}

	@GetMapping(path = "/updateSavingsAccount")
	public String updateSavingsAccount(ModelMap map, @RequestParam(name = "accountNumber") String accountNumber) {
		System.err.println("Update SAccNo.: "+accountNumber);
		SavingsAccount existingSavingsAccount = bankFacade.getSavingsAccountById(accountNumber);
		map.addAttribute("savingsAccount", existingSavingsAccount);
		return "savingsaccount/updateSavingsAccount";
	}

	@PostMapping(path = "/updateSavingsAccount")
	public String updateSavingsAccount(@Valid @ModelAttribute(name = "savingsAccount") SavingsAccount savingsAccount, BindingResult br, ModelMap map) {
		if (br.hasErrors()) {
			return "savingsaccount/updateSavingsAccount";
		} else {
			bankFacade.updateSavingsAccount(savingsAccount);
			return "redirect:/savingsAccount/";
		}
		
	}
	
	@GetMapping(path = "/changeActiveStatus")
	public String changeSavingsAccountActiveStatus(@RequestParam(name = "accountNumber") String accountNumber) {
		bankFacade.changeAccountActiveStatus(accountNumber);
		return "redirect:/savingsAccount/"; 
	}

}
