package model.test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;

import org.junit.jupiter.api.Test;

import model.Log;

class LogTest {

	@Test
	void test() throws ParseException {
		String myLogLine = "2017-02-26 10:15:44 INFO EditAction:32 - Updated succesfully record number 5 : iipeter";
		Log myLog = new Log(myLogLine);
		
		assertEquals(myLogLine, myLog.toString());
		
	}

}
