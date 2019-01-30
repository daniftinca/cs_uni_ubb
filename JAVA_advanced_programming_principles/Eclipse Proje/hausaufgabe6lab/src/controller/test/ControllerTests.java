package controller.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import controller.Controller;

class ControllerTests {

	@Test
	void getTypetest() throws IOException {
		Controller controller = new Controller(System.getProperty("user.dir") + "\\src\\controller\\test\\dummyLogFile.txt");
		assertEquals(3, controller.getLogsByType("SEVERE").size());
	}
	
	@Test
	void getLastDaysTest() throws IOException {
		Controller controller = new Controller(System.getProperty("user.dir") + "\\src\\controller\\test\\dummyLogFile.txt");
		assertEquals(1, controller.getLastDays(10).size());
	}

	@Test 
	void getMostCommonMessage() throws IOException {
		Controller controller = new Controller(System.getProperty("user.dir") + "\\src\\controller\\test\\dummyLogFile.txt");
		assertEquals("Delete error", controller.getMostCommonLogForType("SEVERE"));
	}
}
