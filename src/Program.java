import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		Airport afeka = new Airport();
		int day, month, year;
		int choice;
		do {
			System.out.println("1)Add Departure flight ");
			System.out.println("2)Add Arrival flight ");
			System.out.println("3)To Show the list of departures");// from Israel
			System.out.println("4)To Show the list of the arrivals"); // to Israel
			System.out.println("5)Save the details of all flights into a file");
			System.out.println("6)Load the details of all flights from a file ");
			System.out.println("7)Search by Certain Fields");

			choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.print("Enter the destination country: ");
				String destination = scan.next();

				System.out.print("Enter the destination city: ");
				String dCity = scan.next();

				System.out.println("Enter the airport: ");
				String airport = scan.next();

				System.out.println("Enter the flight Company: ");
				String company = scan.next();

				System.out.println("Enter the date of your flight (YYYY MM DD): ");
				boolean checkInput = false;
				LocalDate date = null;
				while (!checkInput) {
					try {
						date = LocalDate.of(scan.nextInt(), scan.nextInt(), scan.nextInt());
						if (date.isAfter(LocalDate.now())) {
							checkInput = true;
						} else
							throw new FilghtExcption("Invalid date");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				System.out.println("Enter the hour: ");
				int hour = scan.nextInt();
				System.out.println("Enter the minute: ");
				int minute = scan.nextInt();

				System.out.println("Enter the flight Number:");
				String flightNumber = scan.next();

				System.out.println("Enter the terminal:");
				int terminal = scan.nextInt();

				DepartureFlight oF = new DepartureFlight(company, destination, date, hour, flightNumber, terminal,
						minute, dCity, airport);
				afeka.addTakingOffFlight(oF);

				break;
			case 2:
				System.out.println("Enter the income country: ");
				String incomeCountry = scan.next();

				System.out.println("Enter the income city: ");
				String incomeCity = scan.next();

				System.out.println("Enter the airport: ");
				String Airport = scan.next();

				System.out.println("Enter the flight Company: ");
				String Company = scan.next();

				System.out.println("Enter the date of your flight (YYYY MM DD): ");
				boolean checkInputA = false;
				LocalDate datee = null;
				while (!checkInputA) {
					try {
						datee = LocalDate.of(scan.nextInt(), scan.nextInt(), scan.nextInt());
						if (datee.isAfter(LocalDate.now())) {
							checkInputA = true;
						} else
							throw new FilghtExcption("Invalid date");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}

				System.out.println("Enter the hour:");
				int h = scan.nextInt();
				System.out.println("Enter the minute:");
				int minutee = scan.nextInt();

				System.out.println("Enter the flight Number:");
				String flightNum = scan.next();

				System.out.println("Enter the terminal:");
				int terminale = scan.nextInt();

				ArrivalFlight iF = new ArrivalFlight(Company, datee, h, flightNum, terminale, incomeCountry, minutee,
						incomeCity, Airport);
				afeka.addLandingFlight(iF);

				break;
			case 3:
				System.out.println(afeka.showAllTakingOffFlight());
				break;
			case 4:
				System.out.println(afeka.showAllLandingFlight());
				break;
			case 5:
				File toFile = new File("flights.txt");
				afeka.save(toFile);
				break;
			case 6:
				File fromFile = new File("flights.txt");
				Scanner s = new Scanner(fromFile);
				afeka = new Airport(s);
				break;
			case 7:
				System.out.println("which type do you want to search:");
				String type = scan.next();

				System.out.println("From which Date you want to search (YYYY MM DD):");
				checkInput = false;
				LocalDate from = null;
				while (!checkInput) {
					try {
						from = LocalDate.of(scan.nextInt(), scan.nextInt(), scan.nextInt());
						if (from.isAfter(LocalDate.now())) {
							checkInput = true;
						} else
							throw new FilghtExcption("Invalid date");
					} catch (Exception e) {
						System.out.println(e.getMessage());
						scan.nextLine();
					}
				}

				System.out.println("Until which Date you want to search (YYYY MM DD):");
				checkInput = false;
				LocalDate until = null;
				while (!checkInput) {
					try {
						until = LocalDate.of(scan.nextInt(), scan.nextInt(), scan.nextInt());
						if (until.isAfter(LocalDate.now())) {
							checkInput = true;
						} else
							throw new FilghtExcption("Invalid date");
					} catch (Exception e) {
						System.out.println(e.getMessage());
						scan.nextLine();
					}

				}

				ArrayList<String> days = new ArrayList<>();
				System.out.println("which days do you want to search:(true/false)");
				System.out.println("Sunday:");
				boolean sunday = scan.nextBoolean();
				if (sunday) {
					days.add("sunday");
				}
				System.out.println("Monday:");
				boolean monday = scan.nextBoolean();
				if (monday) {
					days.add("monday");
				}
				System.out.println("Tuesday:");
				boolean tuesday = scan.nextBoolean();
				if (tuesday) {
					days.add("tuesday");
				}
				System.out.println("Wednesday:");
				boolean wednesday = scan.nextBoolean();
				if (wednesday) {
					days.add("wednesday");
				}
				System.out.println("Thursday:");
				boolean thursday = scan.nextBoolean();
				if (thursday) {
					days.add("thursday");
				}
				System.out.println("Friday:");
				boolean friday = scan.nextBoolean();
				if (friday) {
					days.add("friday");
				}
				System.out.println("Saturday:");
				boolean saturday = scan.nextBoolean();
				if (saturday) {
					days.add("saturday");
				}

				System.out.println("which country do you want to search:");
				scan.nextLine();
				String country = scan.next();

				System.out.println("which city do you want to search:");
				scan.nextLine();
				String city = scan.next();

				System.out.println("which company do you want to search:");
				scan.nextLine();
				String companyy = scan.next();

				System.out.println("which airport do you want to search:");
				scan.nextLine();
				String airportt = scan.next();

				System.out.println(afeka.searchConsole(type, from, until, country, city, companyy, airportt, days));
			}
		} while (choice != 8);

	}

}
