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
	
	/**
	 * Main Reservation
	 **/
	public Reservation()
	{
		name = "TempName";
		occasion = "TempOccasion";
		date = LocalDateTime.of(2021, Month.NOVEMBER, 1, 0, 0);
	}
	

	/**
	 * TODO Description
	 * @author Joshua Stone
	 * @date Nov 19, 2021
	 * @callingProgram Reservation
	 * @param String name
	 * @return String
	 */
	public String getDateTime(String name)
	{
		return String.format(date.format(formatter));
	}
	
	/**
	 * TODO Description
	 * @author Joshua Stone
	 * @date Nov 19, 2021
	 * @callingProgram Reservation
	 * @param Strin name, int date, int time
	 * @return void
	 */
	public void setDateTime(String name, int date, int time) {
		//TODO
	}
	
	/**
	 * TODO Description
	 * @author Joshua Stone
	 * @date Nov 19, 2021
	 * @callingProgram Reservation
	 * @param String name
	 * @return void
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * TODO Description
	 * @author Joshua Stone
	 * @date Nov 19, 2021
	 * @callingProgram Reservation
	 * @param String name, String newName, LocalDateTime date
	 * @return boolean
	 */
	public boolean setName(String name, String newName, LocalDateTime date) {
		if (name.equals(this.name) && (date == this.date)) {
			this.name = newName;
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * TODO Description
	 * @author Joshua Stone
	 * @date Nov 19, 2021
	 * @callingProgram Reservation
	 * @param String occasion
	 * @return void
	 */
	public void setOccasion(String occasion) {
		this.occasion = occasion;
	}
	
	/**
	 * TODO Description
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
	 * TODO Description
	 * @author Joshua Stone
	 * @date Nov 19, 2021
	 * @callingProgram Reservation
	 * @param String name, LocalDateTime date
	 * @return void
	 */
	private void setDate (String name, LocalDateTime date) {
		if (name.equals(this.name)) {
			this.date = date;
		}
	}


	/**
	 * TODO Description
	 * @author Joshua Stone
	 * @date Nov 19, 2021
	 * @callingProgram Reservation
	 * @param LocalDateTime date
	 * @return boolean
	 */
	public boolean checkDate(LocalDateTime date)
	{
		return true; //TODO add 2d array of date time slots
	}

}
