import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DepartureFlight extends Flight {
	private String destCountry;
	private String destCity;


	public DepartureFlight(String company, String destination, LocalDate flightDate, int h, String flightNumber,
			int terminal, int minute, String city) {
		super(company, flightDate, h, flightNumber, terminal, minute);
		this.destCountry = destination;
		this.destCity = city;

	}

	public void save(PrintWriter pw) {
		pw.println(company);
		pw.println(flightDate.format(DateTimeFormatter.ofPattern("d MM uuuu")) );
		pw.println(hour + " " + minute);
		pw.println(flightNumber);
		pw.println(terminal);
		pw.println(destCountry);
		pw.println(destCity);
		pw.println();
	}

	public DepartureFlight(Scanner s) {
		super(s);
		this.destCountry = s.next();
		this.destCity = s.next();
	}

	public String toString() {
		return super.toString() + "Departure Flight: [destination=" + destCountry + " destCity = " + destCity +"]";
	}

}
