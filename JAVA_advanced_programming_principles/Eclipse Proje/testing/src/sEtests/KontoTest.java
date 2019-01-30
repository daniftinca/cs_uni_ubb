package sEtests;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class KontoTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void abhebenTest() {
		Konto konto = new Konto(12345,100.0, 26,0);
		
		
		konto.abheben(90);
		assertEquals(10, konto.getKontoStand(),0.01);
		
	}
	
	@Test
	void abhebenGrenzeTest() {
		Konto konto = new Konto(12345,100.0,26,0);
		
		
		konto.abheben(100);
		assertEquals(0, konto.getKontoStand(),0.01);
		
	}
	
	@Test
	void kontoInitialisierenTest() {

		Assertions.assertThrows(InvalidParameterException.class, () -> new Konto(12345,-5,26,0));
	}
	
	@Test
	void abhebenNullExceptionTest() {

		Konto konto = new Konto(12345,100.0,26,0);

		Assertions.assertThrows(InvalidParameterException.class, () -> konto.abheben(0));
	}
	
	@Test
	void abhebenZuVielExceptionTest() {

		Konto konto = new Konto(12345,100.0,26,0);

		Assertions.assertThrows(InvalidParameterException.class, () -> konto.abheben(110));
	}
	
	@Test
	void abhebenNegativExceptionTest() {

		Konto konto = new Konto(12345,100.0,26,0);

		Assertions.assertThrows(InvalidParameterException.class, () -> konto.abheben(-5));
	}

	@Test
	void kreditNehmenTest(){
		Konto konto = new Konto(12345,100,26,0);
		konto.kreditNehmen(10000);

		assertEquals(10000,konto.getKredit());
	}
	
	@Test
	void kreditNehmenZuJungTest() {

		Konto konto = new Konto(12345,100,17,0);
		Assertions.assertThrows(InvalidParameterException.class, () -> konto.kreditNehmen(100));
	}
	
	@Test
	void kreditNehmenBeschranktGrenzwertTest() {

		Konto konto = new Konto(12345,100,18,0);
		Assertions.assertThrows(InvalidParameterException.class, () -> konto.kreditNehmen(1001));
		konto.setKundenAlter(25);
		Assertions.assertThrows(InvalidParameterException.class, () -> konto.kreditNehmen(1001));
		
	}
	
	@Test
	void kreditNehmenUnterAlterTest() {

		Konto konto = new Konto(12345,100,20,0);
		Assertions.assertThrows(InvalidParameterException.class, () -> konto.kreditNehmen(1001));
	}
	
	
}
