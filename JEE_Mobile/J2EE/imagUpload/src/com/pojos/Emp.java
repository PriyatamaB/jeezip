package com.pojos;

import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name="EMPLOYEE")
public class Emp {
	@Id
	@GenericGenerator(name="gen", strategy="increment")
	@GeneratedValue(generator="gen")
	@Column(name="EMPNO")
	private int empno;
	@Column(name="ENAME")
	private String name;
	@Column(name="SAL")
	private double sal;
	
	@Column(name="file_upload",columnDefinition="longblob")
	private byte[] file_upload;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="DEPTNO")
	
	private Dept dept;
	
	
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}

	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	
	
	
	
	public byte[] getFile_upload() {
		return file_upload;
	}
	public void setFile_upload(byte[] file_upload) {
		this.file_upload = file_upload;
	}
	@Override
	public String toString() {
		return String.format("Emp [empno=%s, name=%s, sal=%s]", empno, name, sal);
	}
}