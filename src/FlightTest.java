import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class FlightTest {
	LocalDate d=LocalDate.of(2020, 4, 2);
	Flight f=new Flight("elal",d,20,"L34H",3,45);

	@Test
	void companyTest() {
		String name=f.flightNumber;
		assertEquals("L34H",name);
	}

	@Test
	void DateTest() {
		int hour=f.getHour();
		assertEquals(20,hour);
	}


}
