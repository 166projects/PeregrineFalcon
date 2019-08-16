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
//		 if((fuser.getGender().matches("[mMfF]{1}")))
//		{
//				 
//		  if(fuser.getCemail().matches("^(.+)@(.+)$")) 
//		 {
//			 if (fuser.getCpass().matches( "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})"))
//	        {
	        	fuserDao.register(fuser);
//	        }
//		 else
//			 throw new BusinessException("enter valid password");
//		 }
//		
//		 else throw new BusinessException("enter valid email");
//	}
//
//		 else throw new BusinessException("enter valid gender");
	}

	public Fuser login(String cid, String password) {
		
		return fuserDao.login(cid, password);
	}

	public void changePassword(String oldpass, String newpass, String cid) {
		   try
		   {
			   if(!oldpass.equals(newpass))
			   
		       {
		    	fuserDao.changePassword(oldpass,newpass,cid);
		      }
		   
		    else
		    {  
		    	 throw new BusinessException("Old and new passswords should not be same");
		    }
		    	
		    }
		   catch(BusinessException e)
		   {
			   System.out.println(e.getMessage());
		   }
			
	}

	public void addAdmin(Fuser fuser) {
		fuserDao.addAdmin(fuser);
	}

	public void deleteAdmin(String id) throws BusinessException {
		if(id!=null)
		    fuserDao.deleteAdmin(id);
		else
			throw new BusinessException("ID does not exist");
			
	}

	public void updateAdmin(Fuser fuser) {
		fuserDao.updateAdmin(fuser);

	}

	public List<Fuser> getAllAdmins() {
		
		return fuserDao.getAllAdmins();
	}

}
