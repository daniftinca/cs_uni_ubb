/**
 * 
 */
package controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.Log;
import repository.LogRepository;

/**
 * The controller class works with the log repo to display desired results.
 * @author Dan
 *
 */
public class Controller {
	LogRepository logs;

	public Controller(LogRepository logs) {
		super();
		this.logs = logs;
	}
	
	public Controller(String filename) throws IOException {
		super();
		this.logs = new LogRepository(filename);
	}
	
	/**
	 * Returns all logs of a given Type.
	 * @param type
	 * @return List of logs
	 */
	public List<Log> getLogsByType(String type) {
		return logs.getLogList().stream().filter(logItem -> {
			if(logItem.getType().equals(type))
				return true;
			else
				return false;
		})
		.collect(Collectors.toList());
	}
	
	/**
	 * Returns all logs in the last nrDays days.
	 * @param nrDays
	 * @return List of Logs
	 */
	public List<Log> getLastDays(int nrDays){
		@SuppressWarnings("static-access")
		Calendar cal = new GregorianCalendar().getInstance();
		cal.add(Calendar.DATE, -nrDays);
		
		Date comparisonDate = cal.getTime();
		
		return logs.getLogList().stream()
				.filter(logItem -> logItem.getDate().after(comparisonDate))
				.collect(Collectors.toList());
	}
	
	
	/**
	 * Returns the message that appears the most for a certain logtype.
	 * @param type
	 * @return String 
	 */
	public String getMostCommonLogForType(String type){
		Map<String, Long> myMap = logs.getLogList().stream()
				.filter(logItem -> logItem.getType().equals(type))
				.collect(Collectors.groupingBy(logItem -> logItem.getMessage(), Collectors.counting()));
	
		return myMap.entrySet().stream().max((message1,message2)-> {
			if(message1.getValue()>message2.getValue()) {
				return 1;
			} else {
				return -1;
			}
		}).get().getKey();
	}

	public LogRepository getLogs() {
		return logs;
	}

	public void setLogs(LogRepository logs) {
		this.logs = logs;
	}
	
	
}
