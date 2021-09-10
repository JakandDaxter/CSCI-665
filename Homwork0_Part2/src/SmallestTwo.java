/**
 * @file SmallestTwo.java
 * @brief The first line will contain a single positive integer, n, not larger than 10,000.
 * Then, n more lines of input will follow, each containing a single integer (a1...an).
 * You may assume that there are at least two different integers among a1...an. Output:
 * The first line should output the smallest value among the a values.
 * The second line should output the second smallest value
 * (that is,the smallest value that is larger than the first value).
 * @Class CSCI-665  Section 1
 * @Professor Ting Cao
 * @Date 08/29/2021
 * @author Aliana Tejeda
 * Contact: axt3290@rit.edu
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SmallestTwo {

    public static ArrayList<Integer> findSmallestTwo(ArrayList<Integer> x) {

        // array to hold the two smallest integers
        ArrayList<Integer> row = new ArrayList<>();

        //sort the list that user typed in
        Collections.sort(x);

        //add the first int after sort
        row.add(x.get(0));

        //find the next lowest integer
        for (int i = 1; true; i++) {
            if (!row.get(0).equals(x.get(i + 1))) {
                row.add(x.get(i));
                break;
            }
        }

        //return the smallest two integers
        return row;
    }


    public static void main(String[] args) {

        //Variables
        String input = "";
        ArrayList<Integer> takeIn = new ArrayList<>();

        //get user input variable
        Scanner scan = new Scanner(System.in);

        System.out.println("Only Single Positive Integers");
        System.out.println("Type in 'n' to quit");

        try {
            //while the user has not stated they want to quit
            //keep taking in input
            while (!input.equals("n")) {
                input = scan.next();

                if (!input.equals("n")) {
                    takeIn.add(Integer.parseInt(input));
                }
            }

            //if the user has not typed in any data and quit
            //end program
            if (takeIn.isEmpty()) {
                System.out.println("List is Empty");
                System.out.println("Program is Exiting");
                System.exit(0);
            }
            ArrayList<Integer> y = findSmallestTwo(takeIn);
            System.out.println(y.get(0));
            System.out.println(y.get(1));
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
}
