package com.mphasis.flight.bo;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.flight.dao.FuserDao;
import com.mphasis.flight.entities.Fuser;
import com.mphasis.flight.exceptions.BusinessException;
@Service
public class FuserBoImpl implements FuserBo{

	@Autowired
	FuserDao fuserDao;
	
	public void register(Fuser fuser) throws BusinessException {
		 if(fuser.getGender().matches("[mMfF]{1}")) 
	        {
	        	fuserDao.register(fuser);
	        }
		 else
			 throw new BusinessException("entered invalid gender");

	}

	public Fuser login(int cid, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public void changePassword(String oldpass, String newpass, int cid) {
		// TODO Auto-generated method stub

	}

	public void addAdmin(Fuser fuser) {
		// TODO Auto-generated method stub

	}

	public void deleteAdmin(String id) {
		// TODO Auto-generated method stub

	}

	public void updateAdmin(Fuser fuser) {
		// TODO Auto-generated method stub

	}

	public List<Fuser> getAllAdmins() {
		// TODO Auto-generated method stub
		return null;
	}

}
