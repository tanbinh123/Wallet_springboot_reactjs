package com.mit.wallet.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mit.wallet.entity.Transaction;
import com.mit.wallet.entity.Wallet;
import com.mit.wallet.service.TransactionService;
import com.mit.wallet.service.ValidationErrorService;
import com.mit.wallet.service.WalletService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	@Autowired
	private ValidationErrorService validationService;
	
	@GetMapping("/{wallet_id}")
	public ResponseEntity<?> getAll(@PathVariable Long wallet_id){
		return new ResponseEntity<>(transactionService.getAll(wallet_id),HttpStatus.OK);
	}
	
	@PostMapping("/{wallet_id}")
	public ResponseEntity<?> create(@PathVariable Long wallet_id,@Valid @RequestBody Transaction transaction,BindingResult result){
		ResponseEntity errors = validationService.validate(result);
		 if(errors != null) return errors;
		 Transaction transactionSaved = transactionService.createOrUpdate(wallet_id,transaction);
		  return new ResponseEntity<Transaction>(transactionSaved,HttpStatus.CREATED);
	}

}
