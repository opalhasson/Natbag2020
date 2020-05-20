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

	public Airport(Scanner s) throws FileNotFoundException { // loading elements from the file
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

	public String searchByDate(LocalDate from, LocalDate until) {
		StringBuffer flights = new StringBuffer("The Arrival flights between the Dates are:\n");
		for (int i = 0; i < listOfLandingFlights.size(); i++) {
			if ((listOfLandingFlights.get(i).getFlightDate().isAfter(from)
					|| listOfLandingFlights.get(i).getFlightDate().isEqual(from))
					&& listOfLandingFlights.get(i).getFlightDate().isBefore(until))
				flights.append(listOfLandingFlights.get(i) + "\n");
		}

		flights.append("The Departure flights between the Dates are:\n");
		for (int i = 0; i < listOfTakingOffFlights.size(); i++) {
			if ((listOfTakingOffFlights.get(i).getFlightDate().isAfter(from)
					|| listOfTakingOffFlights.get(i).getFlightDate().isEqual(from))
					&& listOfTakingOffFlights.get(i).getFlightDate().isBefore(until))
				flights.append(listOfTakingOffFlights.get(i) + "\n");
		}
		return flights.toString();
	}

}
