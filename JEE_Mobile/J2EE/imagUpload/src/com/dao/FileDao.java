package com.dao;

import java.util.List;

import com.pojos.Dept;
import com.pojos.Emp;


public interface FileDao {

	void upload(Emp e);
	Emp findEmp(String ename);
    List<Dept> getDeptList();
    
}
