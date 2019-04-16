package com.service;

import java.util.List;

import com.pojos.Dept;
import com.pojos.Emp;

public interface FileService {
	
	void upload(Emp f);
	public Emp findEmp(String ename) ;
	List<Dept> getDeptList();
	
}
