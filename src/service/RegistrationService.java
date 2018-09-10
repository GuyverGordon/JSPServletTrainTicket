package service;

import java.sql.SQLException;

import exception.DuplicateUserNameException;
import model.User;

public interface RegistrationService {
	
	public boolean addUser(User user) throws DuplicateUserNameException, SQLException;
	
}
