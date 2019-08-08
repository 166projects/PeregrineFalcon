package com.mphasis.flight.bo;

import java.util.List;

import com.mphasis.flight.entities.Fuser;
import com.mphasis.flight.exceptions.BusinessException;

public interface FuserBo {

	public void register(Fuser fuser)throws BusinessException;
	public Fuser login(int cid,String password);
	public void changePassword(String oldpass,String newpass,int cid);
	public void addAdmin(Fuser fuser);
	public void deleteAdmin(String id)throws BusinessException;
	public void updateAdmin(Fuser fuser);
	public List<Fuser> getAllAdmins();
}
