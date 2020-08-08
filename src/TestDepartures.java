import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class TestDepartures {

	@Test
	public void testCreateAirport() {
		Airport testAirport = createAirport();
		StringBuffer exceptedResult = new StringBuffer("The Departure flights sorted by date are: \n");
		exceptedResult.append(
				"1) Departure Flight: Destination Country= Switzerland, Destination City= Zurich, Date=17/10/2019, Time=23:12, Airport=zurich airport, Airline=Swiss, Flight Number=LY935, Terminal=3\n");
		exceptedResult.append(
				"2) Departure Flight: Destination Country= France, Destination City= Paris, Date=13/02/2020, Time=15:34, Airport=PDG, Airline=elal, Flight Number=LY234, Terminal=3\n");
		exceptedResult.append(
				"3) Departure Flight: Destination Country= UK, Destination City= London, Date=24/05/2020, Time=12:23, Airport=heathrow, Airline=easyJet, Flight Number=LY736, Terminal=3\n");
		exceptedResult.append(
				"4) Departure Flight: Destination Country= Japan, Destination City= Tokyo, Date=7/01/2021, Time=3:10, Airport=narita, Airline=elal, Flight Number=LY112, Terminal=3\n");
		exceptedResult.append(
				"5) Departure Flight: Destination Country= Russia, Destination City= Moscow, Date=23/08/2021, Time=6:55, Airport=SVO, Airline=aeroflot, Flight Number=LY246, Terminal=3\n");
		assertEquals(exceptedResult.toString(), testAirport.showAllTakingOffFlight());
	}

	public Airport createAirport() {
		Airport testAirport = new Airport();
		testAirport.addTakingOffFlight(
				new DepartureFlight("elal", "France", LocalDate.of(2020, 2, 13), 15, "LY234", 3, 34, "Paris", "PDG"));
		testAirport.addTakingOffFlight(new DepartureFlight("easyJet", "UK", LocalDate.of(2020, 5, 24), 12, "LY736", 3,
				23, "London", "heathrow"));
		testAirport.addTakingOffFlight(
				new DepartureFlight("elal", "Japan", LocalDate.of(2021, 1, 7), 3, "LY112", 3, 10, "Tokyo", "narita"));
		testAirport.addTakingOffFlight(new DepartureFlight("Swiss", "Switzerland", LocalDate.of(2019, 10, 17), 23,
				"LY935", 3, 12, "Zurich", "zurich airport"));
		testAirport.addTakingOffFlight(new DepartureFlight("aeroflot", "Russia", LocalDate.of(2021, 8, 23), 6, "LY246",
				3, 55, "Moscow", "SVO"));
		return testAirport;
	}

	@Test

	public void testSaveToFileAndFrom() throws IOException {
		StringBuffer expected = new StringBuffer("The Departure flights sorted by date are: \n");
		expected.append(
				"1) Departure Flight: Destination Country= France, Destination City= Paris, Date=13/02/2020, Time=15:34, Airport=PDG, Airline=elal, Flight Number=LY234, Terminal=3\n");
		assertEquals(expected.toString(), SaveToFileAndFrom().showAllTakingOffFlight());
	}

	public Airport SaveToFileAndFrom() throws IOException {
		File testFile = new File("test.txt");
		DepartureFlight testD = new DepartureFlight("elal", "France", LocalDate.of(2020, 2, 13), 15, "LY234", 3, 34,
				"Paris", "PDG");
		Airport testAirport = new Airport();
		testAirport.addTakingOffFlight(testD);
		testAirport.save(testFile);
		Scanner s = new Scanner(testFile);
		testAirport = new Airport(s);
		return testAirport;
	}

	@Test
	public void testSearch() {
		StringBuffer exceptedResult = new StringBuffer("The Filtered list is:\n");
		exceptedResult.append(
				"[Departure Flight: Destination Country= Japan, Destination City= Tokyo, Date=7/01/2021, Time=3:10, Airport=narita, Airline=elal, Flight Number=LY112, Terminal=3\n]");
		assertEquals(exceptedResult.toString(), search());
	}

	public String search() {
		Airport testAirport = new Airport();
		testAirport.addTakingOffFlight(
				new DepartureFlight("elal", "France", LocalDate.of(2020, 2, 13), 15, "LY234", 3, 34, "Paris", "PDG"));
		testAirport.addTakingOffFlight(new DepartureFlight("easyJet", "UK", LocalDate.of(2020, 5, 24), 12, "LY736", 3,
				23, "London", "heathrow"));
		testAirport.addTakingOffFlight(
				new DepartureFlight("elal", "Japan", LocalDate.of(2021, 1, 7), 3, "LY112", 3, 10, "Tokyo", "narita"));
		testAirport.addTakingOffFlight(new DepartureFlight("Swiss", "Switzerland", LocalDate.of(2019, 10, 17), 23,
				"LY935", 3, 12, "Zurich", "zurich airport"));
		testAirport.addTakingOffFlight(new DepartureFlight("aeroflot", "Russia", LocalDate.of(2021, 8, 23), 6, "LY246",
				3, 55, "Moscow", "SVO"));
		List<String> days = new ArrayList<String>();
		days.add("thursday");
		return testAirport.searchConsole("d", LocalDate.of(2020, 3, 1), LocalDate.of(2021, 8, 13), "Japan", "Tokyo",
				"elal", "narita", days);
	}
}
