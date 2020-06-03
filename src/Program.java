import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
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
			System.out.println("7)Search by Dates");
			
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.print("Enter the destination country: ");
				String destination = scan.next();
				
				System.out.print("Enter the destination city: ");
				String dCity = scan.next();
				
				System.out.println("Enter the flight Company: ");
				String company = scan.next();

				System.out.println("Enter the date of your flight: ");
				boolean checkInput=false;
				LocalDate date = null;
				while(!checkInput){
					try {
						date=LocalDate.of(scan.nextInt(), scan.nextInt(), scan.nextInt());
						if(date.isAfter(LocalDate.now())) {
							checkInput=true;
						}else throw new FilghtExcption("Invalid date");
					}catch(Exception e) {
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

				DepartureFlight oF = new DepartureFlight(company, destination, date, hour, flightNumber, terminal,minute,dCity);
				afeka.addTakingOffFlight(oF);

				break;
			case 2:
				System.out.println("Enter the income country: ");
				String incomeCountry = scan.next();
				
				System.out.println("Enter the income city: ");
				String incomeCity = scan.next();
				
				System.out.println("Enter the flight Company: ");
				String Company = scan.next();

				System.out.println("Enter the date of your flight: ");
				
				day = scan.nextInt();
				month = scan.nextInt();
				year = scan.nextInt();
				LocalDate datee = LocalDate.of(year, month, day);

				System.out.println("Enter the hour:");
				int h = scan.nextInt();
				System.out.println("Enter the minute:");
				int minutee = scan.nextInt();

				System.out.println("Enter the flight Number:");
				String flightNum = scan.next();

				System.out.println("Enter the terminal:");
				int terminale = scan.nextInt();

				ArrivalFlight iF = new ArrivalFlight(Company, datee, h, flightNum, terminale, incomeCountry, minutee,incomeCity);
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
			case 7:
				System.out.println("From which Date you want to search:");
				
				day = scan.nextInt();
				month = scan.nextInt();
				year = scan.nextInt();
				LocalDate from = LocalDate.of(year, month, day);
				System.out.println("Until which Date you want to search:");
				day = scan.nextInt();
				month = scan.nextInt();
				year = scan.nextInt();
				LocalDate until = LocalDate.of(year, month, day);
		
				System.out.println(afeka.searchByDate(from,until));
			}
		} while (choice != 8);

	}

}
