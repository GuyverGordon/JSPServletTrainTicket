package dao;

import java.sql.SQLException;
import java.util.List;

import model.Train;

public interface TrainDAO {
	
	public Train findTrain(int trainNo) throws SQLException;
	
	public List<Train> findAllTrains() throws SQLException;
	
	public List<Train> findTrains(String source, String destination) throws SQLException;
	
	public List<Train> findTrains(String source) throws SQLException;
	
}
