package Siguenza_Gabriel_HW3;


/************************************************
* COURSE:			  CS112 T -Th 1:30-3:20
* CHAPTER:		13	PROJECT NUMBER:		2
* PROGRAMMER: 		  Gabriel Siguenza
* DATE LAST MODIFIED: 11.05.2017
************************************************/

/************************************************
* PROGRAM TITLE:	  Date
* DESCRIPTION:		 a class that holds a date  
* 
* CLASS INVARIANT: Each date has a valid month, day and year
* 
* IMPORTED PACKAGES:  N/A
************************************************/
public class Date implements Cloneable
{
	/********** CONSTANTS *********/
	public static final String DEFAULT_MONTH = "December";
	public static final int DEFAULT_DAY = 31;
	public static final int DEFAULT_YEAR = 1959;


	/********** INSTANCE VARIABLES **********/	
	private String month;
	private int day;
	private int year; //four digit year
	
	
	
	/********** CONSTRUCTORS **********/	
	// DESCRIPTION:		Default constructor sets Date object to default values
	// PRE-CONDITION:	N/A
	// POST-CONDITION:	Sets instance variables to default values.
	public Date()	//Note: Default/No-Argument constructor
	{
		this.setAll(DEFAULT_MONTH, DEFAULT_DAY, DEFAULT_YEAR);
	}
	
	// DESCRIPTION:		Full constructor sets Date object to parameter values
	// PRE-CONDITION:	N/A
	// POST-CONDITION:	Sets instance variables to parameter values if valid,
	//					otherwise outputs error and exits program safely.
	public Date(String month, int day, int year)
	{
		boolean isValid;
		
		isValid = this.setAll(month, day, year); //if valid, sets data for us!
		if( !isValid )
		{
			System.out.println("ERROR: bad date in full constructor!");
			System.out.println("Exiting program...");
			System.exit(0);
		}
	}

	/* Incomplete.
	*//**
	 * Special Overloaded constructor initializes all instance variables from "/" seperated
	 * values.
	 *
	 * @param all
	 *//*
	public Date(String all) {

	}
	*/


	public Date(int month, int day, int year)
	{
		boolean isValid;
		
		isValid = this.setAll(Date.monthToString(month), day, year);
		if( !isValid )
		{
			System.out.println("ERROR: bad date in full (overloaded) constructor!");
			System.out.println("Exiting program...");
			System.exit(0);
		}

	}
	
	// DESCRIPTION:		Copy constructor sets Date object to parameter object values,
	//					making sure its a deep copy (separate + independent)
	// PRE-CONDITION:	N/A
	// POST-CONDITION:	Sets instance variables to parameter object values if object exists,
	//					otherwise outputs error and exits program safely.
	public Date(Date original)
	{
		if (original != null)
		{
			this.setAll(original.month, original.day, original.year);
		}
		else
		{
			System.out.println("ERROR: trying to copy NULL Date object. Exiting program...");
			System.exit(0);
		}
		
	}
	
	@Override
	public Object clone()
	{
		try
		{
			Date copy = (Date) super.clone();
			return copy;
		}
		
		catch(CloneNotSupportedException e)
		{
			return null;
		}
		
	}
	
	/********** SETTERS / MUTATORS **********/
	// DESCRIPTION:		Sets month instance variable with error checking
	// PRE-CONDITION:	Assume whoever calls this method handles error
	// POST-CONDITION:	Sets month instance variable to parameter only if valid.
	        //					Returns true if month is valid, false otherwise.
	public boolean setMonth(String month)
	{	
		//BEST WAY (boolean method, error checking only so more flexible):
		boolean isValid;
		
		isValid = Date.isValidMonth(month);
		
		if(isValid)
		{
			this.month = month;
		}
		
		return isValid;
		

	}
	
	// DESCRIPTION:		Sets month instance variable with error checking
	// PRE-CONDITION:	Assume whoever calls this method handles error
	// POST-CONDITION:	Sets month instance variable to parameter only if valid.
	//					Returns true if month is valid, false otherwise.
	public boolean setMonth(int month)
	{
		boolean isValid;

		//Note: can't use isValidMonth() since it requires giving
		//	it a String for month.
		isValid = (month >= 1 && month <= 12);
		
		if(isValid)
		{
			this.month = this.monthToString(month); //convert month # to string!
		}
		
		return isValid;
	}
	
	// DESCRIPTION:		Sets day instance variable with error checking
	// PRE-CONDITION:	Assume whoever calls this method handles error, only
	//					checking for 1-31 as valid day, regardless of month/year.
	// POST-CONDITION:	Sets day instance variable to parameter only if valid.
	//					Returns true if day is valid, false otherwise.
	public boolean setDay(int day)
	{
		boolean isValid;
		
		isValid = Date.isValidDay(day);
		
		if(isValid)
		{
			this.day = day;
		}
		
		return isValid;
	}
	
	// DESCRIPTION:		Sets year instance variable with error checking
	// PRE-CONDITION:	Assume whoever calls this method handles error,
	//					checking for 1000-9999 as valid year.
	// POST-CONDITION:	Sets year instance variable to parameter only if valid.
	//					Returns true if year is valid, false otherwise.
	public boolean setYear(int year)
	{
		boolean isValid;
		
		isValid = Date.isValidYear(year);
		
		if(isValid)
		{
			this.year = year;
		}
		
		return isValid;
	}
	
	// DESCRIPTION:		Sets all of Date's data at once
	// PRE-CONDITIONS:	Assume whoever calls this method handles error,
	//					checking for 1000-9999 as valid year and 1-31 as valid day.
	// POST-CONDITIONS:	Only sets instance variables to parameter values
	//					if ALL values are valid and returns true,
	//					otherwise sets NONE and returns false.
	public boolean setAll(String month, int day, int year) {
		boolean isValid;
		
		isValid = Date.isValidMonth(month) && Date.isValidDay(day)
					&& Date.isValidYear(year);		
		if(isValid)
		{
			this.setMonth(month);
			this.setDay(day);
			this.setYear(year);
		}
					
		return isValid;
	}

	public boolean setAll(int month, int day, int year) {
		boolean isValid;

		isValid = Date.isValidMonth(monthToString(month)) && Date.isValidDay(day)
				&& Date.isValidYear(year);
		if(isValid)
		{
			this.setMonth(month);
			this.setDay(day);
			this.setYear(year);
		}

		return isValid;
	}

	/********** GETTERS / ACCESSOR METHODS **********/
	// DESCRIPTION:		Gets value of month instance variable
	// PRE-CONDITION:	Instance variable has valid value
	// POST-CONDITION:	Returns valid month as String
	public String getMonth()
	{
		return this.month;
	}
	
	// DESCRIPTION:		Gets value of day instance variable
	// PRE-CONDITION:	Instance variable has valid value
	// POST-CONDITION:	Returns valid day as int
	public int getDay()
	{
		return this.day;
	}
	
	// DESCRIPTION:		Gets value of year instance variable
	// PRE-CONDITION:	Instance variable has valid value
	// POST-CONDITION:	Returns valid year as int
	public int getYear()
	{
		return this.year;
	}
	
	
	
	/********** OTHER REQUIRED METHODS **********/
	// DESCRIPTION:		Returns string representation of object
	// PRE-CONDITION:	Instance variables have valid values
	// POST-CONDITION:	Returns string with all instance variables as MM/DD/YY
	public String toString()
	{
		return this.monthToInt(this.month) + "/" + this.day + "/" + this.year;
		
		//OTHER OPTIONS (just make sure to update documentation appropriately):
		//return this.month + " " + this.day + ", " + this.year; //USA
		//return  this.day + " " + this.month  + ", " + this.year; //other countries
	}
	
	// DESCRIPTION:		Returns boolean is "this" Date is equal to parameter
	// PRE-CONDITION:	Instance variables have valid values for both Date objects
	// POST-CONDITION:	Returns true if both are exactly the same, false otherwise).
	public boolean equals(Object other)
	{
		Date otherDate;
		
		if(other == null)
		{
			return false;
		}
		else if(! (other instanceof Date))
		{
			return false;
		}
		else
		{
			otherDate = (Date) other;
			return this.month.equals(otherDate.month) && this.day == otherDate.day
					&& this.year == otherDate.year;
		}
	}

	/********** VALIDITY METHODS **********/
	// DESCRIPTION:		Checks if month parameter is valid
	// PRE-CONDITION:	N/A
	// POST-CONDITION:	Returns true for valid month, false otherwise.
	public static boolean isValidMonth(String month)
	{
		return Date.monthToInt(month) != 0;
	}
	
	// DESCRIPTION:		Checks if day parameter is valid
	// PRE-CONDITION:	N/A
	// POST-CONDITION:	Returns true for valid day (1-31), false otherwise.
	public static boolean isValidDay(int day)
	{
		return day >= 1 && day <= 31;
	}
	
	// DESCRIPTION:		Checks if year parameter is valid
	// PRE-CONDITION:	N/A
	// POST-CONDITION:	Returns true for valid year (1000-9999), false otherwise.
	public static boolean isValidYear(int year)
	{
		return year >= 1000 && year <= 9999;
	}
	
	
	/********** HELPER METHODS **********/
	
	// DESCRIPTION:		Converts month text into an integer
	// PRE-CONDITIONS:	N/A
	// POST-CONDITIONS:	Returns month as an integer: 1-12 if valid, otherwise 0
	private static int monthToInt(String month)
	{
		int result;
		
		if(month.equalsIgnoreCase("January"))
		{
			result = 1;
		}
		else if (month.equalsIgnoreCase("February"))
		{
			result = 2;
		}
		else if (month.equalsIgnoreCase("March"))
		{
			result = 3;
		}
		else if (month.equalsIgnoreCase("April"))
		{
			result = 4;
		}
		else if (month.equalsIgnoreCase("May"))
		{
			result = 5;
		}
		else if (month.equalsIgnoreCase("June"))
		{
			result = 6;
		}
		else if (month.equalsIgnoreCase("July"))
		{
			result = 7;
		}
		else if (month.equalsIgnoreCase("August"))
		{
			result = 8;
		}
		else if(month.equalsIgnoreCase("September"))
		{
			result = 9;
		}
		else if (month.equalsIgnoreCase("October"))
		{
			result = 10;
		}
		else if (month.equalsIgnoreCase("November"))
		{
			result = 11;
		}
		else if (month.equalsIgnoreCase("December"))
		{
			result = 12;
		}
		else
		{
			result = 0; //0 indicates error!
		}
		
		return result;
	}
	
	// DESCRIPTION:		Converts month number to text
	// PRE-CONDITIONS:	N/A
	// POST-CONDITIONS:	Returns month as text: if valid "January" etc., else null.
	private static String monthToString(int month)
	{
		String result;
		
		switch(month)
		{
			case 1:
				result = "January";
				break;
			case 2:
				result = "February";
				break;
			case 3:
				result = "March";
				break;
			case 4:
				result = "April";
				break;
			case 5:
				result = "May";
				break;
			case 6:
				result = "June";
				break;
			case 7:
				result = "July";
				break;
			case 8:
				result = "August";
				break;
			case 9:
				result = "September";
				break;
			case 10:
				result = "October";
				break;
			case 11:
				result = "November";
				break;
			case 12:
				result = "December";
				break;
			default:
				result = null;	//indicates error
				break;
		}
		
		return result;
	}
	
	// DESCRIPTION:		Print date using toString() method value
	// PRE-CONDITIONS:	All instance variables have valid values
	// POST-CONDITIONS:	Date values output to console
	public void writeOutput()
	{
		System.out.println( this.toString() );
	}

	// DESCRIPTION:		Determines if calling object comes before param Date
	// 			Checks month, day, year completely
	// PRE-CONDITIONS:	All instance variables have valid values for
	// 			calling object and param object
	// POST-CONDITIONS:	Returns boolean if calling object precedes param
	public boolean precedes(Date other)
	{
		int otherMonth, thisMonth;
		otherMonth = Date.monthToInt(other.month);
		thisMonth = Date.monthToInt(this.month);

		return (this.year < other.year) ||
			(this.year == other.year && thisMonth < otherMonth) ||
			(this.year == other.year && thisMonth == otherMonth && this.day < other.day);
	}
}
