import java.time.LocalDateTime;
import java.util.Scanner;

/* Author: Joshua Stone
 * Date: Nov 19, 2021
 * Class: CSC 160 502
 * Assignment: 
 *
 * Program Description: 
*/

public class DriverReservation
{
	public static void main(String[] args)
	{
		Reservation res = new Reservation();
		LocalDateTime date = LocalDateTime.now();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to Le Bernardin, what would you like to do?");
		System.out.printf("[   Make Reservation     ]\n[   Check Avalibility    ]\n[   Cancel Reservation   ]\n");
		
		String answer = sc.nextLine();
		
		if (answer.toLowerCase().contains("make")) {
			
		} else if (answer.toLowerCase().contains("check") || answer.toLowerCase().contains("avalibility")) {
			System.out.println("Please enter day (dd)");
			String day = sc.next();
			if (day.charAt(0) != '0' && Integer.parseInt(day) < 10) {
				day = "0" + day;
			}
			
			sc.nextLine();
			String time = "-1";
			boolean isGoodTime = false;
		
			System.out.println("Please enter time (##:##)");
			while (isGoodTime == false) {
				time = sc.nextLine();
				if (time.matches("\\d:\\d\\d") || time.matches("\\d\\d:\\d\\d")) {
					isGoodTime = true;
				} else {
					System.out.println("Please type time in (##:##) format");
				}
			}
			if (time.charAt(1) == ':')
				time = "0" + time;
			answer = ("2021-11-" + day + "T" + time + ":00");
			date = LocalDateTime.parse(answer);
			System.out.println(res.checkDate(date));
		} else if (answer.toLowerCase().contains("cancel")) {
			
		}
		
		
		System.out.println(res.toString());

		
	}

}
