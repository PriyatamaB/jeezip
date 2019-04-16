package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pojos.Part;
import pojos.Vendor;

@Repository
public class VendorDaoImpl implements VendorDao {
	@Autowired
	private SessionFactory sf;

	@Override
	public List<Vendor> listVendors() {
		String jpql = "select v from Vendor v";
		return sf.getCurrentSession().createQuery(jpql, Vendor.class).getResultList();
	}

	@Override
	public String registerVendor(Vendor v) {
		sf.getCurrentSession().persist(v);
		return "Vendor registered successfully ID " + v.getId();
	}

	@Override
	public Vendor getVendorDetails(int id) {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().get(Vendor.class, id);
	}

	@Override
	public String updateVendor(Vendor detachedVendor) {
		// TODO Auto-generated method stub
		sf.getCurrentSession().update(detachedVendor);
		return "Vendor details updated ";
	}

	@Override
	public String addPart(Vendor v) {
		sf.getCurrentSession().update(v);
		return "Part added By Vendor with ID " + v.getId();
	}

}
