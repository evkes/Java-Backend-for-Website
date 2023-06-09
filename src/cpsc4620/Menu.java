package cpsc4620;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	public static void main(String[] args) throws SQLException, IOException {
		int menu_option = 0;
		
		PrintMenu();
		Scanner scnr = new Scanner(System.in);
		String option = scnr.nextLine();
		menu_option = Integer.parseInt(option);

		while (menu_option != 9) {
			switch (menu_option) {
			case 1:
				ViewPeople();
				break;
			case 2:
				ViewVehicles();
				break;
			case 3:
				ViewSchedules();
				break;
			case 4:
				ViewDrivers();
				break;
			case 5:
				AddPeople(scnr);
				break;
			case 6:
				AddVehicles(scnr);
				break;
			case 7:
				AddSchedules(scnr);
				break;
			case 8:
				AddDrivers(scnr);
				break;
			}
			PrintMenu();
			option = scnr.nextLine();
			menu_option = Integer.parseInt(option);
		}
		scnr.close();
	}

	public static void PrintMenu() {
		System.out.println("\n\nPlease enter a menu option:");
		System.out.println("1. View People");
		System.out.println("2. View Vehicles");
		System.out.println("3. View Schedules");
		System.out.println("4. View Drivers");
		System.out.println("5. Add People");
		System.out.println("6. Add Vehicles");
		System.out.println("7. Add Schedules");
		System.out.println("8. Add Drivers");
		System.out.println("9. Exit\n\n");
		System.out.println("Enter your option: ");
	}

	private static void AddDrivers(Scanner scanner) {
	}

	private static Person SelectPerson(Scanner scanner) throws SQLException, IOException {
		ArrayList<Person> people = DBNinja.getPeople();
		for (int i = 0; i < people.size(); i++) {
			System.out.println((i+1) + ". " + people.get(i));
		}
	
		System.out.print("Enter the number of the person you are: ");
		String ind = scanner.nextLine();
		int personIndex = Integer.parseInt(ind);
	
		if (personIndex < 1 || personIndex > people.size()) {
			System.out.println("Invalid person number. Please try again.");
			SelectPerson(scanner);
		}
	
		Person selectedPerson = people.get(personIndex - 1);
		System.out.println("Selected person: " + selectedPerson);
		return selectedPerson;
	}
	

	private static void AddSchedules(Scanner scanner) {
		Person person = null;
		try {
			person = SelectPerson(scanner);
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		for (String day : daysOfWeek) {
			System.out.println("Enter details for " + day + ":");
			System.out.print("Enter start place: ");
			String startPlace = scanner.nextLine();
			System.out.print("Enter end place: ");
			String endPlace = scanner.nextLine();
			System.out.print("Enter start time (HH:MM:SS): ");
			String startTimeStr = scanner.nextLine();
			Time startTime = Time.valueOf(startTimeStr);
			System.out.print("Enter end time (HH:MM:SS): ");
			String endTimeStr = scanner.nextLine();
			Time endTime = Time.valueOf(endTimeStr);
	
			Schedule schedule = new Schedule(0, startPlace, endPlace, startTime, endTime, day, person.getPersonId());
			try {
				DBNinja.insertSchedule(schedule);
				System.out.println("New schedule added to for person: " + person.getPersonId());
			} catch (SQLException | IOException e) {
				System.out.println("Error adding schedule to database: " + e.getMessage());
			}
		}
	}
	

	private static void AddVehicles(Scanner scanner) {
		System.out.println("Please enter a vehicle license: ");
	}

	private static void AddPeople(Scanner scanner) {
			System.out.print("Enter full name: ");
			String fullname = scanner.nextLine();
			System.out.print("Enter phone number: ");
			String phone = scanner.nextLine();
			UserType userType = null;
			while (userType == null) {
				System.out.print("Enter user type (Rider/Driver/Both): ");
				String userTypeStr = scanner.nextLine();
				try {
					userType = UserType.valueOf(userTypeStr);
				} catch (IllegalArgumentException e) {
					System.out.println("Invalid user type. Please enter either 'Rider', 'Driver', or 'Both'.");
				}
			}
			System.out.print("Enter user location: ");
			String userLoc = scanner.nextLine();
		
			Person person = new Person(0, fullname, phone, userType, userLoc);
			try {
				DBNinja.insertPerson(person);
				System.out.println("New person added to database with ID: " + person.getPersonId());
			} catch (SQLException | IOException e) {
				System.out.println("Error adding person to database: " + e.getMessage());
			}
	}

	private static void ViewDrivers() throws SQLException, IOException {
		ArrayList<Driver> drivers = DBNinja.getDrivers();
		for (Driver d: drivers) {
			System.out.println(d);
		}
	}

	private static void ViewSchedules() throws SQLException, IOException {
		ArrayList<Schedule> schedules = DBNinja.getSchedules();
		for (Schedule s: schedules) {
			System.out.println(s);
		}
	}

	private static void ViewVehicles() throws SQLException, IOException {
		ArrayList<Vehicle> vehicles = DBNinja.getVehicles();
		for (Vehicle v : vehicles) {
			System.out.println(v);
		}
	}

	private static void ViewPeople() throws SQLException, IOException {
		ArrayList<Person> people = DBNinja.getPeople();
		for (Person p : people) {
			System.out.println(p);
		}
	}
}