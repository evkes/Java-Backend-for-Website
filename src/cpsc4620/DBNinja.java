package cpsc4620;

import java.io.IOException;
import java.sql.*;
import java.util.*;


public final class DBNinja {
	private static Connection conn;
	
	private static boolean connect_to_db() throws SQLException, IOException {

		try {
			conn = DBConnector.make_connection();
			return true;
		} catch (SQLException e) {
			return false;
		} catch (IOException e) {
			return false;
		}

	}

	public static ArrayList<Person> getPeople() throws SQLException, IOException {
		connect_to_db();
		String query = "SELECT * FROM person";
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery(query);
		
		ArrayList<Person> persons = new ArrayList<>();
		
		while (rset.next()) {
			int personId = rset.getInt("personId");
			String fullname = rset.getString("fullname");
			String phone = rset.getString("phone");
			UserType userType = UserType.valueOf(rset.getString("userType"));
			String userLoc = rset.getString("userLoc");
			
			Person person = new Person(personId, fullname, phone, userType, userLoc);
			persons.add(person);
		}
		
		conn.close();
		return persons;
	}	

	public static ArrayList<Driver> getDrivers() throws SQLException, IOException {
		connect_to_db();
		String query = "SELECT p.personId, p.fullname, p.phone, p.userType, p.userLoc, d.vehicleId FROM person p INNER JOIN driver d ON p.personId = d.personId;";
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery(query);
		
		ArrayList<Driver> drivers = new ArrayList<>();
		
		while (rset.next()) {
			int personId = rset.getInt("personId");
			String fullname = rset.getString("fullname");
			String phone = rset.getString("phone");
			UserType userType = UserType.valueOf(rset.getString("userType"));
			String userLoc = rset.getString("userLoc");
			int vehicleId = rset.getInt("vehicleId");
			
			Driver driver = new Driver(personId, fullname, phone, userType, userLoc, vehicleId);
			drivers.add(driver);
		}
		
		conn.close();
		return drivers;
	}
	
    public static ArrayList<Schedule> getSchedules() throws SQLException, IOException {
		connect_to_db();
		String query = "SELECT * FROM sched";
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery(query);
		
		ArrayList<Schedule> schedules = new ArrayList<>();
		
		while (rset.next()) {
			int schedId = rset.getInt("schedId");
			String startPlace = rset.getString("start_place");
			String endPlace = rset.getString("end_place");
			Time startTime = rset.getTime("start_time");
			Time endTime = rset.getTime("end_time");
			String dayOfWeek = rset.getString("day_of_week");
			int personId = rset.getInt("person_id");
			
			Schedule schedule = new Schedule(schedId, startPlace, endPlace, startTime, endTime, dayOfWeek, personId);
			schedules.add(schedule);
		}
		
		conn.close();
		return schedules;
	}	

    public static ArrayList<Vehicle> getVehicles() throws SQLException, IOException {
		connect_to_db();
		String query = "SELECT * FROM vehicle";
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery(query);
		
		ArrayList<Vehicle> vehicles = new ArrayList<>();
		
		while (rset.next()) {
			int vehicleId = rset.getInt("vehicleId");
			String licensePlate = rset.getString("licensePlate");
			String make = rset.getString("make");
			String model = rset.getString("model");
			int mpg = rset.getInt("mpg");
			
			Vehicle vehicle = new Vehicle(vehicleId, licensePlate, make, model, mpg);
			vehicles.add(vehicle);
		}
		
		conn.close();
		return vehicles;
	}	

	public static void insertPerson(Person person) throws SQLException, IOException {
		connect_to_db();
		String query = "INSERT INTO person (fullname, phone, userType, userLoc) VALUES (?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		pstmt.setString(1, person.getFullname());
		pstmt.setString(2, person.getPhone());
		pstmt.setString(3, person.getUserType().name());
		pstmt.setString(4, person.getUserLoc());
		pstmt.executeUpdate();
		ResultSet generatedKeys = pstmt.getGeneratedKeys();
		if (generatedKeys.next()) {
			int personId = generatedKeys.getInt(1);
			person.setPersonId(personId);
		}
		conn.close();
	}

	public static void insertDriver(Driver driver) throws SQLException, IOException {
		connect_to_db();
		String query = "INSERT INTO driver (personId, vehicleId) VALUES (?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, driver.getPersonId());
		pstmt.setInt(2, driver.getVehicleId());
		pstmt.executeUpdate();
		conn.close();
	}	

	public static void insertSchedule(Schedule schedule) throws SQLException, IOException {
		connect_to_db();
		String query = "INSERT INTO sched (start_place, end_place, start_time, end_time, day_of_week, person_id) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setString(1, schedule.getStartPlace());
		pstmt.setString(2, schedule.getEndPlace());
		pstmt.setTime(3, schedule.getStartTime());
		pstmt.setTime(4, schedule.getEndTime());
		pstmt.setString(5, schedule.getDayOfWeek());
		pstmt.setInt(6, schedule.getPersonId());
		pstmt.executeUpdate();
		conn.close();
	}	

	public static void insertVehicle(Vehicle vehicle) throws SQLException, IOException {
		connect_to_db();
		String query = "INSERT INTO vehicle (vehicleId, licensePlate, make, model, mpg) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, vehicle.getVehicleId());
		pstmt.setString(2, vehicle.getLicensePlate());
		pstmt.setString(3, vehicle.getMake());
		pstmt.setString(4, vehicle.getModel());
		pstmt.setInt(5, vehicle.getMpg());
		pstmt.executeUpdate();
		conn.close();
	}

	

}