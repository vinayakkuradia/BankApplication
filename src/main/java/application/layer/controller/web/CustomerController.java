package application.layer.controller.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import application.entities.nonoperational.District;
import application.entities.nonoperational.Sex;
import application.entities.nonoperational.State;
import application.entities.operational.Customer;
import application.layer.service.contract.facade.BankFacade;

@Controller("customer")
@RequestMapping(path = "/customer/")
public class CustomerController {

	private BankFacade bankFacade;
	
	List<Sex> sexTypes = new ArrayList<Sex>(Arrays.asList(Sex.values()));
	List<District> districts = new ArrayList<District>(Arrays.asList(District.values()));
	List<State> states = new ArrayList<State>(Arrays.asList(State.values()));
	
	@Autowired
	public CustomerController(BankFacade bankFacade) {
		this.bankFacade = bankFacade;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	@GetMapping(path = "/addCustomer")
	public String addCustomer(ModelMap map) {
		map.addAttribute("sexTypes", sexTypes);
		map.addAttribute("districts", districts);
		map.addAttribute("states", states);
		map.addAttribute("customer", new Customer());
		return "customer/addCustomer";
	}

	@PostMapping(path = "/addCustomer")
	public String addCustomer(@Valid @ModelAttribute(name = "customer") Customer customer, BindingResult br, ModelMap map) {
		if (br.hasErrors()) {
			map.addAttribute("sexTypes", sexTypes);
			map.addAttribute("districts", districts);
			map.addAttribute("states", states);
			return "customer/addCustomer";
		} else {
			bankFacade.addCustomer(customer);
			return "redirect:/customer/";
		}
	}

	@GetMapping(path = "")
	public String showAllCustomers(ModelMap map) {
		List<Customer> customers = bankFacade.getAllCustomers();
		map.addAttribute("customers", customers);
		return "customer/showAllCustomers";
	}

	@GetMapping(path = "/updateCustomer")
	public String updateCustomer(ModelMap map, @RequestParam(name = "customerId") Integer customerId) {
		Customer existingCustomer = bankFacade.getCustomerById(customerId);
		map.addAttribute("sexTypes", sexTypes);
		map.addAttribute("districts", districts);
		map.addAttribute("states", states);
		map.addAttribute("customer", existingCustomer);
		return "customer/updateCustomer";
	}

	@PostMapping(path = "/updateCustomer")
	public String updateCustomer(@Valid @ModelAttribute(name = "customer") Customer customer, BindingResult br, ModelMap map) {
		
		if (br.hasErrors()) {
			map.addAttribute("sexTypes", sexTypes);
			map.addAttribute("districts", districts);
			map.addAttribute("states", states);
			return "customer/updateCustomer";
		} else {
			Customer existingCustomer = bankFacade.getCustomerById(customer.getCustomerId());
			updateCustomerDetails(customer, existingCustomer);
			bankFacade.updateCustomer(existingCustomer);
			return "redirect:/customer/";
		}

	}

	private Customer updateCustomerDetails(Customer sourceCustomerObj, Customer existingCustomerObj) {
		existingCustomerObj.setCustomerName(sourceCustomerObj.getCustomerName());
		existingCustomerObj.setCustomerSex(sourceCustomerObj.getCustomerSex());
		existingCustomerObj.setDateOfBirth(sourceCustomerObj.getDateOfBirth());
		existingCustomerObj.setMobileNumber(sourceCustomerObj.getMobileNumber());
		existingCustomerObj.setCustomerData(sourceCustomerObj.getCustomerData());
		return existingCustomerObj;
	}

	@GetMapping(path = "/deleteCustomer")
	public String deleteCustomer(@RequestParam(name = "customerId") Integer customerId) {
		bankFacade.deleteCustomer(customerId);
		return "customer/addCustomer";
	}
}
