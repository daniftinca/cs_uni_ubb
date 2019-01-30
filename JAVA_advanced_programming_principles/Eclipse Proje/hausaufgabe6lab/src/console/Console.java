/**
 * 
 */
package console;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import controller.Controller;
import model.Log;

/**
 * @author Dan
 *
 */
public class Console {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String menu = "Menu\n------\n"
				+ "1.)Display all logs\n"
				+ "2.)Display all logs of a certain Type\n"
				+ "3.)Display all logs in the last X days\n"
				+ "4.)Display the most common message for a certain type\n"
				+ "5.)Exit\n";
		Controller mainController = new Controller(System.getProperty("user.dir") + "\\logFile");
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		while(true) {
			System.out.println(menu);
			System.out.println("Choose an option (numbers 1-4): ");
			int choice = keyboard.nextInt();
			keyboard.nextLine();
			if(choice == 1) {
				mainController.getLogs().getLogList().stream().forEach(log -> System.out.println(log.toString()));
			} else if(choice == 2) {
				System.out.print("\nPlease give me the type you want me to display: ");
				String type = keyboard.nextLine();
				List<Log> toDisplay = mainController.getLogsByType(type);
				if(toDisplay.size()==0) {
					System.out.println("No such type in here");
				} else {
					toDisplay.stream().forEach(log -> System.out.println(log.toString()));
				}
			} else if(choice == 3) {
				System.out.print("\nHow many days old is enough days old? Day#: ");
				int dayNr = keyboard.nextInt();
				keyboard.nextLine();
				List<Log> toDisplay = mainController.getLastDays(dayNr);
				if(toDisplay.size()==0) {
					System.out.println("There are no logs that young");
				} else {
					toDisplay.stream().forEach(log -> System.out.println(log.toString()));
				}
			} else if(choice == 4) {
				System.out.print("\nPlease give me the type you want me to use: ");
				String type = keyboard.nextLine();
				System.out.println(mainController.getMostCommonLogForType(type));
			} else if(choice == 5) {
				break;
			} else {
				System.out.println(choice+" is not an option that I know of.");
			}
		}

	}

}
