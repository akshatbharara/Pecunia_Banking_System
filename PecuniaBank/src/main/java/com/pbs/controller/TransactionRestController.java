package com.pbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pbs.model.Account;
import com.pbs.service.TransactionServiceImpl;

/**
 * @author Akshat Bharara
 * Description: It is a Rest full controller class that helps to use the services for Transaction.
 * version: 1.0
 * Last Modified Date: 07-May-2020
 *
 */
@CrossOrigin(origins="*")  
@RestController
@RequestMapping("/pbs")
public class TransactionRestController {

	@Autowired
	TransactionServiceImpl transactionService;
	
	

	@PostMapping("/transaction/accounts")
	public String createAccount(@RequestBody Account account) {
		Account acc = transactionService.addAccount(account);
		return "Hello " + acc.getCustomer_name() + "\n Your Registration is Successfull\n" + "Your Account Id is "
				+ acc.getAccount_id();
	}

	@GetMapping("slipcredit")
	public String creditUsingSlip(@RequestParam long id, @RequestParam double amount, @RequestParam String slipNo)
			throws Exception {
		Account acc = transactionService.creditUsingSlip(id, amount, slipNo);

		if (acc == null) {
			throw new Exception("Invalid id");
		}
		
		return "Hello " + acc.getCustomer_name() + "\n Your Amount is Deposited Succesfully\n"
				+ "Your Current Account Balance is " + acc.getAmount();

	}

	@GetMapping("slipdebit")
	public String debitUsingSlip(@RequestParam long id, @RequestParam double amount, @RequestParam String slipNo)
			throws Exception {
		Account acc = transactionService.debitUsingSlip(id, amount, slipNo);

		if (acc == null) {
			throw new Exception("Invalid id");
		}
		if(acc.getAmount()< amount) {
			throw new Exception("Insufficient Balance, Please add balance to perform transactions");
		}

		return "Hello " + acc.getCustomer_name() + "\n Your Amount is Withdrawn Succesfully\n"
				+ "Your Current Account Balance is " + acc.getAmount();
		

	}

	@GetMapping("chequecredit") 
	public String creditUsingCheque(@RequestParam long id, @RequestParam double amount, @RequestParam String chequeNo)
			throws Exception {
		Account acc = transactionService.creditUsingCheque(id, amount, chequeNo);

		if (acc == null) {
			throw new Exception("Invalid id");
		}
		return "Hello " + acc.getCustomer_name() + "\n Your Amount is Deposited Succesfully\n"
				+ "Your Current Account Balance is " + acc.getAmount();

	}


	@GetMapping("chequedebit")
	public String debitUsingCheque(@RequestParam long id, @RequestParam double amount, @RequestParam String chequeNo)
			throws Exception {
		Account acc = transactionService.debitUsingCheque(id, amount, chequeNo);

		if (acc == null) {
			throw new Exception("Invalid id");
		}
		if(acc.getAmount()< amount) {
			throw new Exception("Cheque Bounced, Please add balance to perform Transactions");
		}

		return "Hello " + acc.getCustomer_name() + "\n Your Amount is Withdrawn Succesfully\n"
				+ "Your Current Account Balance is " + acc.getAmount();

	}

	@ExceptionHandler(Exception.class)
	public String inValid(Exception e) {
		return e.getMessage();
	}

}
