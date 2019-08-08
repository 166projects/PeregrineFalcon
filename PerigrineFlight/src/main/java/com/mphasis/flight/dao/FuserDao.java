package com.mphasis.flight.dao;

import java.util.List;

import com.mphasis.flight.entities.Fuser;

public interface FuserDao {

	public void register(Fuser fuser);
	public Fuser login(int cid,String password);
	public void changePassword(String oldpass,String newpass,int cid);
	public void addAdmin(Fuser fuser);
	public void deleteAdmin(String id);
	public void updateAdmin(Fuser fuser);
	public List<Fuser> getAllAdmins();
}
