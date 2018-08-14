import java.util. Scanner;	//Created with the template from class.
 
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
    public class J21_BridgetS_HW2_BMI
    {           
        public static void main(String[] args)
        {
		
		/**Start building the jframe; this will: 
		(1) Implement the same required features and functions as of CH07 HW#1, 
		modify the program to apply JTextArea for I/P of BMI user name, weight and height.
		(2) Display the O/P in GUI style.
		http://www.java2s.com/Tutorial/Java/0240__Swing/UsingJTextArea.htm for help + textbook
		**/
		    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("JTextArea Test");
    frame.setLayout(new FlowLayout());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    String text = "A JTextArea object represents a multiline area for displaying text. "
        + "You can change the number of lines that can be displayed at a time, "
        + "as well as the number of columns. You can wrap lines and words too. "
        + "You can also put your JTextArea in a JScrollPane to make it scrollable.";
    JTextArea textAreal = new JTextArea(text, 5, 10);
    textAreal.setPreferredSize(new Dimension(100, 100));
    JTextArea textArea2 = new JTextArea(text, 5, 10);
    textArea2.setPreferredSize(new Dimension(100, 100));
    JScrollPane scrollPane = new JScrollPane(textArea2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    textAreal.setLineWrap(true);
    textArea2.setLineWrap(true);
    frame.add(textAreal);
    frame.add(scrollPane);
    frame.pack();
    frame.setVisible(true);
        /**-- FIRST PROGRAM CODE UNDERNEATH --**/

			final int sz = 100;
        
           // max # of BMI
            String	[ ] name = new String [sz];
            double[ ] weight = new double [sz];
            double[ ] height = new double [sz];
            double [ ] BMI = new double[sz];

            final double BMIUnder = 18.5;
            final double BMINormal = 25.0;
            final double BMIOver = 30.0;
            final double BMIObese = 30.0;

            int normalWeight = 0;       // count # of normal weight 
            int overWeight = 0;                //count# of overweight
            int obese = 0;     // count # of obese people
            int underWeight = 0; //count # of underweight people
            
		Scanner k = new Scanner(System.in);
		System.out.println("Welcome. This program calculates BMI."
                                                        + "\nStep 1: Enter name, weight & height for every person first."
                                                        + "\nStep 2: The program then calculates all BMI."
                                                        + "\nStep 3: It then calculates number of underweight individuals."
                                                        + "\nStep 4: Normal weight individuals are calculated."
                                                        + "\nStep 5: Overweight individuals are calculated."
                                                        + "\nStep 6: Finally, obese individuals are calculated.");

// Review initialize Arrays in page 494 on how to HARDWIRED some small amount of test data to program
/** This section allows user enter name, weight, height for up to max number of people & calculate BMI
	for each person and store all values into parallel arrays of name, weight, height, BMI */ 
		int i = 0; 
                                            int max = 100; //array limit
                                            String more = ""; 
                                            
		while ( i < max ) 
		{   System.out.println("\nEnter name:");
                                                name[i] = k.next(); //use next() instead of nextLine()

                                                System.out.println("Enter weight in pounds:");
                                                weight[i] = k.nextDouble(); //originally double, now int

                                                System.out.println("Enter height in inches:");
                                                height[i] = k.nextDouble(); //originally double, now int

                                                BMI[i] = (weight [i] * 703) / (height [i] * height [i]);

                                                System.out.println("Want to calculate another BMI? Y/N.");
                                                more = k.next();
                                                    if (more.equalsIgnoreCase("Y"))
                                                    {
                                                        System.out.println("Please enter information for the next person.");
                                                        i++;
                                                    } else {
                                                        System.out.println("Done. Calculating...\n");
                                                        break;
                                                    }
                                            }

/** This section of the program analyze each person’s BMI range for normal weight, over weight, & obese
	the result is tallied to three counters for the range
           final double BMIUnder = 18.5;
            final double BMINormal = 25.0;
            final double BMIOver = 30.0;
            final double BMIObese = 30.0;*/ 
        int peopleAmt = i;
		i = 0; // Count # of normal weight, over weight, and obese -- reset i from above to 0
	while ( i <= peopleAmt )
                      {
                            if (BMI [i] <= BMINormal && BMI[i] > BMIUnder)
                            {
                                  normalWeight++;
                            } else if (BMI [i] <= BMIOver && BMI[i] > BMINormal) {  
                                  overWeight++;
                            } else if (BMI [ i ] <= BMIUnder) {  
                                  underWeight++;
                            } else {
                                 obese++;
                            }
                            i++;
                      }

// continued on next page
// continued from previous page
	System.out.println("BMI Calculation and Analysis Report"); // Output result

	i = 0; // Initialized array index for BMI values
	while ( i <= peopleAmt )
	{
                            System.out.printf ("%nNAME: " + name [ i ]  + "\tWEIGHT: " + weight [ i ] + "\tHEIGHT: " + height [ i ] + "\tBMI: "   ); 
                            System.out.printf("%.2f", BMI[i]); //neater.
                            i++;
	}

// Output BMI counters
	System.out.println ( "\nNormal Weight Individuals: " + normalWeight 
			+ "\tOverweight Individuals: " + overWeight 
			+ "\tObese Individuals: " + obese
            + "\tUnderweight Individuals: " + underWeight
			+ "\nEnd of BMI Statistical Job"
			+ "\nThank you for using my program. Next version will include a retrieval service.");

// End of program

    }
}