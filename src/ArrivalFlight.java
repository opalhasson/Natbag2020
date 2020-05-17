import java.io.PrintWriter;
import java.util.Scanner;

public class ArrivalFlight extends Flight {

	private String incomeCountry;
	private String incomeCity;

	public ArrivalFlight(String company, Date flightDate, int h, String flightNumber, int terminal, String country,
			int minute,String city) {
		super(company, flightDate, h, flightNumber, terminal, minute);
		this.incomeCountry = country;
		this.incomeCity= city;
	}

	public void save(PrintWriter pw) {
		 pw.println(company);
		 pw.println(flightDate.getDay() +" "+ flightDate.getMonth() + " " + flightDate.getYear());
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
		return super.toString() + "Arrival Flight [incomeCountry=" + incomeCountry + " incomeCity =" +  incomeCity +"]";
	}

}
