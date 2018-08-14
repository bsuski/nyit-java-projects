/*	NYIT Spring_ 2018, CSCI_185_504, W01, prog2/java2, MIDTERM section 2 (THM)
	Team leader: Bridget Suski 
	THM Program title: Employee Salary List -- EMPLOYEE FILE
                       This file contains methods from Person + is used in main MID_THM. 
 */
public class Employee extends Person {

    private double salary;
    private String ssn;    // Social Security Number - **INITIALLY DIFFERENT FROM PUBLIC STRING SSN in MID_THM
    
    //various constructors for employee 
    public Employee() {
        super();    //Person ref.
        salary = 0; //may as well set to 0 as default
        ssn = null;  //to be assigned by user
    }

    public Employee(String eN) //employee name
    {
        super(eN);
        salary = 0;
        ssn = null;
    }

    public Employee(String eN, double eS) //employee name and salary
    {
        super(eN);
        ssn = null;
        salary = eS;
    }

    public Employee(String eN, String eSsn) //employee name again & ssn (cannot be ssn since that's the private variable)
    {
        super(eN);
        ssn = eSsn;
        salary = 0;
    }

    public Employee(String eN, double eS, String eSsn) {
        super(eN);
        ssn = eSsn;
        salary = eS;
    }

    public void set(String nN, double nS, String nSsn) //new name, new salary & new ssn
    {
        setName(nN);
        salary = nS;
        ssn = nSsn;
    }

    public void setSsn(String nSsn) {
        ssn = nSsn;
    }

    @Override
    public void writeOutput() //just like the person class! overridden here
    {
        super.writeOutput();
        System.out.println("Salary: " + salary);
        System.out.println("SSN: " + ssn);
    }

    public void writeN() //prints name
    {
        super.writeOutput();
    }

    public void writeS() //prints salary
    {
        System.out.println("Salary: $" + salary);
    }

    public void writeSsn() //prints ssn
    {
        System.out.println("SSN: " + ssn);
    }

    public void setSalary(double nS) //similar to person class but different application. accessor method.
    {
        salary = nS;
    }

    public double getSalary() //getter method
    {
        return salary;
    }

    public String getSsn() {
        return ssn;
    }
}
