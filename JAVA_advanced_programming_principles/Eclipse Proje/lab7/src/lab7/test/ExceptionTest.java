package lab7.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lab7.exceptions.Demo;

class ExceptionTest {

	@Test
	void test() {
		//junit 5
		Assertions.assertThrows(IOException.class, () -> Demo.werfeIOException());
	}

}
