import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Airport {
	private int numOfFlight = 0;
	private List<DepartureFlight> listOfTakingOffFlights;
	private List<ArrivalFlight> listOfLandingFlights;

	public Airport() {
		listOfTakingOffFlights = new ArrayList<>();
		listOfLandingFlights = new ArrayList<>();
	}

	public Airport(List<DepartureFlight> listOfTakinfOffFlights, List<ArrivalFlight> listOfLandingFlights) {
		this.listOfTakingOffFlights = listOfTakinfOffFlights;
		this.listOfLandingFlights = listOfLandingFlights;
	}

	public List<DepartureFlight> getListOfTakinfOffFlights() {
		return listOfTakingOffFlights;
	}

	public List<ArrivalFlight> getListOfLandingFlights() {
		return listOfLandingFlights;
	}

	public void addTakingOffFlight(DepartureFlight f) {
		listOfTakingOffFlights.add(f);
	}

	public void addLandingFlight(ArrivalFlight f) {
		listOfLandingFlights.add(f);
	}

	public String showAllTakingOffFlight() {
		Comparator<DepartureFlight> compareByDateAndHour = new Comparator<DepartureFlight>() {
			public int compare(DepartureFlight f1, DepartureFlight f2) {
				if (f1.getFlightDate().isBefore(f2.getFlightDate()))
					return -1;
				else if (f1.getFlightDate().isEqual(f2.getFlightDate()))
					return 0;
				else
					return 1;
			}
		};
		Collections.sort(listOfTakingOffFlights, compareByDateAndHour);
		return "The flight sorted by date are: " + listOfTakingOffFlights;
	}

	public String showAllLandingFlight() {
		Comparator<ArrivalFlight> compareByDateAndHour = new Comparator<ArrivalFlight>() {
			public int compare(ArrivalFlight f1, ArrivalFlight f2) {
				if (f1.getFlightDate().isBefore(f2.getFlightDate()))
					return -1;
				else if (f1.getFlightDate().isEqual(f2.getFlightDate()))
					return 0;
				else
					return 1;
			}
		};
		Collections.sort(listOfLandingFlights, compareByDateAndHour);
		return "The flight sorted by date are: " + listOfLandingFlights;
	}

	public void save() throws IOException {
		File file = new File("flights.txt");
		file.createNewFile();
		PrintWriter pw = new PrintWriter(file);
		pw.println("Departures:\n" + listOfTakingOffFlights.size());
		for (int i = 0; i < listOfTakingOffFlights.size(); i++) {
			listOfTakingOffFlights.get(i).save(pw);
		}
		pw.println("arrivals:\n" + listOfLandingFlights.size());
		for (int i = 0; i < listOfLandingFlights.size(); i++) {
			listOfLandingFlights.get(i).save(pw);
		}
		pw.close();
	}

	public Airport(Scanner s) throws FileNotFoundException {
		this();
		s.next();
		int numofd = s.nextInt();
		for (int i = 0; i < numofd; i++) {
			listOfTakingOffFlights.add(new DepartureFlight(s));
		}
		s.next();
		int numofa = s.nextInt();
		for (int i = 0; i < numofa; i++) {
			listOfLandingFlights.add(new ArrivalFlight(s));
		}
	}

	public String toString() {
		return "Arrivals: " + listOfLandingFlights + "\nDepartures: " + listOfTakingOffFlights;
	}

	public List<Flight> filterByDate(LocalDate from, LocalDate until, List<Flight> flights) {
		List<Flight> temp = new ArrayList<>();
		for (int i = 0; i < flights.size(); i++) {
			if ((flights.get(i).getFlightDate().isAfter(from) || flights.get(i).getFlightDate().isEqual(from))
					&& flights.get(i).getFlightDate().isBefore(until))
				temp.add(flights.get(i));
		}

//		for (int i = 0; i < listOfTakingOffFlights.size(); i++) {
//			if((listOfTakingOffFlights.get(i).getFlightDate().isAfter(from)||listOfTakingOffFlights.get(i).getFlightDate().isEqual(from))&&listOfTakingOffFlights.get(i).getFlightDate().isBefore(until))
//				temp.add(listOfTakingOffFlights.get(i));
//		}
		return temp;
	}

	public List<Flight> filterByCountry(String country, List<Flight> flights) {
		List<Flight> temp = new ArrayList<>();
		for (int i = 0; i < flights.size(); i++) {
			if (flights.get(i) instanceof ArrivalFlight) {
				if (((ArrivalFlight) flights.get(i)).getIncomeCountry().equalsIgnoreCase(country)) {
					temp.add(flights.get(i));
				}
			}

		}
		for (int i = 0; i < flights.size(); i++) {
			if (flights.get(i) instanceof DepartureFlight) {
				if (((DepartureFlight) flights.get(i)).getDestCountry().equalsIgnoreCase(country)) {
					temp.add(flights.get(i));
				}
			}
		}
		return temp;
	}

	public List<Flight> filterByCity(String city, List<Flight> flights) {
		List<Flight> temp = new ArrayList<>();
		for (int i = 0; i < flights.size(); i++) {
			if (flights.get(i) instanceof ArrivalFlight) {
				if (((ArrivalFlight) flights.get(i)).getIncomeCity().equalsIgnoreCase(city)) {
					temp.add(flights.get(i));
				}
			}

		}
		for (int i = 0; i < flights.size(); i++) {
			if (flights.get(i) instanceof DepartureFlight) {
				if (((DepartureFlight) flights.get(i)).getDestCity().equalsIgnoreCase(city)) {
					temp.add(flights.get(i));
				}
			}
		}
		return temp;
	}

	public List<Flight> filterByCompany(String company, List<Flight> flights) {
		List<Flight> temp = new ArrayList<>();
		for (int i = 0; i < flights.size(); i++) {
			if (flights.get(i).getCompany().equalsIgnoreCase(company)) {
				temp.add(flights.get(i));
			}
		}
		return temp;
	}

	public void filterByDorA(String type, List<Flight> flights) {
		if (!(type.equalsIgnoreCase("b"))) {
			if (type.equalsIgnoreCase("a")) {
				for (int i = 0; i < listOfLandingFlights.size(); i++) {
					flights.add(listOfLandingFlights.get(i));
				}
			} else {
				for (int i = 0; i < listOfTakingOffFlights.size(); i++) {
					flights.add(listOfTakingOffFlights.get(i));
				}
			}
		} else {
			flights.addAll(listOfLandingFlights);
			flights.addAll(listOfTakingOffFlights);
		}
	}

	public List<Flight> filterByAirport(String airport, List<Flight> flights) {
		List<Flight> temp = new ArrayList<>();
		for (int i = 0; i < flights.size(); i++) {
			if (flights.get(i).getAirport().equalsIgnoreCase(airport)) {
				temp.add(flights.get(i));
			}
		}
		return temp;
	}

	public List<Flight> filterByDays(List<String> days, List<Flight> flights) {
		List<Flight> temp = new ArrayList<>();
		for (int i = 0; i < flights.size(); i++) {
			for (int j = 0; j < days.size(); j++) {
				if (flights.get(i).getFlightDate().getDayOfWeek().toString().equalsIgnoreCase(days.get(j))) {
					temp.add(flights.get(i));
				}
			}
		}
		return temp;
	}

	public List<Flight> search(String type, LocalDate from, LocalDate until, String country, String city,
			String company, String airport, List<String> days) {
		List<Flight> flights = new ArrayList<>();
		filterByDorA(type, flights);
		flights = filterByDate(from, until, flights);
		flights = filterByDays(days, flights);
		flights = filterByCountry(country, flights);
		flights = filterByCity(city, flights);
		flights = filterByCompany(company, flights);
		flights = filterByAirport(airport, flights);
		return flights;
	}

	public String searchConsole(String type, LocalDate from, LocalDate until, String country, String city,
			String company, String airport, List<String> days) {
		StringBuffer result = new StringBuffer("the Filtered list is:\n");
		List<Flight> flights = new ArrayList<>();
		filterByDorA(type, flights);
		flights = filterByDate(from, until, flights);
		flights = filterByDays(days, flights);
		flights = filterByCountry(country, flights);
		flights = filterByCity(city, flights);
		flights = filterByCompany(company, flights);
		flights = filterByAirport(airport, flights);
		result.append(flights.toString());
		return result.toString();
	}

}
