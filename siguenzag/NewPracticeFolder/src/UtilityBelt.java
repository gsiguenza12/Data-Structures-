/************************************************
* COURSE:			  CS112 T -Th 1:30-3:20
* CHAPTER:			PROJECT NUMBER:	
* PROGRAMMER: 		  Gabriel Siguenza
* DATE LAST MODIFIED: 12.11.2017
************************************************/

/************************************************
* PROGRAM TITLE:	 UtilityBelt
* DESCRIPTION:		  
* --------------------------------------------------
* |
* |	UtilityBelt
* |
* --------------------------------------------------
* |
* | + printHeader() : void
* |	// outputs author info for project
* | + printCentered( width : int, text : String) : void
* |	// outputs centered text within given width 
* | + readInt(prompt : String, key : Scanner, lower: int, upper : int) : int
* | 	// returns valid int from user (or Integer.MIN_VALUE for invalid input)
* | + readDouble(prompt : String, key : Scanner, lower: double, upper : double) : double
* | 	// returns valid double from user (or Double.MIN_VALUE for invalid input)
* | + readChar(prompt : String, key : Scanner, validChars : String) : char
* | 	// returns valid char from user (must be char within give validChars), or ' ' for invalid input
* --------------------------------------------------
*/

import java.io.*;
import java.util.Scanner;

public class UtilityBelt
{
	// CONSTANTS
	public static final String NAME = "YOUR NAME HERE";
	public static final String COURSE = "CS 111 Intro to CS I";
	public static final String SECTION = "TuTh 11:30am-3:20pm";

	// DESCRIPTION:		Print author information for start of program
	// PRE-CONDITIONS:	All parameters are given valid values
	// POST-CONDITIONS:	Outputs author info to console
	public static void printHeader(int homework, int project, String lastModified)
	{
		//output
		System.out.println("/********************************************");
		System.out.println("* AUTHOR:        " + NAME);
		System.out.println("* COURSE:        " + COURSE);
		System.out.println("* SECTION:       " + SECTION);
		System.out.println("* HOMEWORK #:    " + homework);
		System.out.println("* PROJECT #:	 " + project);
		System.out.println("* LAST MODIFIED: " + lastModified);
		System.out.println("********************************************/");
	}
	
	// DESCRIPTION:		centers text value within total width given for one line
	// PRECONDITIONS:	text is not null, width > 0
	// POSTCONDITIONS:	prints text centered and taking up entire width (with new line after)
	public static void printCentered(int width, String text)
	{
		int leftWidth;
		String spec;
		
		leftWidth = (width + text.length() ) / 2;
		spec = "%" + leftWidth + "s"; //automatically right justified
		
		System.out.printf(spec + "%n", text);
		
	}

	// DESCRIPTION:		reads input from user, returns integer value (error-checked using bounds)
	// PRECONDITIONS:	key is instantiated, prompt is in form "Enter...: ", lower < upper
	// POSTCONDITIONS:	returns integer value between lower and upper (inclusive)
	public static int readInt(String prompt, Scanner key, int lower, int upper)
	{
		String temp;
		int result;
		boolean isNotValid;
		
		isNotValid = true; // initialize all variables, Compiler will complain because they are initialized in loop
		result = 0;
		
		do
		{
			System.out.print(prompt);
			temp = key.nextLine();
			
			try
			{
				result = Integer.parseInt(temp);
				isNotValid = (result < lower) || (result > upper);
				
				if(result == 666)
				{
					return result;
				}
				//Still perform old check but with Exceptions
				if(isNotValid)
				{
					System.out.println("ERROR: please enter value between " + lower + " - " + upper);
				}
			}
			catch(NumberFormatException e)
			{
				System.out.println(e.getMessage());
			}
			
		} while(isNotValid);

		return result;
	}

	// DESCRIPTION:		reads input from user, returns double value (error-checked using bounds)
	// PRECONDITIONS:	key is instantiated, prompt is in form "Enter...: ", lower < upper
	// POSTCONDITIONS:	returns double value between lower and upper (inclusive)
	public static double readDouble(String prompt, Scanner key, double lower, double upper)
	{
		String temp;
		double result;
		boolean isNotValid;
		
		isNotValid = true;
		result = 0;
		
		do
		{
			System.out.print(prompt);
			temp = key.nextLine();
			
			try
			{
				result = Double.parseDouble(temp);
				isNotValid = (result < lower) || (result > upper);
				
				if(isNotValid)
				{
					System.out.println("ERROR: please enter value between " + lower + " - " + upper);
				}
			}
			catch(NumberFormatException nfe)
			{
				System.out.println("ERROR: double input is required");
			}
		} while(isNotValid);

		return result;
	}

	// DESCRIPTION:		reads input from user, returns char value (only allowed chars are contained in validChars)
	// PRECONDITIONS:	key is instantiated, prompt is in form "Enter...: "
	// POSTCONDITIONS:	returns valid char value (must be within validChars)
	public static char readChar(String prompt, Scanner key, String validChars)
	{
		String temp;
		char result;
		boolean isNotValid;
		
		isNotValid = true;
		result = 0;
		
		do
		{
			System.out.print(prompt);
			temp = key.nextLine();
			try
			{
				result = temp.charAt(0);
				isNotValid = validChars.indexOf(result) == -1;
			
				if(isNotValid)
				{
					System.out.println("ERROR: please enter one of the following valid chars: " + validChars);
				}
			}
			catch(StringIndexOutOfBoundsException sOutOfBounds)
			{
				System.out.println("ERROR: input type does not match");
			}
		} while(isNotValid);

		return result;
	}
	/**
	 * BINARY SEARCH Searches the array a for key. If key is not in the array segment,
	 * then -1 is returned. Otherwise returns an index in the segment such
	 * that key == a[index].
	 * 
	 * Precondition: a[first] <= a[first + 1] ... <= a[last]
	 */ 
	public static int search(int[] a, int first, int last, int key)
	{
		int result = 0;
		
		if (first > last)
		{
			result = -1;
		}
		else
		{
			int mid = (first + last)/2;
			
			if (key == a[mid])
			{
				result = mid;
			}
			else if(key < a[mid])
			{
				result = search(a, first, mid - 1, key);
			}
			else if (key > a[mid])
			{
				result = search(a, mid + 1, last, key);
			}
		}
		return result;
	}
	
	// PRINT ARRAY METHOD
	// DESCRIPTION:		outputs contents of array to console
	// PRECONDITIONS:	array has been instantiated
	// POSTCONDITIONS:	prints array
	public static void printArray(double[] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			System.out.println("# " + (i + 1) + ": " + arr[i]);
		}
		
	}
	public static void printArray(int[] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			System.out.println("# " + (i + 1) + ": " + arr[i]);
		}
		
	}
	
	
	//INITIALIZE ARRAY METHOD
	// DESCRIPTION:		initializes array to given value
	// PRECONDITIONS:	array has been instantiated
	// POSTCONDITIONS:	sets each index of array to parameter value 
	public static void initializeArray(double[] arr, double value)
	{
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = value;
		}
		
	}
	public static void initializeArray(int[] arr, int value)
	{
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = value;
		}
		
	}
	
	
	//COPY ARRAY METHOD
	// DESCRIPTION:		takes in double array as parameter returns deep copy
	// PRECONDITIONS:	original array has been instantiated
	// POSTCONDITIONS:	returns a new deep copy of array
	public static double[] copyArray(double[] original)
	{
		double[] copy;
		copy = new double[original.length];
		
		for(int i = 0; i < copy.length; i++)
		{
			copy[i] = original[i];
		}
		return copy;
	}
	
	// DESCRIPTION:		takes in int array as parameter returns deep copy
	// PRECONDITIONS:	original array has been instantiated
	// POSTCONDITIONS:	returns a new deep copy of array
	public static int[] copyArray(int[] original)
	{
		int[] copy;
		copy = new int[original.length];
		
		for(int i = 0; i < copy.length; i++)
		{
			copy[i] = original[i];
		}
		return copy;
	}
	
	// ARRAY OF OBJECTS(homeworkProject.Date)
	// DESCRIPTION: example of array clone method for array containing objects
	
	
	// ARRAYS EQUALS METHOD only job is to test for equal arrays
	// DESCRIPTION:		takes in two double arrays as arguments
	// PRECONDITIONS:	both arrays have been instantiated
	// POSTCONDITIONS:	returns boolean, true if arrays contain the same data, false otherwise
	public static boolean equals(double arr1[], double arr2[])
	{
		if(arr1.length != arr2.length)
		{
			return false;
		}
		else
		{
			int i = 0;
			while(i < arr1.length)
			{
				if(arr1[i] != arr2[i])
				{
					return false;
				}
				i++;
			}
			
			// Note: omit the following lines of code, notes are only relevant to developer
			if(arr1 == arr2)
			{
				System.out.println("CAUTION: These two objects are pointing to the same reference(shallow copy).");
			}
			else
			{	
				System.out.println("Arrays are seperate & independent objects that contain the same data(deep copy)");
			}
			return true;
		}
	}
	
	// DESCRIPTION:		takes in two int arrays as arguments
	// PRECONDITIONS:	both arrays have been instantiated
	// POSTCONDITIONS:	returns boolean, true if arrays contain the same data, false otherwise
	public static boolean equals(int arr1[], int arr2[])
	{
		if(arr1.length != arr2.length)
		{
			return false;
		}
		else
		{
			int i = 0;
			while(i < arr1.length)
			{
				if(arr1[i] != arr2[i])
				{
					return false;
				}
				i++;
			}
			
			// Note: omit the following lines of code, notes are only relevant to developer
			if(arr1 == arr2)
			{
				System.out.println("CAUTION: These two objects are pointing to the same reference(shallow copy).");
			}
			else
			{	
				System.out.println("Arrays are seperate & independent objects that contain the same data(deep copy)");
			}
		return true;
		}
	}

	// if we pass the file name and outputStream, this method can work as if it was in main since file being written to doesn't change.
	// METHOD TO WRITE THE OBJECT PETRECORD TO FILE. can this be even more modular?

	/**
	 * Writes Serializable object of type PetRecord to binary file.
	 *
	 * @param outputStream
	 * @param fileName
	 * @param PetRecord...arg
	 */
	public static void writeSerializable(ObjectOutputStream outputStream, String fileName, PetRecord... arg)// method can take any number of PetRecord Objects as arguments.
	{														// no because parameters must specify class type.. hmm.

		try
		{
			// Instantiating outputStream with ObjectOutputStream and nested FileOutputStream constuctors.
			outputStream = new ObjectOutputStream(new FileOutputStream(fileName));

			// some code to read in constructor fields from user. (string, int, double)

			for(int i = 0; i < arg.length; i++)
			{
				outputStream.writeObject(arg[i]);
				System.out.println("\nRecords have been loaded");
			}

			// some code to write the Object to file.

			outputStream.close();
			System.out.println("Data sent to file.");
		}

		catch(IOException e)
		{
			System.out.println("Error writing data to file.\nExiting program...");
			System.exit(0);

		}

	}

	/**
	 * Appends and writes object to an existing binary file, using Append hack written by Professor: June Porto.
	 * Takes in an array of PetRecords and writes them one by one to the binary file.
	 *
	 * @param out
	 * @param fileName
	 * @param PetRecord...arg Variable number of arguments, accepts an array of PetRecords so multiple records can be written without
	 * having to call the method again.
	 */
	public static void appendSerializable(AppendObjectOutputStream out, String fileName, PetRecord...arg)
	{
		try
		{
			out = new AppendObjectOutputStream(new FileOutputStream(fileName,true));

			for(int i = 0; i < arg.length; i++)
			{
				out.writeObject(arg[i]);
				System.out.println("\nRecords have been loaded");
			}

			// some code to write the Object to file.

			out.close();
			System.out.println("Data sent to file.");
		}
		catch(IOException e)
		{
			System.out.println("Error writing data to file.\nExiting program...");
			System.exit(0);
		}

	}

	/**
	 * Reads in Serializable Objects of type PetRecord from a binary file.
	 *
	 * @param inputStream Needed to access the binary file and connect a FileInputStream to fileName.
	 * @param fileName Used to indicate the name of the file to be accessed and read from.
	 * @return Returns an object of type PetRecordArray where each index contains a PetRecord object built from the binary file.
	 */
	public static PetRecordArray readSerializable(ObjectInputStream inputStream, String fileName)
	{
		PetRecordArray readIn = new PetRecordArray();
		try
		{

			System.out.println("\nAttempting to read from the file " + fileName + "...");

			// Attempt to read from specified file
			inputStream = new ObjectInputStream(new FileInputStream(fileName));

			// some code to read object from file
			System.out.println("Reading in records...");
			try
			{
				PetRecord newPet = new PetRecord();

				while(true)
				{
					newPet = (PetRecord) inputStream.readObject();
					readIn.addPet(newPet);
				}
			}
			catch(EOFException e)
			{
				System.out.println("Complete.\n");

			}
			catch(NullPointerException e)
			{
				System.out.println("fatal error: Index is null or invalid!\nTerminating program...");
				System.exit(0);
			}
			inputStream.close();

			// output contents to screen
			readIn.printArray();
		}

		catch(FileNotFoundException e)
		{
			System.out.println("Cannot locate file.\nTerminating program...");
			System.exit(0);

		}


		catch(ClassNotFoundException e)		//Class not found may be thrown when trying to write an object of a class to binary file.
		{
			System.out.println("Unable to locate any pet records files. DataBase empty?");
			System.out.println("Exiting program safely... \n\n\nWhile you figure that out buddy.");
			System.exit(0);
		}


		catch(IOException e)
		{
			System.out.println("Problems loading files.\nExiting program...");
			System.exit(0);
		}

		return readIn;

	}
}

