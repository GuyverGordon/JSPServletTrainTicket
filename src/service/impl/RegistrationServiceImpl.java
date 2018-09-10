package service.impl;

import java.sql.SQLException;

import dao.jdbc.JdbcUsersDAO;
import exception.DuplicateUserNameException;
import model.User;
import service.RegistrationService;

public class RegistrationServiceImpl implements RegistrationService {
	
	private JdbcUsersDAO uDao;
	
	public RegistrationServiceImpl() {
		uDao = new JdbcUsersDAO();
	}
	
	@Override
	public boolean addUser(User user) throws DuplicateUserNameException, SQLException {
		boolean success = false;
		
		if (!isDuplicateUser(user)) {
			success = uDao.insertUser(user);
		} else {
			throw new DuplicateUserNameException("Username already exists");
		}
		
		return success;
	}
	
	private boolean isDuplicateUser(User user) throws DuplicateUserNameException {
		boolean status = false;
		 if(uDao.isDuplicateUser(user) == true)
		 {	 
			 status = true;
			 throw new DuplicateUserNameException("Username Already exists");
		 }
		 else
			 status = false;
		 
		 return status;
	}

}
