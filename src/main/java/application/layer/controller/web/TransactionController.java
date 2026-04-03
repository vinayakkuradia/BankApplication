package application.layer.controller.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import application.entities.nonoperational.TransactionStatus;
import application.entities.operational.Transaction;
import application.layer.service.contract.facade.BankFacade;

@Controller("Transaction")
@RequestMapping(path = "/transaction/")
public class TransactionController {

	private BankFacade bankFacade;

	@Autowired
	public TransactionController(BankFacade bankFacade) {
		this.bankFacade = bankFacade;
	}
	
	
	@GetMapping(path = "transactionsByAccount")
	public String filterTransactionsByAccount(@RequestParam(name = "accountNumber") String accountNumber, ModelMap map) {
		List<Transaction> transactions = bankFacade.getAllTransactionsByAccount(accountNumber);
		map.addAttribute("transactions", transactions);
		return "transaction/showAllTransactions";
	}
	
	
	@GetMapping(path = "")
	public String showAllTransactions(ModelMap map) {
		List<Transaction> transactions = bankFacade.getAllTransactions();
		List<TransactionStatus> transactionStatus = new ArrayList<TransactionStatus>( Arrays.asList(TransactionStatus.values()));
		map.addAttribute("transactions", transactions);
		map.addAttribute("transactionStatus", transactionStatus);
		return "transaction/showAllTransactions";
	}
	
	@GetMapping(path = "approveTransaction")
	public String approveTransaction(@RequestParam(name = "transactionId") Integer transactionId) {
		bankFacade.approveTransaction(transactionId);
		return "redirect:/transaction/";
	}
	
	@GetMapping(path = "rejectTransaction")
	public String rejectTransaction(@RequestParam(name = "transactionId") Integer transactionId) {
		bankFacade.rejectTransaction(transactionId);
		return "redirect:/transaction/";
	}
	
}
