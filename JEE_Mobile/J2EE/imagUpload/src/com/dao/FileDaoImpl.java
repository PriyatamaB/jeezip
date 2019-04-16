package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pojos.Dept;
import com.pojos.Emp;


@Transactional
@Repository
public class FileDaoImpl implements FileDao {

	@Autowired
	SessionFactory factory;
	
	@Override
	public void upload(Emp e)
	{
	    Session session=factory.getCurrentSession();
	    session.save(e);
	}

	

	@Override
	public Emp findEmp(String ename) {
		Session session=factory.getCurrentSession();
		Criteria cr=session.createCriteria(Emp.class);
		cr.add(Restrictions.eq("name",ename));
		return (Emp) cr.uniqueResult();
	}



	@Override
	public List<Dept> getDeptList() {
		Session session=factory.getCurrentSession();
		Criteria cr=session.createCriteria(Dept.class);
	   cr.setProjection(Projections.distinct(Projections.property("deptno")));
	   List<Integer> ids=cr.list();
	   List<Dept> deptlist=new ArrayList<Dept>();
	   for (Integer object:ids) {
		   Dept d=(Dept) session.get(Dept.class,object);
		   deptlist.add(d);
	   }
	    
		return deptlist;
	}
	

}
