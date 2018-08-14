/*	NYIT Spring 2018 FINAL_THF_J21  
		Group leader	ID: 1215675  name: Bridget Suski
		Java source class name: J21_BridgetS_Spring_2018_THF
 */
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class J21_BridgetS_Spring_2018_THF {

    public static boolean get_Yes_No(String ask, String popLable) //general y/n method created by Prof Wei in class
    {
        int ans = JOptionPane.showConfirmDialog(null, ask, popLable, 
                JOptionPane.YES_NO_OPTION);
        if (ans == JOptionPane.YES_OPTION) {
            return true;
        } else {
            System.out.println("Thank you for using this program.");
            return false; 
        }
    }

    public static final String title = "Welcome to the Student Schedule Program."
            + "\nThis program sorts students based on ID and displays which classes they are in with a HashMap."
            + "\nThis program was created by Bridget Suski,"
            + "\nwith the help of methods in class by Prof. Wei and the textbook."
            + "\n\nWould you like to use this program?";

    public static final String title2 = "Would you like to enter another student's information?";

    public static int get_value_GUI(String ask, String strBad, String doAgain) //another method from class by Prof. Wei, modified for this program
    {
        int value = 0; //placeholder
        String s;                  //placeholder
        Scanner k = new Scanner(System.in);
        boolean again = true;

        while (again) {
            
            s = JOptionPane.showInputDialog(ask);          //store the string FIRST, so that the user can see what they did wrong -- if anything.
            try {
                value = Integer.parseInt(s);      //attempt, if fail, try again
                return value;												//	& return to caller for good value
            } catch (NumberFormatException e) {
                System.out.print(strBad + s + doAgain);
            }
        }
        return value;
    }

    public static String get_sValue_GUI(String ask) //another method from class by Prof. Wei, modified for this program
    {
        String sValue = ""; //placeholder
        boolean again = true;

            sValue = JOptionPane.showInputDialog(ask);
        
        return sValue;
    }

    public static void main(String[] z) {

        if (JOptionPane.showConfirmDialog(null, title,
                "Click Yes or No:", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
            System.exit(0);
        }

        ArrayList<String> Courses = new ArrayList<String>(); //initalize everything
        int sID; //student ID
        String s = ""; //placeholder for classes
        HashMap<Integer, ArrayList<String>> Student = new HashMap<Integer, ArrayList<String>>(); //the hashmap

        boolean keepGoing = true; //use boolean to check
        
        while (keepGoing == true) {
            sID = get_value_GUI("Please enter a student ID, numbers only: ", "Invalid input: ", ". Try again.\n"); //get student ID
            s = get_sValue_GUI("Please enter which class this student is in."); //get the string of the class
            Courses.add(s); //add the string to the stringarray
            Student.put(sID, Courses); //add a map value of the student ID and course
            if (JOptionPane.showConfirmDialog(null, title2,
                    "Click Yes or No:", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) { //ask if the user wants to add another student/class or not
                keepGoing = false;
            }
        }
        printMap(Student); //Show the results at the end
    }

    static void printMap(HashMap<Integer, ArrayList<String>> map) //Method from the powerpoint, modified for this program
    {
        System.out.println("Map contains:\nSTUDENT ID\tCOURSES");
        int i = 0;
        for (Integer keys : map.keySet()) {
            ArrayList<String> courses = map.get(keys);
            System.out.println(keys + "\t\t" + courses.get(i)); //format it to look nicer
            i++;
        }
        System.out.println();
    }
}