import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ArrivalFlight extends Flight {

	private String incomeCountry;
	private String incomeCity;

	public ArrivalFlight(String company, LocalDate flightDate, int h, String flightNumber, int terminal, String country,
			int minute, String city, String airport) {
		super(company, flightDate, h, flightNumber, terminal, minute, airport);
		this.incomeCountry = country;
		this.incomeCity = city;
	}

	public String getIncomeCountry() {
		return incomeCountry;
	}

	public String getIncomeCity() {
		return incomeCity;
	}

	public void save(PrintWriter pw) {
		pw.println(company);
		pw.println(airport);
		pw.println(flightDate.format(DateTimeFormatter.ofPattern("d MM uuuu")));
		pw.println(hour + " " + minute);
		pw.println(flightNumber);
		pw.println(terminal);
		pw.println(incomeCountry);
		pw.println(incomeCity);
		pw.println();
	}

	public ArrivalFlight(Scanner s) {
		super(s);
		this.incomeCountry = s.next();
		this.incomeCity = s.next();
	}

	public String toString() {
		return "Arrival Flight: Income Country= " + incomeCountry + ", Income City= " + incomeCity + super.toString();
	}

}
