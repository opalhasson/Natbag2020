import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestArrivals {

	@Test
	public void test() {
		Airport testAirport = createAirport();
		StringBuffer exceptedResult = new StringBuffer("The flight sorted by date are: [\n");
		exceptedResult.append("Flight [flightDate=17/10/2019, company=Swiss, flightNumber=LY935, terminal=3, Time=23:12]Arrival Flight [incomeCountry=Switzerland incomeCity =Zurich], \n");
				exceptedResult.append("Flight [flightDate=13/2/2020, company=elal, flightNumber=LY234, terminal=3, Time=15:34]Arrival Flight [incomeCountry=France incomeCity =Paris], \n");
				exceptedResult.append("Flight [flightDate=24/5/2020, company=easyJet, flightNumber=LY736, terminal=3, Time=12:23]Arrival Flight [incomeCountry=UK incomeCity =London], \n");
				exceptedResult.append("Flight [flightDate=7/1/2021, company=elal, flightNumber=LY112, terminal=3, Time=3:10]Arrival Flight [incomeCountry=Japan incomeCity =Tokyo], \n");
				exceptedResult.append("Flight [flightDate=23/8/2021, company=aeroflot, flightNumber=LY246, terminal=3, Time=6:55]Arrival Flight [incomeCountry=Russia incomeCity =Moscow]]");
		assertEquals(exceptedResult.toString(), testAirport.showAllLandingFlight());
	}
	
	public Airport createAirport() {
		Airport testAirport = new Airport();
		testAirport.addLandingFlight(new ArrivalFlight("elal",new Date(13,2,2020),15,"LY234",3,"France",34,"Paris"));
		testAirport.addLandingFlight(new ArrivalFlight("easyJet",new Date(24,5,2020),12,"LY736",3,"UK",23,"London"));
		testAirport.addLandingFlight(new ArrivalFlight("elal",new Date(7,1,2021),3,"LY112",3,"Japan",10,"Tokyo"));
		testAirport.addLandingFlight(new ArrivalFlight("Swiss",new Date(17,10,2019),23,"LY935",3,"Switzerland",12,"Zurich"));
		testAirport.addLandingFlight(new ArrivalFlight("aeroflot",new Date(23,8,2021),6,"LY246",3,"Russia",55,"Moscow"));
		return testAirport; 
	}
	

}
