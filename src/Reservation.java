import java.time.*;
import java.time.format.DateTimeFormatter;

/* Author: Joshua Stone
 * Date: Nov 19, 2021
 * Class: CSC 160 502
 * Assignment: 
 *
 * Program Description: 
*/

public class Reservation
{
	String name;
	String occasion;
	LocalDateTime date = LocalDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd 'at' hh:mm a");
	// 2d String array of dates. TODO replace this with .properties file for persistent data storage
	String[][] dateTimeArr = {{null, null, "tom"},{"kaile", null, null},{"emily", null, null},{null, "john", null},{"danny", "josh", "alex"},{null, null, null},{null, "cassandra", null},{"taylor", null, null},{null, null, "Krystal"},{null, "hannah", null},{"eduardo", null, null},{null, null, "lilpump"},{null, "omar", null},{"edgar", null, null},{"adam", null, "david"},{null, null, "alan"},{null, "mary", null},{"rebecca", null, null},{null, null, null},{null, "maria", null},{null, null, "jesus"},{null, "grace", null},{null, "skai", null},{"kimberly", null, null},{null, null, "manny"},{"karina", null, null},{null, null, "anna"},{"tyler", null, null},{"macayla", null, null},{null, null, "danny"}};
	
	/**
	 * Main Reservation
	 **/
	public Reservation()
	{
		name = "TempName";
		occasion = "TempOccasion";
		date = LocalDateTime.of(2021, Month.NOVEMBER, 1, 0, 0);
	}
	
	private String convertDateTime(LocalDateTime date) {
		int dayIndex = date.getDayOfMonth() - 1;
		int time = date.getHour();
		int timeIndex = -1;
		if (time == 6)
			timeIndex = 0;
		else if (time == 8)
			timeIndex = 1;
		else if (time == 10)
			timeIndex = 2;
		else {
			System.out.println("Error in time conversion!! " + time);
			System.exit(-1);
		}
		
		return dayIndex + "," + timeIndex;
	}

	/**
	 * Returns date field as string
	 * @author Joshua Stone
	 * @date Nov 19, 2021
	 * @callingProgram Reservation
	 * @return String
	 */
	public String getDateTime()
	{
		return String.format(date.format(formatter));
	}
	
	/**
	 * Sets date field
	 * @author Joshua Stone
	 * @date Nov 19, 2021
	 * @callingProgram Reservation
	 * @param name String
	 * @param date int
	 * @param time int
	 * @return void
	 */
	public void setDateTime(String name, LocalDateTime date) {
		String index = convertDateTime(date);
		int i = Integer.parseInt(index.substring(0, index.indexOf(',') ) );
		int j =Integer.parseInt(index.substring(index.indexOf(',') + 1, index.length() ) );
		dateTimeArr[i][j] = name;
		setDate(date);
	}
	
	/**
	 * Sets name field
	 * @author Joshua Stone
	 * @date Nov 19, 2021
	 * @callingProgram Reservation
	 * @param  name String
	 * @return void
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Replaces name field returns success or fail as boolean
	 * @author Joshua Stone
	 * @date Nov 19, 2021
	 * @callingProgram Reservation
	 * @param name String
	 * @param newName String
	 * @param date LocalDateTime
	 * @return boolean
	 */
	public boolean setName(String name, String newName) {
		if (name.equals(this.name) && (date == this.date)) {
			this.name = newName;
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Sets occasion field
	 * @author Joshua Stone
	 * @date Nov 19, 2021
	 * @callingProgram Reservation
	 * @param occasion String
	 * @return void
	 */
	public void setOccasion(String occasion) {
		this.occasion = occasion;
	}
	
	/**
	 * Print object as string
	 * @author Joshua Stone
	 * @date Nov 19, 2021
	 * @callingProgram Reservation
	 * @return String
	 */
	public String toString() {
		return String.format("Customer name: %s \nEvent occasion: %s \nDate: %s",
				name, occasion, String.format(date.format(formatter)));
	}
	
	
	/**
	 * Sets object date
	 * @author Joshua Stone
	 * @date Nov 19, 2021
	 * @callingProgram Reservation
	 * @param name String
	 * @param date LocalDateTime
	 * @return void
	 */
	private void setDate (LocalDateTime date) {
		if (name.equals(this.name)) {
			this.date = date;
		}
	}


	/**
	 * check slot in date array
	 * @author Joshua Stone
	 * @date Nov 19, 2021
	 * @callingProgram Reservation
	 * @param date LocalDateTime
	 * @return boolean
	 */
	public boolean checkDate(LocalDateTime date)
	{
		String index = convertDateTime(date);
		int i = Integer.parseInt(index.substring(0, index.indexOf(',') ) );
		int j =Integer.parseInt(index.substring(index.indexOf(',') + 1, index.length() ) );
		if (dateTimeArr[i][j] == null)
			return true;
		else
			return false;
	}

	/**
	 * Cancel reservation in date array
	 * @author Joshua Stone
	 * @date Nov 21, 2021
	 * @callingProgram TODO
	 * @param name String
	 * @param date LocalDateTime
	 * @return boolean
	 */
	public boolean cancel(String name, LocalDateTime date)
	{
		String index = convertDateTime(date);
		int i = Integer.parseInt(index.substring(0, index.indexOf(',') ) );
		int j =Integer.parseInt(index.substring(index.indexOf(',') + 1, index.length() ) );
		if (dateTimeArr[i][j].equals(name)) {
			dateTimeArr[i][j] = null;
			return true;
		} else
			return false;
	}

}


//for (int i = 0; i < dateTimeArr.length; i++)
//{
//	for (int j = 0; j < dateTimeArr[i].length; j++)
//	{
//		if (name.equals(dateTimeArr[i][j])) {
//			
//		}
//	}
//}