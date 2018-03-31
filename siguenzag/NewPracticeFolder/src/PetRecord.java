/************************************************
* COURSE:			  CS112 T -Th 1:30-3:20
* CHAPTER:	10 Handout	PROJECT NUMBER:	2
* PROGRAMMER: 		  Gabriel Siguenza
* DATE LAST MODIFIED: 09.29.2017
************************************************/

/************************************************
* PROGRAM TITLE:	PetRecord
* DESCRIPTION:	Class for basic pet records: name, age, and weight.	  
* 
* CLASS INVARIANT: PetRecord instance variables age and weight are nonnegative
* 
* IMPORTED PACKAGES:  N/A
************************************************/

import java.io.Serializable;

public class PetRecord implements Serializable
{
    private String name;
    private int age;         //in years
    private double weight;   //in pounds

	// SHOULD BE A TOSTRING()
    public void writeOutput()
    {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age + " years");
        System.out.println("Weight: " + weight + " pounds");
    }
	
	/************ CONSTRUCTORS ************/
	public PetRecord()
    {
        name = "No name yet.";
        age = 0;
        weight = 0;
    }
    
    public PetRecord(String initialName, int initialAge,
                                          double initialWeight)
    {
        name = initialName;
        if ((initialAge < 0) || (initialWeight < 0))
        {
            System.out.println("Error: Negative age or weight.");
            System.exit(0);
        }
        else
        {
            age = initialAge;
            weight = initialWeight;
        }
    }
    
    // POSTCONDITION: original's values contain valid data.
    public PetRecord(PetRecord original)
    {
		if (original == null)
		{
			System.out.println("fatal error: attempting to copy null! Terminating program...");
			System.exit(0);
		}
		name = original.getName();
		age = original.getAge();
		weight = original.getWeight();
	}
	
	public PetRecord clone()
	{
		return new PetRecord(this);
	}
	
    // Individual Constructors for instance variables
    public PetRecord(String initialName)
    {
        name = initialName;
        age = 0;
        weight = 0;
    }
    
    public PetRecord(int initialAge)
    {
        name = "No name yet.";
        weight = 0;
        if (initialAge < 0)
        {
            System.out.println("Error: Negative age.");
            System.exit(0);
        }
        else
            age = initialAge;
    }
    
    public PetRecord(double initialWeight)
    {
        name = "No name yet";
        age = 0;
        if (initialWeight < 0)
        {
            System.out.println("Error: Negative weight.");
            System.exit(0);
        }
        else
            weight = initialWeight;
    }
	
	/************ MUTATORS ************/
	
	// sets instance variables with error checking!
    public void set(String newName, int newAge, double newWeight)		
    {
        name = newName;
        if ((newAge < 0) || (newWeight < 0))
        {
            System.out.println("Error: Negative age or weight.");
            System.exit(0);
        }
        else
        {
            age = newAge;
            weight = newWeight;
        }
    }

    public void setName(String newName)
    {
        name = newName; 
    }


    public void setAge(int newAge)		// Make a static method that returns a boolean to check VALID input.
    {
        if (newAge < 0)
        {
            System.out.println("Error: Negative age.");
            System.exit(0);
        }
        else
            age = newAge;        
    }

    public void setWeight(double newWeight)
    {
        if (newWeight < 0)
        {
            System.out.println("Error: Negative weight.");
            System.exit(0);
        }
        else
            weight = newWeight; 
    }

	/************ ACCESSORS ************/
    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public double getWeight()
    {
        return weight;
    }
    
    /************ CLASS METHODS ************/
    
   // Include toString()
   public String toString()
   {
	   return name + ", Age: " + age + ", Weight: " + weight;
   }
   // equals() 
   public boolean equals(Object other)
   {
	   if(other == null)
	   {
		   return false;
	   }
	   else if(getClass() != other.getClass())
	   {
		   return false;
	   }
	   else
	   {
		   PetRecord otherPet = (PetRecord) other;
		   return (name.equals(otherPet.getName()) && age == otherPet.getAge() && weight == otherPet.getWeight());
	   }
   }
    
}
