/*	NYIT Spring_ 2018, CSCI_185_504, W01, Chapter 9 Homework Question 1
	By Bridget Suski with modified methods from class by Prof Wei.
	Program title: Clock Converter

            TO DO:
                - GUI not scanner program, but can use scanner for verification
                - read time as a string initially
                - detect for ANYTHING OTHER THAN numbers and ':'
                    upon detection, roll exception 
					
	This program takes military time and converts it to a 12:00 time format.
 */
import javax.swing.JOptionPane;
import java.util.Scanner;

public class J21_BridgetS_HW6_Ch9Q1 {
    static String amPm; static String t1S;
    static char c1, c2, c3, c4, c5; //placeholders until reassigned
    static int hours;
    static class TimeFormatException extends Exception {       //exception class, catches incorrect time entries

        public TimeFormatException(String message) {
            super(message);
        }

        public TimeFormatException() {
            super("Incorrect time format. Only enter decimals and ':'. You entered: ");
        }
    }

    public static boolean get_Yes_No(String ask, String popLable) //general y/n method created by Prof Wei in class
    {
        int ans = JOptionPane.showConfirmDialog(null, ask, popLable, //popTitle is the head lable of the
                JOptionPane.YES_NO_OPTION);
        if (ans == JOptionPane.YES_OPTION) {
            return true;
        } else {
            System.out.println("Thank you for using this program.");
            return false;								//user clicks No button
        }
    }

    public static final String title = "Welcome to the Clock Converter Program."
            + "\nThis program was created by Bridget Suski,"
            + "\nwith the help of methods in class by Prof. Wei and the textbook."
            + "\n\nWould you like to use this program?";

        public static void main(String[] args)
    {
         if (JOptionPane.showConfirmDialog(null, title,
                "Click Yes or No:", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
            System.exit(0);
        }
                 
        boolean repeat;
        do 
        {
            convertTime(); //runs big try method
            repeat = get_Yes_No("Would you like to run the program again?", "Please click Yes or No.");

        }while ((repeat == true));
    }

    public static void convertTime()
    {
        amPm = "AM"; 

        try
        {
            Scanner k = new Scanner(System.in);

            System.out.print("Enter time in 24-hour (military) notation, such as 03:00 : ");
            t1S = k.next();

            if (t1S.length() != 5) {
                throw new TimeFormatException(); //user did not enter an appropriately sized string, conversion will fail.
            }

            c1 = t1S.charAt(0); c2 = t1S.charAt(1); c3 = t1S.charAt(2);
            c4 = t1S.charAt(3); c5 = t1S.charAt(4);
            
            switch(c1) //could also be done with a loop
            {
                case '0':
                    hours = 0;
                    break;
                case '1':
                    hours = 10;
                    break;
                case '2':
                    hours = 20;
                    break;
                default:
                    throw new TimeFormatException();
            }

            switch(c2)
            {
                case '0':
                    break;
                case '1':
                    hours++;
                    break;
                case '2':
                    hours = hours + 2;
                    break;
                case '3':
                    hours = hours + 3;
                    break;
                case '4':
                    hours = hours + 4;
                    break;
                case '5':
                    hours = hours + 5;
                    break;
                case '6':
                    hours = hours + 6;
                    break;
                case '7':
                    hours = hours + 7;
                    break;
                case '8':
                    hours = hours + 8;
                    break;
                case '9':
                    hours = hours + 9;
                    break;
                default:
                    throw new TimeFormatException();
            }

            if(hours> 23) //various what-ifs that need to be accounted for, ex, too many hours, am or pm, etc.
                throw new TimeFormatException();
            if(hours > 11 || hours == 0)
                amPm = "PM"; //am is default so no need to detect it
            if(hours > 12)
                hours = hours - 12; //midnight detected at 0 instead of 24 to avoid it breaking here
            if(c3 != ':')
                throw new TimeFormatException();

            System.out.print("In 12-hour notation, that would be: ");
            System.out.print(hours + ":");
 
            if(hours == 12) amPm = "noon"; //help user differentiate between noon + midnight
            if(hours == 0) amPm = "midnight";
            
            String minute = c4 + "" + c5; //No need to convert minutes
            System.out.println(minute + " " + amPm);
        }

        catch(TimeFormatException e)
        {
            System.out.print(e.getMessage());
            System.out.print(t1S); //t1S is the original string the user input, which will show the error.
            System.exit(0);
        }
    }
}
