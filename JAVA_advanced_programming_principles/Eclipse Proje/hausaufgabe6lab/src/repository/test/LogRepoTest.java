/**
 * 
 */
package repository.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import repository.LogRepository;

/**
 * @author Dan
 *
 */
class LogRepoTest {

	@Test
	void test() throws IOException {
		LogRepository logRepo = new LogRepository(System.getProperty("user.dir") + "\\src\\repository\\test\\dummyLogFile.txt");
		assertEquals(logRepo.getLogList().get(1).toString(), "2017-07-14 19:24:52 INFO SaveAction:4 - Updated succesfully record number 4 : mkyong");
	}
	
}
