package com.app.dao;

import java.util.List;

import pojos.Part;
import pojos.Vendor;

public interface VendorDao {
	List<Vendor> listVendors();
	String registerVendor(Vendor v);
	Vendor getVendorDetails(int id);
	String updateVendor(Vendor detachedVendor);
	String addPart(Vendor v);

}
