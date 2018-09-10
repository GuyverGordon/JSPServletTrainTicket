package dao.jdbc;

import java.sql.*;

import util.DbUtil;
import model.User;

public class JdbcUsersDAO {
	
	public User getUser(String username) throws ClassNotFoundException, SQLException {
		
		Connection conn = DbUtil.getConnection();
		PreparedStatement ps = conn.prepareStatement("select password, email from regd_users "
				+ "where username = ?");
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		User user;
		
		if (rs.next()) {
			String password = rs.getString(1);
			String email = rs.getString(2);
			user = new User(username, password, email);
		} else {
			DbUtil.closeConnection(conn);
			return null;
		}
		
		DbUtil.closeConnection(conn);
		return user;
		
	}
	
	public boolean insertUser(User user) throws SQLException {
		boolean success = false;
		Connection conn = null;
		
		try {
			conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into regd_users"
					+ "(username, password, email) values (?, ?, ?)");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.executeUpdate();
			success = true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeConnection(conn);
		}
		
		return success;
		
	}
	
	public boolean isDuplicateUser(User user) {
		boolean found = false;
		try {
			User target = getUser(user.getUsername());
			if (target != null) {
				found = true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return found;
	}
}
