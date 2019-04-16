package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.FileDao;
import com.pojos.Dept;
import com.pojos.Emp;


@Service
public class FileServiceImpl implements FileService {
    @Autowired
	FileDao dao;
	@Override
	public void upload(Emp f) {
	
     dao.upload(f);
		
	}
	@Override
	public Emp findEmp(String ename) {
	
		return dao.findEmp(ename);
	}
	@Override
	public List<Dept> getDeptList() {
		
		return dao.getDeptList();
	}
	

}
