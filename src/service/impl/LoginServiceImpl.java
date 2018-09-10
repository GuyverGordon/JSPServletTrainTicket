package service.impl;

import service.LoginService;

import java.sql.SQLException;

import dao.jdbc.*;

public class LoginServiceImpl implements LoginService{
	
	private JdbcUsersDAO uDao;
	
	public LoginServiceImpl() {
		uDao = new JdbcUsersDAO();
	}
	
	@Override
	public boolean loginValidate(String username, String password) {
		boolean valid = false;
		
		try {
			valid = uDao.getUser(username).getPassword().equals(password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return valid;
	}
	
}
