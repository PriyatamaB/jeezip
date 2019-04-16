package com.app.dao;

import pojos.BankAccount;

public interface BankDao {
	BankAccount getSummary(int id,int pin);
	String createAccount(BankAccount a);
	String updateAccount(BankAccount a);
	String closeAccount(int id,int pin);
}
