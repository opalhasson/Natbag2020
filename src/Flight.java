import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;

public class Flight {
	protected LocalDate flightDate;
	protected String company;
	protected String flightNumber;
	protected int terminal;
	protected int hour;
	protected int minute;
	protected boolean dateOk=true;

	public Flight(String company, LocalDate flightDate, int h, String flightNumber, int terminal, int minute) {
		this.company = company;
		this.flightDate=flightDate;
		setHour(h);
		this.flightNumber = flightNumber;
		this.terminal = terminal;
		setMinute(minute);
	}
	
	public Flight(Scanner s) {
		this.company = s.next();
		int day=s.nextInt();
		int month=s.nextInt();
		int year=s.nextInt();
		flightDate =LocalDate.of(year,month, day);
		this.hour = s.nextInt();
		this.minute = s.nextInt();
		this.flightNumber = s.next();
		this.terminal = s.nextInt();
	}

	public LocalDate getFlightDate() {
		return flightDate;
	}

	public String getCompany() {
		return company;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public int getTerminal() {
		return terminal;
	}

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}
	
	public void setHour(int hour) {
		if (hour <=23 && hour>=0) {
			this.hour = hour;
		}
		else
			this.hour = 12;
	}

	public void setMinute(int minute) {
		if (minute <=59 && minute >= 0) {
			this.minute = minute;
		}
		else
			this.minute = 0;
	}
	
	public String toString() {
		return "\nFlight [flightDate=" + flightDate.format(DateTimeFormatter.ofPattern("d/MM/uuuu")) + ", company=" + company + ", flightNumber=" + flightNumber
				+ ", terminal=" + terminal + ", Time=" + hour +":"+ minute + "]";
	}

}
