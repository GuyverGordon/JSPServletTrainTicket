package dao.jdbc;

import java.sql.*;
import java.util.*;

import dao.TrainDAO;
import model.Train;
import util.DbUtil;

public class JdbcTrainDAO implements TrainDAO {
	
	public Train findTrain(int trainNo) throws SQLException {
		
		Train train;
		Connection conn = null;
		
		try {
			conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from trains "
					+ "where train_no = ?");
			ps.setInt(1, trainNo);
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			// 1 = train number, 2 = train name, 3 = source, 4 = destination, 5 = ticket price
			train = new Train(rs.getInt(1), rs.getString(2), rs.getString(3), 
					rs.getString(4), rs.getDouble(5));
			
			return train;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DbUtil.closeConnection(conn);
		}	
		
	}
	
	public List<Train> findAllTrains() throws SQLException {
		
		List<Train> trains = new ArrayList<Train>();
		Connection conn = null;
		
		try {
			conn = DbUtil.getConnection();
			ResultSet rs = conn.createStatement().executeQuery("select * from trains");
			while (rs.next()) {
				trains.add(new Train(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5)));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DbUtil.closeConnection(conn);
		}
		
		if (trains.isEmpty())
			return null;
		else
			return trains;
		
	}
	
	public List<Train> findTrains(String source, String destination) throws SQLException {
		
		List<Train> trains;
		Connection conn = null;
		
		try {
			conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from trains "
					+ "where source = ? and destination = ?");
			ps.setString(1, source);
			ps.setString(2, destination);
			ResultSet rs = ps.executeQuery();
			
			trains = new ArrayList<Train>();
			
			while(rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String src = rs.getString(3);
				String dest = rs.getString(4);
				double price = rs.getDouble(5);
				
				Train train = new Train(no, name, src, dest, price);
				trains.add(train);
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DbUtil.closeConnection(conn);
		}
		
		if (trains.isEmpty())
			return null;
		else
			return trains;
		
	}
	
	public List<Train> findTrains(String source) throws SQLException {
		List<Train> trains;
		Connection conn = null;
		
		try {
			conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from trains "
					+ "where source = ?");
			ps.setString(1, source);
			ResultSet rs = ps.executeQuery();
			
			trains = new ArrayList<Train>();
			
			while(rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String src = rs.getString(3);
				String dest = rs.getString(4);
				double price = rs.getDouble(5);
				
				Train train = new Train(no, name, src, dest, price);
				trains.add(train);
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DbUtil.closeConnection(conn);
		}
		
		if (trains.isEmpty())
			return null;
		else
			return trains;
	}
	
}
