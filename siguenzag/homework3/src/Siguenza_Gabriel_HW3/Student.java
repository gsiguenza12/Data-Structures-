package Siguenza_Gabriel_HW3;

public class Student
{
    private String name;

    //Student Constructors
    public Student()
    {
        name = "";
    }

    public Student(String name)
    {
        this.name = name;
    }

    //Set methods
    public void setName(String name)
    {
        this.name = name;
    }

    //Get methods
    public String getName()
    {
        return name;
    }

    //toString method
    public String toString()
    {
        return name;
    }
}//End of Student Class