package com.mphasis.flight.dao;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.flight.entities.Fuser;

@Repository
public class FuserDaoImpl implements FuserDao{

	@Autowired
	SessionFactory sessionFactory;
	public void register(Fuser fuser) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(fuser);
		tr.commit();

	}

	public Fuser login(int cid, String password) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Fuser fuser=(Fuser) session.get(Fuser.class, cid);
		if(cid==fuser.getCid()&&fuser.getCpass().equals(password))
		{
		    return fuser;
		}
		else 
		{
			return null;
		}
		
		
	}

	public void changePassword(String oldpass, String newpass,int cid) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Fuser fuser=(Fuser) session.get(Fuser.class, cid);
		if(oldpass.equals(fuser.getCpass()))
		{
			fuser.setCpass(newpass);
			session.save(fuser);
			tr.commit();
		}

	}

	public void addAdmin(Fuser fuser) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(fuser);
		tr.commit();
		
	}

	public void deleteAdmin(String id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Fuser fuser=(Fuser) session.get(Fuser.class, id);
		session.delete(fuser);
		tr.commit();
		
	}

	public void updateAdmin(Fuser fuser) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(fuser);
		tr.commit();
	}

	public List<Fuser> getAllAdmins() {
		Session session=sessionFactory.openSession();
		List<Fuser> fusers= session.createCriteria(Fuser.class).list();
		return fusers;
	}

	
}
