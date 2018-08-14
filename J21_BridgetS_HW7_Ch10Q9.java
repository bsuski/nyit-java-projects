/*	NYIT Spring_ 2018, CSCI_185_504, W01, Chapter 10 Homework Question 9
	By Bridget Suski with help from the Chapter 10 PowerPoint.
	Program title: Haberman's breast cancer survival rate
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class J21_BridgetS_HW7_Ch10Q9 {

    public static void main(String[] args) {
        int s = 0; int d = 0; //survivors + passed away
        int nS = 0; int nD = 0; //nodes of those that lived + passed away

        System.out.println("This program returns a summary of  Haberman's breast cancer survival rate. It is as follows:");
        
        String iFN = "J21_BridgetS_HW7_Ch10Q9_haberman.data.txt";
        //PROGRAM MAY BREAK if the directory changes. 
        
        try {
            // InputStream iS = 
            //    J21_BridgetS_HW7_Ch10Q9.class.getClassLoader().getResourceAsStream(iFN); -- old attempt
            //Scanner k = new Scanner(iS);

            Scanner iS = new Scanner(new File(iFN)); //new attempt inspired from powerpoint

            while (iS.hasNextLine()) {

                String line = iS.nextLine();
                String[] oV = line.split(","); //original values

               int nodes = Integer.parseInt(oV[2]); //only want the relevant information, ignore year and age
               int status = Integer.parseInt(oV[3]); 

                if (status == 1) { //survived = 1 otherwise passed away
                    nS += nodes;
                    s++;
                } else {
                    nD += nodes;
                    d++;
                }
            }
            iS.close(); //end stream

            double aS = (double) nS / s; //averages must be calculated ; convert to double to avoid division error
            double aD = (double) nD / d;
            
            System.out.printf("Average amount of positive nodes for patients living 5+ years is %1.2f\n", aS); //format text
            System.out.printf("On the other side, the average amount of positive nodes for patients dying within 5 years is %1.2f\n", aD);
			System.out.println("Thank you for using this program.");
            
        } catch (FileNotFoundException e) { //catch exception if cant find file
            System.out.println("Cannot find this file: " + iFN + ". Please check its path. Program may require the direct path.");
        } catch (IOException e) { //incase data is bad
            System.out.println("An error occured when trying to read this file: " + iFN + ". Is this the right file?");
        }
    }
}