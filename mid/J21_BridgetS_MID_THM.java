/*	NYIT Spring_ 2018, CSCI_185_504, W01, prog2/java2, MIDTERM section 2 (THM)
	Team leader: Bridget Suski 
	THM Program title: Employee Salary List
 */
import javax.swing.JOptionPane;
import java.util.Scanner;

class SSNCharacterException extends Exception {     //ssncharacterexception class deals w/ letters in SSN 

    public SSNCharacterException(String message) {
        super(message);
    }

    public SSNCharacterException() {
        super("Incorrect SSN. Only enter decimals.");
    }

    public SSNCharacterException(String bS, char bC) {      //bS bad ssn, bC bad char
        super(bS + " is an incorrect SSN. It contains a character: " + bC);
    }
}

class SSNLengthException extends Exception {        //ssnlengthexception class deals w/ lack of 9 numbers

    public SSNLengthException() {
        super("Invalid SSN. It must be 9 numbers.");
    }

    public SSNLengthException(String bS, int bL) {      //bS bad ssn, bL bad length
        super(bS + "'s length of " + bL
                + " is invalid: it must be 9 characters and only numbers. ");
    }

    public SSNLengthException(String message) {
        super(message);
    }
} //END OF EXCEPTION CLASSES

public class J21_BridgetS_MID_THM {

    public static boolean get_Yes_No(String ask) //general method get Yes No from user, created in class by Prof Wei. Modified a little for this program.
    {
        System.out.print(ask);
        Scanner k = new Scanner(System.in);
        String ans = k.nextLine();
        return ans.equalsIgnoreCase("y");   //equalsIgnoreCase incase they type Y or y.
    }

    public static double get_value_GUI(String ask, String strBad, String doAgain) //another method from class by Prof. Wei, modified for this program
    {
        double value = 0.0; //placeholder
        String s;                  //placeholder
        Scanner k = new Scanner(System.in);
        boolean again = true;

        while (again) {
            System.out.print(ask);
            s = k.next();           //store the string FIRST, so that the user can see what they did wrong -- if anything.
            try {
                value = Double.parseDouble(s);      //attempt, if fail, try again
                return value;												//	& return to caller for good value
            } catch (NumberFormatException e) {
                System.out.print(strBad + s + doAgain);
            }
        }
        return value;
    }

    public static void main(String[] args) {
        Employee[] e = new Employee[100];   //e[i] stands for an individual employee, is an array, thanks to person class able to hold multiple values
        String name;    //later assigned by setName
        String ssn;        //later assigned
        double sum = 0;   //sum of the salary
        double aS;   //average salary
        Scanner k = new Scanner(System.in);

        boolean keepGoing = true;

        String title = "Welcome to the Employee Salary List Program."
                + "\nThis program stores employee SSN and salaries."
                + "\nThe program also determines if an employee's salary is average or not."
                + "\n\nDesigned by J21 Bridget Suski,"
                + "\nwith the help of methods gone over in class by Prof. Wei and the textbook."
                + "\n\nStep 1: Enter name, salary, & SSN for every person first."
                + "\nStep 2: The program then calculates the average salary."
                + "\nStep 3: It then returns which employees are average, below average, or above average."
                + "\n\nWould you like to use this program?";

        if (JOptionPane.showConfirmDialog(null, title,
                "Click Yes or No:", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
            System.exit(0);
        }

        int i = 0;
        while (keepGoing == true) {
            k = new Scanner(System.in);

            System.out.println();
            e[i] = new Employee();
            System.out.print("Enter employee #" + (i + 1) + "'s name: ");
            name = k.nextLine();
            e[i].setName(name);

            double placeHolder = get_value_GUI("Enter Salary for " + e[i].getName() + ": ",
                    "Bad data entered: ",
                    "\nPlease only use integers.  \n");
            e[i].setSalary(placeHolder);

            try {
                System.out.print("Enter SSN for " + e[i].getName() + ": ");
                ssn = k.nextLine();
                if (ssn.length() != 9) {    //check if ssn is enough digits
                    throw new SSNLengthException(ssn, ssn.length());
                } else {
                    for (int j = 0; j < 9; ++j) {   //check which digit is incorrect, can tell user exactly where error is
                        if (ssn.charAt(j) > '9' || ssn.charAt(j) < '0') {
                            throw new SSNCharacterException(
                                    ssn, ssn.charAt(j));
                        }
                    }
                }
                e[i].setSsn(ssn);
            } catch (SSNLengthException e1) {
                System.out.println(e1.getMessage());
                double ssnHolder = get_value_GUI("Try again. Re-enter " + e[i].getName() + "'s SSN: ",
                        "Bad data entered: ",
                        "\nPlease only use integers. Try again. \n");
                e[i].setSsn(Double.toString(ssnHolder));

            } catch (SSNCharacterException e2) {
                System.out.println(e2.getMessage());
                double ssnHolder = get_value_GUI("Try again. Re-enter " + e[i].getName() + "'s SSN: ",
                        "Bad data entered: ",
                        "\nPlease only use integers. Try again. \n");
                e[i].setSsn(Double.toString(ssnHolder));

            }
            i++;
            keepGoing = get_Yes_No("Would you like to enter another employee? Type Y or N: ");  //this is a boolean that continues if they say Y.
        }

        for (int j = 0; j < i; ++j) {   //i is the amt of times the loop above ran ; # of salaries to divide by in order to get sum
            sum = sum + e[j].getSalary();   //calc sum
        }

        aS = sum / i;   //calc average salary by dividing 

        System.out.println();
        for (int j = 0; j < i; ++j) {                   //random int j to count instead of i, since i already being used
            System.out.println("Employee " + (j + 1) + ".");     //list employee by number to help organize; remember to add one since elements start at 0.
            e[j].writeOutput(); //employee name

            if (e[j].getSalary() > aS) {    //above
                System.out.println("\t-- Salary is Above average --");
            } else if (e[j].getSalary() < aS) { //below
                System.out.println("\t-- Salary is Below average --");
            } else {    //else average
                System.out.println("\t-- Salary is Average --");
            }
        }
        System.out.println("\nJob Complete! \nThank you for using the Employee Salary List program.\nHave a great day!");   //yay the job is done
    }
}
