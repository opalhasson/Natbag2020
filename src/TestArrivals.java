import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class TestArrivals {

	@Test
	public void testCreateAirport() {
		Airport testAirport = createAirport();
		StringBuffer exceptedResult = new StringBuffer("The Arrival flights sorted by date are: \n");
		exceptedResult.append(
				"1) Arrival Flight: Income Country= Switzerland, Income City= Zurich, Date=17/10/2019, Time=23:12, Airport=zurich airport, Airline=Swiss, Flight Number=LY935, Terminal=3\n");
		exceptedResult.append(
				"2) Arrival Flight: Income Country= France, Income City= Paris, Date=13/02/2020, Time=15:34, Airport=PDG, Airline=elal, Flight Number=LY234, Terminal=3\n");
		exceptedResult.append(
				"3) Arrival Flight: Income Country= UK, Income City= London, Date=24/05/2020, Time=12:23, Airport=heathrow, Airline=easyJet, Flight Number=LY736, Terminal=3\n");
		exceptedResult.append(
				"4) Arrival Flight: Income Country= Japan, Income City= Tokyo, Date=7/01/2021, Time=3:10, Airport=narita, Airline=elal, Flight Number=LY112, Terminal=3\n");
		exceptedResult.append(
				"5) Arrival Flight: Income Country= Russia, Income City= Moscow, Date=23/08/2021, Time=6:55, Airport=SVO, Airline=aeroflot, Flight Number=LY246, Terminal=3\n");
		assertEquals(exceptedResult.toString(), testAirport.showAllLandingFlight());
	}

	public Airport createAirport() {
		Airport testAirport = new Airport();
		testAirport.addLandingFlight(
				new ArrivalFlight("elal", LocalDate.of(2020, 2, 13), 15, "LY234", 3, "France", 34, "Paris", "PDG"));
		testAirport.addLandingFlight(new ArrivalFlight("easyJet", LocalDate.of(2020, 5, 24), 12, "LY736", 3, "UK", 23,
				"London", "heathrow"));
		testAirport.addLandingFlight(
				new ArrivalFlight("elal", LocalDate.of(2021, 1, 7), 3, "LY112", 3, "Japan", 10, "Tokyo", "narita"));
		testAirport.addLandingFlight(new ArrivalFlight("Swiss", LocalDate.of(2019, 10, 17), 23, "LY935", 3,
				"Switzerland", 12, "Zurich", "zurich airport"));
		testAirport.addLandingFlight(
				new ArrivalFlight("aeroflot", LocalDate.of(2021, 8, 23), 6, "LY246", 3, "Russia", 55, "Moscow", "SVO"));
		return testAirport;
	}

	@Test
	public void testSaveToFileAndFrom() throws IOException {
		StringBuffer expected = new StringBuffer("The Arrival flights sorted by date are: \n");
		expected.append(
				"1) Arrival Flight: Income Country= UK, Income City= London, Date=24/05/2020, Time=12:23, Airport=heathrow, Airline=easyJet, Flight Number=LY736, Terminal=3\n");
		assertEquals(expected.toString(), SaveToFileAndFrom().showAllLandingFlight());
	}

	public Airport SaveToFileAndFrom() throws IOException {
		File testFile = new File("test.txt");
		ArrivalFlight testA = new ArrivalFlight("easyJet", LocalDate.of(2020, 5, 24), 12, "LY736", 3, "UK", 23,
				"London", "heathrow");
		Airport testAirport = new Airport();
		testAirport.addLandingFlight(testA);
		testAirport.save(testFile);
		Scanner s = new Scanner(testFile);
		testAirport = new Airport(s);
		return testAirport;
	}

	@Test
	public void testSearch() {
		StringBuffer exceptedResult = new StringBuffer("The Filtered list is:\n");
		exceptedResult.append(
				"[Arrival Flight: Income Country= Japan, Income City= Tokyo, Date=7/01/2021, Time=3:10, Airport=narita, Airline=elal, Flight Number=LY112, Terminal=3\n]");
		assertEquals(exceptedResult.toString(), search());
	}

	public String search() {
		Airport testAirport = new Airport();
		testAirport.addLandingFlight(
				new ArrivalFlight("elal", LocalDate.of(2020, 2, 13), 15, "LY234", 3, "France", 34, "Paris", "PDG"));
		testAirport.addLandingFlight(new ArrivalFlight("easyJet", LocalDate.of(2020, 5, 24), 12, "LY736", 3, "UK", 23,
				"London", "heathrow"));
		testAirport.addLandingFlight(
				new ArrivalFlight("elal", LocalDate.of(2021, 1, 7), 3, "LY112", 3, "Japan", 10, "Tokyo", "narita"));
		testAirport.addLandingFlight(new ArrivalFlight("Swiss", LocalDate.of(2019, 10, 17), 23, "LY935", 3,
				"Switzerland", 12, "Zurich", "zurich airport"));
		testAirport.addLandingFlight(
				new ArrivalFlight("aeroflot", LocalDate.of(2021, 8, 23), 6, "LY246", 3, "Russia", 55, "Moscow", "SVO"));
		List<String> days = new ArrayList<String>();
		days.add("thursday");
		return testAirport.searchConsole("a", LocalDate.of(2020, 3, 1), LocalDate.of(2021, 8, 13), "Japan", "Tokyo",
				"elal", "narita", days);
	}

}
