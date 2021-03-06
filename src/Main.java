import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		boolean isHtml = args.length > 0 && args[0].equalsIgnoreCase("html");
		Airport afeka = new Airport();
		afeka.addTakingOffFlight(
				new DepartureFlight("elal", "France", LocalDate.of(2020, 7, 29), 15, "LY234", 2, 34, "Paris", "CDG"));
		afeka.addTakingOffFlight(
				new DepartureFlight("elal", "France", LocalDate.of(2020, 6, 7), 12, "LY345", 3, 22, "Paris", "CDG"));
		afeka.addTakingOffFlight(new DepartureFlight("easyJet", "UK", LocalDate.of(2020, 5, 24), 12, "LY736", 3, 23,
				"London", "heathrow"));
		afeka.addTakingOffFlight(
				new DepartureFlight("elal", "Japan", LocalDate.of(2021, 1, 7), 3, "LY112", 3, 10, "Tokyo", "narita"));
		afeka.addTakingOffFlight(new DepartureFlight("Swiss", "Switzerland", LocalDate.of(2019, 10, 17), 23, "LY935", 3,
				12, "Zurich", "zurich airport"));
		afeka.addTakingOffFlight(new DepartureFlight("aeroflot", "Russia", LocalDate.of(2021, 8, 23), 6, "LY246", 3, 55,
				"Moscow", "SVO"));
		afeka.addLandingFlight(
				new ArrivalFlight("elal", LocalDate.of(2020, 2, 13), 15, "LY234", 3, "France", 34, "Paris", "PDG"));
		afeka.addLandingFlight(new ArrivalFlight("easyJet", LocalDate.of(2020, 5, 24), 12, "LY736", 3, "UK", 23,
				"London", "heathrow"));
		afeka.addLandingFlight(
				new ArrivalFlight("elal", LocalDate.of(2021, 1, 7), 3, "LY112", 3, "Japan", 10, "Tokyo", "narita"));
		afeka.addLandingFlight(new ArrivalFlight("Swiss", LocalDate.of(2019, 10, 17), 23, "LY935", 3, "Switzerland", 12,
				"Zurich", "zurich airport"));
		afeka.addLandingFlight(
				new ArrivalFlight("aeroflot", LocalDate.of(2021, 8, 23), 6, "LY246", 3, "Russia", 55, "Moscow", "SVO"));

		LocalDate from = LocalDate.of(Integer.parseInt(args[8]), Integer.parseInt(args[7]), Integer.parseInt(args[6]));
		LocalDate until = LocalDate.of(Integer.parseInt(args[11]), Integer.parseInt(args[10]),
				Integer.parseInt(args[9]));
		List<String> days = new ArrayList<String>();

		if (Boolean.parseBoolean(args[12])) {
			days.add("sunday");
		}
		if (Boolean.parseBoolean(args[13])) {
			days.add("monday");
		}
		if (Boolean.parseBoolean(args[14])) {
			days.add("tuesday");
		}
		if (Boolean.parseBoolean(args[15])) {
			days.add("wednesday");
		}
		if (Boolean.parseBoolean(args[16])) {
			days.add("thursday");
		}
		if (Boolean.parseBoolean(args[17])) {
			days.add("friday");
		}
		if (Boolean.parseBoolean(args[18])) {
			days.add("saturday");
		}

		List<Flight> flights = afeka.search(args[1], from, until, args[2], args[3], args[5], args[4], days);
		if (isHtml) {
			html(flights, args[1]);
		} else {
			text(flights, args[1]);
		}

	}

	public static void html(List<Flight> flights, String type) {
		System.out.println("<style>" + "table, th, td {" + "  border: 2px solid black;" + "border-collapse: collapse;"
				+ "text-align: center;" + "}" + "</style>");
		if (type.equals("a")) {
			System.out.println("<h1> Here are your requested arrival flights:</h1>");

		} else {
			System.out.println("<h1> Here are your requested departure flights:</h1>");
		}
		System.out.println("<table style=\"width:100%\">");
		System.out.println("<tbody>");
		System.out.println("<tr>");
		System.out.println("<th>Airline</th>");
		System.out.println("<th>Flight Number</th>");
		System.out.println("<th>Country</th>");
		System.out.println("<th>City</th>");
		System.out.println("<th>Date & Time</th>");
		System.out.println("<th>Terminal</th>");
		System.out.println("</tr>");
		for (int i = 0; i < flights.size(); i++) {
			System.out.println("<tr>");
			System.out.println("<td>" + flights.get(i).getCompany() + "</td>");
			System.out.println("<td>" + flights.get(i).getFlightNumber() + "</td>");
			if (type.equalsIgnoreCase("d")) {
				System.out.println("<td>" + ((DepartureFlight) flights.get(i)).getDestCountry() + "</td>");
				System.out.println("<td>" + ((DepartureFlight) flights.get(i)).getDestCity() + "</td>");
			} else if (type.equalsIgnoreCase("a")) {
				System.out.println("<td>" + ((ArrivalFlight) flights.get(i)).getIncomeCountry() + "</td>");
				System.out.println("<td>" + ((ArrivalFlight) flights.get(i)).getIncomeCity() + "</td>");
			}

			System.out.println("<td>" + flights.get(i).getFlightDate() + "  " + flights.get(i).getHour() + ":"
					+ flights.get(i).getMinute() + "</td>");
			System.out.println("<td>" + flights.get(i).getTerminal() + "</td>");
			System.out.println("</tr>");
		}
		System.out.println("</tbody>");
		System.out.println("</table>");
	}

	public static void text(List<Flight> flights, String type) {
		if (type.equals("a")) {
			System.out.println("\nHere are your requested arrival flights:");

		} else {
			System.out.println("\nHere are your requested departure flights:");
		}
		for (int i = 0; i < flights.size(); i++) {
			System.out.println(flights.get(i).toString());
		}
	}
}
