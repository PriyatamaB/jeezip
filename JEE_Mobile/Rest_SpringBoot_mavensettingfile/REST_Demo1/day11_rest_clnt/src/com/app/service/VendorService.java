package com.app.service;

import java.util.List;

import pojos.Part;
import pojos.Vendor;

public interface VendorService {
	List<Vendor> listVendors();
	String registerVendor(Vendor v);
	String updateVendor(Vendor v);
	Vendor getVendorDetails(int id);
	String addPart(int vendorId,Part p);
	

}
