package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.VendorDao;

import pojos.Part;
import pojos.Vendor;

@Service
@Transactional
public class VendorServiceImpl implements VendorService {
	@Autowired
	private VendorDao dao;

	@Override
	public List<Vendor> listVendors() {

		return dao.listVendors();
	}

	@Override
	public String registerVendor(Vendor v) {
		// TODO Auto-generated method stub
		return dao.registerVendor(v);
	}

	@Override
	public String updateVendor(Vendor v) {
		// TODO Auto-generated method stub
		return dao.updateVendor(v);
	}

	@Override
	public Vendor getVendorDetails(int id) {
		// TODO Auto-generated method stub
		return dao.getVendorDetails(id);
	}

	@Override
	public String addPart(int vid, Part p) {
		System.out.println("vendor service "+vid+"\n"+p);
		Vendor v=dao.getVendorDetails(vid);//rets PERSISTENT Vendor POJO
		v.addPart(p);
		return dao.addPart(v);
	}
	

}
