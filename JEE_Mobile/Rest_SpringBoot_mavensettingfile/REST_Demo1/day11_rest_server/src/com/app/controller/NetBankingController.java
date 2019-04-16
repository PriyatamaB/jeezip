package com.app.controller;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.BankDao;

import pojos.BankAccount;

@RestController
@RequestMapping("/accts")
public class NetBankingController {
	@Autowired
	private BankDao dao;

	// get account summary
	@GetMapping("/{actId}/{pin}")
	public ResponseEntity<?> getSummary(@PathVariable int actId, @PathVariable int pin) {
		BankAccount a=null;
		try {
			a = dao.getSummary(actId, pin);
		} catch (NoResultException e) {
			System.out.println("err in get summary " + e);
			return new ResponseEntity<String>("Invalid A/C details", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<BankAccount>(a, HttpStatus.OK);
	}
	//create new acct
	@PostMapping("/")
	public String createAccount(@RequestBody BankAccount a)
	{
		System.out.println("rest server : "+a);
		return dao.createAccount(a);
	}

}
