package seubung;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SquareTest {
	@Test
	void testGetSidelength() {
		
		Square sq = new Square(2);
		assertEquals(2, sq.getSidelength());
	}
	
	@Test
	void testGetArea() {
		
		Square sq = new Square(2);
		assertEquals(4,sq.getArea());
	}

	@Test 
	void testException() {
		
		Assertions.assertThrows(InvalidParameterException.class, () -> new Square(-1));
	}
		
	
}
