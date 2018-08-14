/*  NYIT Spring_ 2018, CSCI_185_504, W01, Chapter 11 Homework Question 1
	By Bridget Suski with help from the Java Textbook
	Program title: Fibonacci Sequence
*/

import java.util.Scanner;

public class J21_BridgetS_HW5_Fibo {

    public static int calcFib(int i) { //To avoid an error (since i - 1 would be <0 for the first 2 cases) return 0 and 1 separately. 
        int x = 0, y = 1;
        switch (i) {
            case 1:
                return x;
            case 2:
                return y; //avoid program breaking
            default:
                return (calcFib(i - 1) + calcFib(i - 2));
        }
    }

    public static void main(String[] z) {
        Scanner k = new Scanner(System.in);

            System.out.println(
                    "This program counts the Fibonacci Sequence. How many numbers should it count?");
            System.out.print("Enter a positive integer:");
            double n = k.nextInt();

            System.out.println(
                    "Here is the Fibonacci Sequence, and its ratio for " + n + " numbers.\n");

            System.out.println("Fibonacci #1 = 0"); 

            if (n > 1) {
                System.out.println("Fibonacci #2 = 1"); //always 
            }

            for (int i = 3; i <= n; ++i) { //start at 3 since 1 & 2 already accounted for
                System.out.println("Fibonacci #" + i
                        + " = " + calcFib(i) + "; " + calcFib(i) + "/" + calcFib(i - 1) + " = "
                        + (double)calcFib(i) / calcFib(i - 1)); //needs to convert to double or else dividing will NOT work. 
            }
    }
}

