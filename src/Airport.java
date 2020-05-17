import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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
				if (f1.getFlightDate().getYear() < f2.getFlightDate().getYear()) {
					return -1;
				} else if (f1.getFlightDate().getYear() == f2.getFlightDate().getYear()) {
					if (f1.getFlightDate().getMonth() < f2.getFlightDate().getMonth()) {
						return -1;
					} else if (f1.getFlightDate().getMonth() == f2.getFlightDate().getMonth()) {
						if (f1.getFlightDate().getDay() < f2.getFlightDate().getDay()) {
							return -1;
						} else if (f1.getFlightDate().getDay() == f2.getFlightDate().getDay()) {
							if (f1.getHour() < f2.getHour()) {
								return -1;
							} else if (f1.getHour() == f2.getHour()) {
								if (f1.getMinute() < f2.getMinute()) {
									return -1;
								} else if (f1.getMinute() == f2.getMinute()) {
									return 0;
								}
							}
						}
					}
				}
				return 1;
			}
		};
		Collections.sort(listOfTakingOffFlights, compareByDateAndHour);
		return "The flight sorted by date are: " + listOfTakingOffFlights;
	}

	public String showAllLandingFlight() {
		Comparator<ArrivalFlight> compareByDateAndHour = new Comparator<ArrivalFlight>() {
			public int compare(ArrivalFlight f1, ArrivalFlight f2) {
				if (f1.getFlightDate().getYear() < f2.getFlightDate().getYear()) {
					return -1;
				} else if (f1.getFlightDate().getYear() == f2.getFlightDate().getYear()) {
					if (f1.getFlightDate().getMonth() < f2.getFlightDate().getMonth()) {
						return -1;
					} else if (f1.getFlightDate().getMonth() == f2.getFlightDate().getMonth()) {
						if (f1.getFlightDate().getDay() < f2.getFlightDate().getDay()) {
							return -1;
						} else if (f1.getFlightDate().getDay() == f2.getFlightDate().getDay()) {
							if (f1.getHour() < f2.getHour()) {
								return -1;
							} else if (f1.getHour() == f2.getHour()) {
								if (f1.getMinute() < f2.getMinute()) {
									return -1;
								} else if (f1.getMinute() == f2.getMinute()) {
									return 0;
								}
							}
						}
					}
				}
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

	public String searchByDate(Date from, Date until) {
		StringBuffer flights = new StringBuffer("The Departure flights between the Dates are:\n");
		for (int i = 0; i < listOfTakingOffFlights.size(); i++) {
			int year = listOfTakingOffFlights.get(i).getFlightDate().getYear();
			int month = listOfTakingOffFlights.get(i).getFlightDate().getMonth();
			int day = listOfTakingOffFlights.get(i).getFlightDate().getDay();
			boolean isOk = false;
			if (year >= from.getYear()) {
				if (year == from.getYear()) {
					if (month >= from.getMonth()) {
						if (month == from.getMonth()) {
							if (day >= from.getDay()) {
								isOk = true;
							}
						}
						else {
							isOk = true;
						}
					}
				}
				else {
					isOk= true;
				}
			}
			if (isOk) {
				isOk = false;
				if (year <= until.getYear()) {
					if (year == until.getYear()) {
						if (month <= until.getMonth()) {
							if (month == until.getMonth()) {
								if (day <= until.getDay()) {
									isOk = true;
								}
							} else {
								isOk = true;
							}
						}
					} else {
						isOk = true;
					}
				} 
			}
			if (isOk) {
				flights.append(listOfTakingOffFlights.get(i)+"\n");
			}
		}
		flights.append("The Arrival flights between the Dates are:\n");
		for (int i = 0; i < listOfLandingFlights.size(); i++) {
				int year = listOfLandingFlights.get(i).getFlightDate().getYear();
				int month = listOfLandingFlights.get(i).getFlightDate().getMonth();
				int day = listOfLandingFlights.get(i).getFlightDate().getDay();
				boolean isOk = false;
				if (year >= from.getYear()) {
					if (year == from.getYear()) {
						if (month >= from.getMonth()) {
							if (month == from.getMonth()) {
								if (day >= from.getDay()) {
									isOk = true;
								}
							}
							else {
								isOk = true;
							}
						}
					}
					else {
						isOk= true;
					}
				}
				if (isOk) {
					isOk = false;
					if (year <= until.getYear()) {
						if (year == until.getYear()) {
							if (month <= until.getMonth()) {
								if (month == until.getMonth()) {
									if (day <= until.getDay()) {
										isOk = true;
									}
								} else {
									isOk = true;
								}
							}
						} else {
							isOk = true;
						}
					} 
				}
				if (isOk) {
					flights.append(listOfLandingFlights.get(i)+"\n");
				}
		}
		return flights.toString();
		
	}
}
