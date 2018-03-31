package printerQueue;

public class Timestamp extends Date
{
    /** CONSTANTS **/
    public static final int DEFAULT_HOUR = 23;
    public static final int DEFAULT_MINUTE = 59;
    public static final int DEFAULT_SECOND = 59;
    
    /** INSTANCE VARIABLES **/
    private int hour; //stored in 24 hour format, 0-23
    private int minute; //0-59
    private int second; //0-59

    /** CONSTRUCTORS **/
    public Timestamp()
    {
        this(DEFAULT_MONTH, DEFAULT_DAY, DEFAULT_YEAR,
                DEFAULT_HOUR, DEFAULT_MINUTE, DEFAULT_SECOND);
    }
    //NOTE: full constructors take in ALL instance vars (including from base class)
    public Timestamp(String month, int day, int year,
                     int hour, int minute, int second)
    {
        super(month, day, year);
        
        boolean isValid;

        isValid = this.setAll(hour, minute, second);
        if(!isValid)
        {
            System.out.println("ERROR: bad timestamp data given to constructor!");
            System.out.println("Exiting program...");
            System.exit(0);
        }
    }
    public Timestamp(Timestamp other)
    {
		//can't use super/this constructor call here, know why?
        if(other == null)
        {
			System.out.println("ERROR: Cannot copy null Timestamp object! Exiting...");
			System.exit(0);
		}
		else
		{
			//all are String or primitives, no shallow copying to worry about
			super.setAll(other.getMonth(), other.getDay(), other.getYear());
			this.setAll(other.hour, other.minute, other.second);
		}
    }

    //Overloaded useful constructors
    public Timestamp(String month, int day, int year,
                     int hour, int minute)
    {
        this(month, day, year, hour, minute, DEFAULT_SECOND);
    }
    public Timestamp(String month, int day, int year)
    {
        this(month, day, year, DEFAULT_HOUR, DEFAULT_MINUTE, DEFAULT_SECOND);
    }
    
    //description: initializes instance variables from comma separated string parameter
    //precondition: all has instance variable values separated by commas
    // in order: month, day, year, hour, min, sec
    // all above are integers except for month, which is a string
    //postcondition: initializes instance variables to values from string unless
    // values are missing, then ends program
    public Timestamp(String all)
    {
	String month;
	int day, year, hour, min, sec;
	String[] values;
	values = all.split(","); //splits string into array of strings at commas
	if(values.length == 6)
	{
		month = values[0];
		day = Integer.parseInt(values[1]);
		year = Integer.parseInt(values[2]);
		hour = Integer.parseInt(values[3]);
		min = Integer.parseInt(values[4]);
		sec = Integer.parseInt(values[5]);

		super.setAll(month, day, year);
		this.setAll(hour, min, sec); //may want to handle possible errors!
	}
	else
	{
		System.out.println("ERROR: bad csv string for constructor. Exiting...");
		System.exit(0);
	}
    }

    /** SETTERS **/
    public boolean setHour(int hour)
    {
        if(hour >= 0 && hour <= 23)
        {
            this.hour = hour;
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean setMinute(int minute)
    {
        if(minute >= 0 && minute <= 59)
        {
            this.minute = minute;
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean setSecond(int second)
    {
        if(second >= 0 && second <= 59)
        {
            this.second = second;
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean setAll(int hour, int minute, int second) //for time stuff only!
    {
        boolean isValid;
        isValid = Timestamp.isValidHour(hour) &&
                    Timestamp.isValidMinute(minute) &&
                    Timestamp.isValidSecond(second);
        if(isValid)
        {
            this.setHour(hour);
            this.setMinute(minute);
            this.setSecond(second);
        }
        return isValid;
    }

    /** GETTERS **/
    public int getHour()
    {
        return this.hour;
    }
    public int getMinute()
    {
        return this.minute;
    }
    public int getSecond()
    {
        return this.second;
    }
    public String getPeriod()
    {
        return (this.hour>12) ? "PM" : "AM";
    }

    public String getTime(boolean inMilitaryTime)
    {
        if(inMilitaryTime)
        {
            return String.format("%02d:%02d:%02d",
                    this.hour, this.minute, this.second);
        }
        else
        {
            return String.format("%02d:%02d:%02d %s",
                    this.hour%12, this.minute, this.second, this.getPeriod());
        }

    }
    public String getTime()
    {
        return getTime(false);
    }

    /** OTHER REQUIRED **/
    public String toString()
    {
        //24 hour format
        //return String.format("%s @ %s", super.toString(), this.getTime(true) );
        //12 hour format
        return String.format("%s @ %s", super.toString(), this.getTime() );
    }

    public boolean equals(Object other)
    {
		Timestamp otherTime;

		if(other == null || this.getClass() != other.getClass())
		{
			return false;
		}
		else
		{
			otherTime = (Timestamp) other;
			
			return super.equals(otherTime) && this.hour == otherTime.hour &&
                this.minute == otherTime.minute && this.second == otherTime.second;
		}
    }

    /** HELPER METHODS **/
    private static boolean isValidHour(int hour)
    {
        return hour >= 0 && hour <= 23;
    }
    private static boolean isValidMinute(int minute)
    {
        return minute >= 0 && minute <= 59;
    }
    private static boolean isValidSecond(int second)
    {
        return second >= 0 && second <= 59;
    }

}
