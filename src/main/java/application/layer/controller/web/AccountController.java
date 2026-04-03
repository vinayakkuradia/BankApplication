package application.layer.controller.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import application.entities.dto.SingleAccountTransactionDto;
import application.entities.dto.TransferDto;
import application.layer.service.contract.facade.BankFacade;

@Controller("Account")
@RequestMapping(path = "/account/")
public class AccountController {

	private BankFacade bankFacade;

	@Autowired
	public AccountController(BankFacade bankFacade) {
		this.bankFacade = bankFacade;
	}

	@GetMapping(path = "")
	public String operations(ModelMap map) {
		return "account/operations";
	}

	@GetMapping(path = "/deposit")
	public String deposit(ModelMap map) {
		map.addAttribute("depositDto", new SingleAccountTransactionDto());
		return "account/deposit";
	}

	@PostMapping(path = "/deposit")
	public String deposit(@Valid @ModelAttribute(name = "depositDto") SingleAccountTransactionDto depositDto, BindingResult br) {
		
		if (br.hasErrors()) {
			return "account/deposit";
		} else {
			bankFacade.deposit(depositDto.getAccountNumber(), depositDto.getAmount());
			return "redirect:/account/";
		}
		
	}

	@GetMapping(path = "/withdraw")
	public String withdraw(ModelMap map) {
		map.addAttribute("withdrawDto", new SingleAccountTransactionDto());
		return "account/withdraw";
	}

	@PostMapping(path = "/withdraw")
	public String withdraw(@Valid @ModelAttribute(name = "withdrawDto") SingleAccountTransactionDto withdrawDto, BindingResult br) {
		
		if (br.hasErrors()) {
			return "account/withdraw";
		} else {
			bankFacade.withdraw(withdrawDto.getAccountNumber(), withdrawDto.getAmount());
		return "redirect:/account/";
		}
		
	}

	@GetMapping(path = "/transfer")
	public String transfer(ModelMap map) {
		map.addAttribute("transferDto", new TransferDto());
		return "account/transfer";
	}

	@PostMapping(path = "/transfer")
	public String transfer(@Valid @ModelAttribute(name = "transferDto") TransferDto transferDto, BindingResult br) {
		if (br.hasErrors()) {
			return "account/transfer";
		} else {
			bankFacade.transfer(transferDto.getSourceAccountNumber(), transferDto.getTargetAccountNumber(), transferDto.getAmount());
			return "redirect:/account/";
		}
		
	}

}
