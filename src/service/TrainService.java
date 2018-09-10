package service;

import java.sql.SQLException;
import java.util.*;

import model.Train;

public interface TrainService {
	
	public List<Train> getAllTrains() throws SQLException;
	
	public List<Train> getTrains(String source) throws SQLException;
	
	public Train getTrain(int id) throws SQLException;
	
}
