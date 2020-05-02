import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		Airport afeka = new Airport();

		int choice;
		do {
			System.out.println("1)Add Departure flight ");
			System.out.println("2)Add Arrival flight ");
			System.out.println("3)To Show the list of departures");// from Israel
			System.out.println("4)To Show the list of the arrivals"); // to Israel
			System.out.println("5)Save the details of all flights into a file");
			System.out.println("6)Load the details of all flight from a file ");
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.printf("Enter the destination: ");
				String destination = scan.next();

				System.out.println("Enter the flight Company: ");
				String company = scan.next();

				System.out.println("Enter the date of your flight: ");
				int day, month, year;
				day = scan.nextInt();
				month = scan.nextInt();
				year = scan.nextInt();
				Date date = new Date(day, month, year);

				System.out.println("Enter the hour: ");
				int hour = scan.nextInt();
				System.out.println("Enter the minute: ");
				int minute = scan.nextInt();

				System.out.println("Enter the flight Number:");
				String flightNumber = scan.next();

				System.out.println("Enter the terminal:");
				int terminal = scan.nextInt();

				DepartureFlight oF = new DepartureFlight(company, destination, date, hour, flightNumber, terminal,
						minute);
				afeka.addTakingOffFlight(oF);

				break;
			case 2:
				System.out.printf("Enter the income country: ");
				String incomeCountry = scan.next();
				
				System.out.println("Enter the flight Company: ");
				String Company = scan.next();

				System.out.println("Enter the date of your flight: ");
				int d, m, y;
				d = scan.nextInt();
				m = scan.nextInt();
				y = scan.nextInt();
				Date datee = new Date(d, m, y);

				System.out.println("Enter the hour:");
				int h = scan.nextInt();
				System.out.println("Enter the minute:");
				int minutee = scan.nextInt();

				System.out.println("Enter the flight Number:");
				String flightNum = scan.next();

				System.out.println("Enter the terminal:");
				int terminale = scan.nextInt();

				ArrivalFlight iF = new ArrivalFlight(Company, datee, h, flightNum, terminale, incomeCountry, minutee);
				afeka.addLandingFlight(iF);

				break;
			case 3:
				System.out.println(afeka.showAllTakingOffFlight());
				break;
			case 4:
				System.out.println(afeka.showAllLandingFlight());
				break;
			case 5:
				afeka.save();
				break;
			case 6:
				File file = new File("flights.txt");
				Scanner s = new Scanner(file);
				afeka = new Airport(s);
				break;

			}
		} while (choice != 7);

	}

	public void createFlight() {

	}

}
