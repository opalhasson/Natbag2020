import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestDepartures {

	@Test
	public void test() {
		Airport testAirport = createAirport();
		StringBuffer exceptedResult = new StringBuffer("The flight sorted by date are: [\n");
		exceptedResult.append("Flight [flightDate=17/10/2019, company=Swiss, flightNumber=LY935, terminal=3, Time=23:12]Departure Flight [destination=Switzerland destCity = Zurich], \n");
				exceptedResult.append("Flight [flightDate=13/2/2020, company=elal, flightNumber=LY234, terminal=3, Time=15:34]Departure Flight [destination=France destCity = Paris], \n");
				exceptedResult.append("Flight [flightDate=24/5/2020, company=easyJet, flightNumber=LY736, terminal=3, Time=12:23]Departure Flight [destination=UK destCity = London], \n");
				exceptedResult.append("Flight [flightDate=7/1/2021, company=elal, flightNumber=LY112, terminal=3, Time=3:10]Departure Flight [destination=Japan destCity = Tokyo], \n");
				exceptedResult.append("Flight [flightDate=23/8/2021, company=aeroflot, flightNumber=LY246, terminal=3, Time=6:55]Departure Flight [destination=Russia destCity = Moscow]]");
		assertEquals(exceptedResult.toString(), testAirport.showAllTakingOffFlight());
	}
	
	public Airport createAirport() {
		Airport testAirport = new Airport();
		testAirport.addTakingOffFlight(new DepartureFlight("elal","France",new Date(13,2,2020),15,"LY234",3,34,"Paris"));
		testAirport.addTakingOffFlight(new DepartureFlight("easyJet","UK",new Date(24,5,2020),12,"LY736",3,23,"London"));
		testAirport.addTakingOffFlight(new DepartureFlight("elal","Japan",new Date(7,1,2021),3,"LY112",3,10,"Tokyo"));
		testAirport.addTakingOffFlight(new DepartureFlight("Swiss","Switzerland",new Date(17,10,2019),23,"LY935",3,12,"Zurich"));
		testAirport.addTakingOffFlight(new DepartureFlight("aeroflot","Russia",new Date(23,8,2021),6,"LY246",3,55,"Moscow"));
		return testAirport; 
	}

}
