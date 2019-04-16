package com.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="DEPARTMENT")
public class Dept {
	@Id
	@GenericGenerator(name="gen", strategy="increment")
	@GeneratedValue(generator="gen")
	@Column(name="DEPTNO")
	private int deptno;
	@Column(name="DNAME")
	private String name;
	@Column(name="LOC")
	private String loc;
	@OneToMany(mappedBy="dept", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Emp> empList;
	public Dept() {
		this(0, "", "");
	}
	public Dept(int deptno, String name, String loc) {
		this.deptno = deptno;
		this.name = name;
		this.loc = loc;
		this.empList = new ArrayList<>();
	}
	
	public List<Emp> getEmpList() {
		return empList;
	}
	public void setEmpList(List<Emp> empList) {
		this.empList = empList;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	@Override
	public String toString() {
		return String.format("Dept [deptno=%s, name=%s, loc=%s]", deptno, name, loc);
	}
}