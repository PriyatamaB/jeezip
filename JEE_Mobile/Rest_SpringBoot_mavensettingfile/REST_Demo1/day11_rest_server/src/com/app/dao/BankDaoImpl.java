package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pojos.BankAccount;

@Repository
@Transactional
public class BankDaoImpl implements BankDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public BankAccount getSummary(int id1, int pin1) {
		System.out.println("dao : get summary " + id1 + " " + pin1);
		return sf.getCurrentSession()
				.createQuery("select a from BankAccount a where a.acctId = :id and a.pin = :pin", BankAccount.class)
				.setParameter("id", id1).setParameter("pin", pin1).getSingleResult();
	}

	@Override
	public String createAccount(BankAccount a) {
		sf.getCurrentSession().persist(a);
		return "A/C created with ID " + a.getAcctId();
	}

	@Override
	public String updateAccount(BankAccount a) {
		sf.getCurrentSession().update(a);
		return "A/C updated with ID " + a.getAcctId();
	}

	@Override
	public String closeAccount(int id, int pin) {
		BankAccount a = getSummary(id, pin);
		sf.getCurrentSession().delete(a);
		return "A/c Closed with ID " + a.getAcctId();
	}

}
