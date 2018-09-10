package test;

import java.util.*;

import dao.jdbc.*;
import model.*;

public class TestMain {

	public static void main(String[] args) {
		
//		testTrain();
//		System.out.println("--------------------");
//		testUser();
//		System.out.println("--------------------");
//		testTicket();
		
	}
	
	public static void testTrain() {
		System.out.println("Testing TrainDAO ...");
		System.out.println("Finding Train 1001 ...");
		System.out.println();
		
		JdbcTrainDAO dao = new JdbcTrainDAO();
		
		try {
		Train train = dao.findTrain(1001);
		System.out.println("Train number: " + train.getTrainNo());
		System.out.println("Train name: " + train.getTrainName());
		System.out.println("Source: " + train.getSource());
		System.out.println("Destination:" + train.getDestination());
		System.out.println("Ticket Price: " + train.getTicketPrice());
		
		System.out.println();
		System.out.println("Finding all trains from Bangalore to Delhi");
		
		List<Train> trains = dao.findTrains("Bangalore", "Delhi");
		
		for (Train train1 : trains) {
			System.out.println(train1.getTrainNo() + " " + train1.getTrainName() 
				+ " " + train1.getSource() + " " + train1.getDestination() 
				+ " " + train1.getTicketPrice());
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void testUser() {
		System.out.println("Testing UserDAO ...");
		JdbcUsersDAO dao = new JdbcUsersDAO();
		
		System.out.println("Inserting Test User (Test, test, test@test.com)");
		try {
			System.out.println(dao.insertUser(new User("Test", "test", "test@test.com")));
		} catch (Exception e) {
			System.out.println("Error user 1");
		}
		
		System.out.println();
		System.out.println("Finding Test User");
		
		try {
			User user = dao.getUser("Test");
			System.out.println(user.getUsername() + " " + user.getPassword() + " " + user.getEmail());
		} catch (Exception e) {
			System.out.println("Error user 2");
		}
	}
	
	public static void testTicket() {
		System.out.println("Testing Ticket ...");
	}
	
}
