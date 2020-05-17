import java.io.PrintWriter;
import java.util.Scanner;

public class Flight {
	protected Date flightDate;
	protected String company;
	protected String flightNumber;
	protected int terminal;
	protected int hour;
	protected int minute;

	public Flight(String company, Date flightDate, int h, String flightNumber, int terminal, int minute) {
		this.company = company;
		this.flightDate = flightDate;
		setHour(h);
		this.flightNumber = flightNumber;
		this.terminal = terminal;
		setMinute(minute);
	}
	
	public Flight(Scanner s) {
		this.company = s.next();
		this.flightDate = new Date(s.nextInt(),s.nextInt(),s.nextInt());
		this.hour = s.nextInt();
		this.minute = s.nextInt();
		this.flightNumber = s.next();
		this.terminal = s.nextInt();
	}
	public Date getFlightDate() {
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
		return "\nFlight [flightDate=" + flightDate + ", company=" + company + ", flightNumber=" + flightNumber
				+ ", terminal=" + terminal + ", Time=" + hour +":"+ minute + "]";
	}

}
