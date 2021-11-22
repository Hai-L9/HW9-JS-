import java.time.LocalDateTime;
import java.util.Scanner;

/* Author: Joshua Stone
 * Date: Nov 19, 2021
 * Class: CSC 160 502
 * Assignment: HW9
 *
 * Program Description: Allows user to create check and cancel reservations at restaurant
*/

public class DriverReservation
{
	/**
	 * DriverReservation Main
	 */
	public static void main(String[] args)
	{
		boolean isDone = false;
		Reservation res = new Reservation();
		LocalDateTime date = LocalDateTime.now();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter your name.");
		String name = sc.next().toLowerCase();
		res.setName(name); // Sets object name
		sc.nextLine();
		System.out.println("Welcome to Le Bernardin, what would you like to do?");
		
		while (!isDone) {
			System.out.printf("[   Make Reservation     ]\n[   Check Avalibility    ]\n[   Cancel Reservation   ]\n[   Quit                 ]\n");
			String answer = sc.nextLine();
			
			if (answer.toLowerCase().contains("make")) {
				System.out.println("What's the occasion?");
				res.setOccasion(sc.nextLine()); // Sets occasion
				
				date = userDateTime(); // Collects date info 
				if (res.checkDate(date) == true) { // Check time slot
					res.setDateTime(name, date); // Fill time slot
					System.out.println("Your reservation was successfull, see you at " + date.getHour() + "!");
				}else
					System.out.println("This time has already been reserved.");
				
				
			} else if (answer.toLowerCase().contains("check") || answer.toLowerCase().contains("avalibility")) {
				
				if (res.checkDate(userDateTime()) == true) // Collects date info and checks time slot
					System.out.println("There is an avalible table at this time."); 
				else
					System.out.println("This time has already been reserved.");
				
				
			} else if (answer.toLowerCase().contains("cancel")) {
				date = userDateTime();
				boolean isGoodDate = res.cancel(name, date);
				if (isGoodDate == true){
					System.out.println("Your reservation has been canceled.");
				} else
					System.out.println("You do not have a reservation at the specified date and time.");
			} else if (answer.toLowerCase().contains("quit")) {
				isDone = true;
			} else {
				System.out.println("Unrecognized request please try again.");
			}
		}
		
		System.out.println(res.toString()); // Only prints most recently created reservation.
		
		sc.close();
	}

	/**
	 * Collects date info from user
	 * @author Joshua Stone
	 * @date Nov 21, 2021
	 * @callingProgram DriverReservation
	 * @return date LocalDateTime
	 */
	private static LocalDateTime userDateTime()
	{
		Scanner sc = new Scanner(System.in);
		String answer = "TempAnswer";
				
		System.out.println("Please enter day (dd)");
		String day = sc.next();
		if (day.charAt(0) != '0' && Integer.parseInt(day) < 10) {
			day = "0" + day;
		}
		
		sc.nextLine();
		String time = "-1";
		boolean isGoodTime = false;
	
		System.out.println("Please enter time (##:##) (Possible times: 6:00 pm, 8:00 pm, 10:00 pm.)");
		while (isGoodTime == false) {
			time = sc.nextLine();
			if (time.matches("\\d:\\d\\d") || time.matches("\\d\\d:\\d\\d")) {
				isGoodTime = true;
			} else {
				System.out.println("Please type time in (##:##) format (Possible times: 6:00 pm, 8:00 pm, 10:00 pm.)");
			}
		}
		
		if (time.charAt(1) == ':')
			time = "0" + time;
		answer = ("2021-11-" + day + "T" + time + ":00");
		LocalDateTime date = LocalDateTime.parse(answer);
		return date;
		
	}
}
