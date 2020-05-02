import java.io.PrintWriter;
import java.util.Scanner;

public class DepartureFlight extends Flight {
	private String destination;

	public DepartureFlight(String company, String destination, Date flightDate, int h, String flightNumber,
			int terminal, int minute) {
		super(company, flightDate, h, flightNumber, terminal, minute);
		this.destination = destination;

	}
	public void save(PrintWriter pw) {
		 pw.println(company);
		 pw.println(flightDate.getDay() +" "+ flightDate.getMonth() + " " + flightDate.getYear());
		 pw.println(hour + " " + minute);
		 pw.println(flightNumber);
		 pw.println(terminal);
		 pw.println(destination);
		 pw.println();
	}
	public DepartureFlight(Scanner s) {
		super(s);
		this.destination = s.next();
	}
	
	public String toString() {
		return super.toString() + "Departure Flight: [destination=" + destination + "]";
	}

}
