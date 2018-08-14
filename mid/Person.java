/**
 * Here is the person class from the textbook. All credit to the textbook author! 
 * Removed some unnecessary methods that will not be used in the Salary program. 
 */

public class Person
{
    private String name;


    public Person()
    {
        name = "No name yet.";
    }

    public Person(String initialName)
    {
        name = initialName;
    }

    public void setName(String newName)
    {
        name = newName;
    }

    public String getName()
    {
        return name;
    }

    public void writeOutput()   //overridden in Employee
    {
        System.out.println("Name: " + name);
    }

}