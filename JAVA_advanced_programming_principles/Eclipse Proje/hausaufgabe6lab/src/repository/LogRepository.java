/**
 * 
 */
package repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import model.Log;

/**
 * Holds all the logs in the memory. Can read them from a logfile.
 * @author Dan
 *
 */
public class LogRepository {

	List<Log> logList;
	String filename;

	public LogRepository(String filename) throws IOException {
		super();
		this.filename = filename;
		logList = new ArrayList<Log>();
		loadLogsFromFile(filename);
	}
	
	/**
	 * Loads logs from a log file
	 * @param filename
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	private void loadLogsFromFile(String filename) throws IOException {
		Stream<String> lines = Files.lines(Paths.get(filename));
		
		lines.forEach(logLine -> {
			
			try {
				logList.add(new Log(logLine));
			} catch (ParseException e) {
				System.out.println("there was an IO exception ffs");
			}
		});
	}

	public List<Log> getLogList() {
		return logList;
	}

	public void setLogList(List<Log> logList) {
		this.logList = logList;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
}
