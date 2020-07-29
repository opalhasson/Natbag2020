import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class TestArrivals {

	@Test
	public void test() {
		Airport testAirport = createAirport();
		StringBuffer exceptedResult = new StringBuffer("The flight sorted by date are: [\n");
		exceptedResult.append("Flight [flightDate=17/10/2019, company=Swiss, flightNumber=LY935, terminal=3, Time=23:12]Arrival Flight [incomeCountry=Switzerland incomeCity =Zurich], \n");
				exceptedResult.append("Flight [flightDate=13/02/2020, company=elal, flightNumber=LY234, terminal=3, Time=15:34]Arrival Flight [incomeCountry=France incomeCity =Paris], \n");
				exceptedResult.append("Flight [flightDate=24/05/2020, company=easyJet, flightNumber=LY736, terminal=3, Time=12:23]Arrival Flight [incomeCountry=UK incomeCity =London], \n");
				exceptedResult.append("Flight [flightDate=7/01/2021, company=elal, flightNumber=LY112, terminal=3, Time=3:10]Arrival Flight [incomeCountry=Japan incomeCity =Tokyo], \n");
				exceptedResult.append("Flight [flightDate=23/08/2021, company=aeroflot, flightNumber=LY246, terminal=3, Time=6:55]Arrival Flight [incomeCountry=Russia incomeCity =Moscow]]");
		assertEquals(exceptedResult.toString(), testAirport.showAllLandingFlight());
	}
	
	public Airport createAirport() {
		Airport testAirport = new Airport();
		testAirport.addLandingFlight(new ArrivalFlight("elal",LocalDate.of(2020,2,13),15,"LY234",3,"France",34,"Paris","PDG"));
		testAirport.addLandingFlight(new ArrivalFlight("easyJet",LocalDate.of(2020,5,24),12,"LY736",3,"UK",23,"London","heathrow"));
		testAirport.addLandingFlight(new ArrivalFlight("elal",LocalDate.of(2021,1,7),3,"LY112",3,"Japan",10,"Tokyo","narita"));
		testAirport.addLandingFlight(new ArrivalFlight("Swiss",LocalDate.of(2019,10,17),23,"LY935",3,"Switzerland",12,"Zurich","zurich airport"));
		testAirport.addLandingFlight(new ArrivalFlight("aeroflot",LocalDate.of(2021,8,23),6,"LY246",3,"Russia",55,"Moscow","SVO"));
		return testAirport; 
	}
	

}
