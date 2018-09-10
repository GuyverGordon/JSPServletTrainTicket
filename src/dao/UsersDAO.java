package dao;

import model.User;

public interface UsersDAO {
	
	public User getUser(String username);
	
	public boolean insertUser(User user);
	
}
