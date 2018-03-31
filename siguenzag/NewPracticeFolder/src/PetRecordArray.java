/************************************************
 * COURSE:                      CS112 T -Th 1:30-3:20
 * CHAPTER:                   PROJECT NUMBER: 
 * PROGRAMMER:                  Gabriel Siguenza
 * DATE LAST MODIFIED: 10.09.2017
 *************************************************/

/************************************************
 * PROGRAM TITLE:      PetRecordArray.java 
 * DESCRIPTION:        A partially filled array class
 * for objects of PetRecord class
 * 
 * CLASS INVARIANT: All PetRecord's are valid PetRecord objects and all PetRecord's are at the beginning of the array up to the highest index with no gaps.
 *  
 * IMPORTED PACKAGES:  java.io.Serializable 
 **************************************************/

import java.io.Serializable;

public class PetRecordArray implements Serializable
{
	/************ CONSTANTS ************/
	public static final int MAX_LENGTH = 10000; // This list will hold a max of 10,000 pet records. 

	/************ VARIABLE DECLARATION ************/
	PetRecord [] pets;
	int numUsed;
	int capacity;
	
	/************ CONSTRUCTORS ************/
	PetRecordArray()
	{
		pets = new PetRecord[MAX_LENGTH];
		capacity = MAX_LENGTH;
		numUsed = 0; 							// No used indices yet.
	}
	
	PetRecordArray(int length)					// allows user to set the length of the Partially filled array.
	{
		pets = new PetRecord[length];
		capacity = length;
		numUsed = 0;
	}
		
	// COPY CONSTRUCTOR
	PetRecordArray(PetRecordArray original)
	{
		if(original == null)
		{
			System.out.println("fatal error: attempting to copy null terminating program...");
			System.exit(0);
		}
		
		numUsed = original.getNumberOfPets();
		pets = new PetRecord[original.getCapacity()];
		
		for(int i = 0; i < numUsed; i++)
		{
			pets[i] = original.pets[i].clone();
		}
	}
	
	public PetRecordArray clone()
	{
		return new PetRecordArray(this);
	}
	
	/************ ACCESSORS ************/
	//getNumberOfPets() : int 
	public int getNumberOfPets()
	{
		return numUsed;
	}
	
	// getCapacity() : int
	public int getCapacity()
	{
		return capacity;
	}
	
	// getPet() : PetRecord
	public PetRecord getPet(int index)
	{
		return pets[index];
	}
	
	// boolean empty() : boolean
	public boolean empty()
	{
		return (numUsed == 0);
	}
	// boolean full() : boolean
	public boolean full()
	{
		return (numUsed == capacity);
	}
	/************ MUTATORS ************/
	// addPet(pet : PetRecord) : void  
	public void addPet(PetRecord newPet)
	{
		if(full())
		{
			System.out.println("cannot add PetRecord, dataBase is full!\nTerminating program...");
			System.exit(0);
		}
		else 
		{
			pets[numUsed] = newPet.clone();
			numUsed ++;
		}
	}
	
	// editPet(index : int, newPet : PetRecord) : void 
	
	// deletePet(index : int) : void
	
	// deleteLast() : void
	public void deleteLastPet()
	{
		pets[numUsed] = null;
		numUsed--;
	}
	// printArray() : void
	public void printArray()
	{
		for(int i = 0; i <= numUsed-1; i++)
		{
			System.out.println(pets[i]);
		}
	}
	/************ CLASS METHODS ************/
	
	// toString() : void 			// may take a while with a full database.
	
	// equals() : void
}

