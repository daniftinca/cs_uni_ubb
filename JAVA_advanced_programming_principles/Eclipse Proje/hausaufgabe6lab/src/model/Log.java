/**
 * 
 */
package model;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

/**
 * The Log class holds a single Log. Can be instantiated with a logstring. 
 * @author Dan
 *
 */
public class Log {

	private Date date;
	private String type;
	private String nameAndLineNumber;
	private String message;
	private String user;
	public Log(Date date, String type, String nameAndLineNumber, String message, String user) {
		super();
		this.date = date;
		this.type = type;
		this.nameAndLineNumber = nameAndLineNumber;
		this.message = message;
		this.user = user;
	}
	
	
	public Log(String logLine) throws ParseException {
		List<String> logData = Arrays.asList(logLine.split(" ")); 
		SimpleDateFormat dateFormatter=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
		date = dateFormatter.parse(logData.get(0)+" "+logData.get(1));
		type = logData.get(2);
		nameAndLineNumber = logData.get(3);
		user = logData.get(logData.size()-1);
		String listString = String.join(" ",  logData.subList(5, logData.size()-2));;
		message = listString;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNameAndLineNumber() {
		return nameAndLineNumber;
	}
	public void setNameAndLineNumber(String nameAndLineNumber) {
		this.nameAndLineNumber = nameAndLineNumber;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((nameAndLineNumber == null) ? 0 : nameAndLineNumber.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Log other = (Log) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (nameAndLineNumber == null) {
			if (other.nameAndLineNumber != null)
				return false;
		} else if (!nameAndLineNumber.equals(other.nameAndLineNumber))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}


	@Override
	public String toString() {
		String datestring;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		datestring = df.format(date);
		return datestring+" "+type+" "+nameAndLineNumber+" - "+message+" : "+user;
	}
	
	
	
}
