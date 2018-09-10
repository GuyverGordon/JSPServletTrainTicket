package service.impl;

import java.sql.SQLException;
import java.util.List;

import dao.jdbc.JdbcTrainDAO;
import model.Train;
import service.TrainService;

public class TrainServiceImpl implements TrainService {
	
	private JdbcTrainDAO tDao;
	
	public TrainServiceImpl() {
		tDao = new JdbcTrainDAO();
	}
	
	@Override
	public List<Train> getAllTrains() throws SQLException {
		
		List<Train> trains = tDao.findAllTrains();
		
		return trains;
	}

	@Override
	public List<Train> getTrains(String source) throws SQLException {
		
		List<Train> trains = tDao.findTrains(source);
		
		return trains;
		
	}
	
	@Override
	public Train getTrain(int id) throws SQLException {
		
		Train train = tDao.findTrain(id);
		
		return train;
		
	}

}
