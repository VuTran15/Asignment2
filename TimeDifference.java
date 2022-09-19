package edu.sjsu.assignment2;

import java.util.Scanner;

public class TimeDifference {
    /**
     * Read two times in military format and print the number of hours and minutes between the two times
     * If the first time is later than the second time, assume the second time is the next day.
     */
    public static void main(String[] args){
        int firstTime = 0, secondTime = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the first time:");
        String time = scanner.next(); //Read the first time

        if(time.length() != 4) //The time should be represented by 4 digits (2 for hours, 2 for minutes)
        {
            System.out.print("Invalid input! Program terminated!");
            System.exit(0);
        }

        try { //Check if the first time can be passed to integer
            firstTime = Integer.parseInt(time);
        }
        catch (NumberFormatException ex){
            System.out.print("Invalid input! Program terminated!");
            System.exit(0);
        }
        System.out.print("Please enter the second time:");
        time = scanner.next();

        if(time.length() != 4) //The time should be represented by 4 digits (2 for hours, 2 for minutes)
        {
            System.out.print("Invalid input! Program terminated!");
            System.exit(0);
        }

        try { //Check if the second time can be passed to integer
            secondTime = Integer.parseInt(time);
        }
        catch (NumberFormatException ex){
            System.out.print("Invalid input! Program terminated!");
            System.exit(0);
        }

        printTimeDifference(firstTime, secondTime);
    }

    public static void printTimeDifference(int firstTime, int secondTime){
        int firstMinutes = firstTime / 100 * 60 + firstTime % 100; //The number of minutes since the start of the day
        //until the first time
        int secondMinutes = secondTime / 100 * 60 + secondTime % 100; //The number of minutes since the start of the day
        //until the first time

        int resultInMinutes = (24 * 60 + secondMinutes - firstMinutes) % (24 * 60);
        //The result above handles both the case when the first time is earlier than the second and the case when
        //the first time is later (that means the second time is next day)

        //In the first case, the above computation is fairly straightforward, because "secondMinutes - firstMinutes"
        //will be a positive integer less than 24 * 60 and "resultInMinutes" will take the value of
        //"secondMinutes - firstMinutes".

        //In the second case, "secondMinutes - firstMinutes" will be a negative integer that has an absolute value
        //less than 24 * 60. "resultInMinutes" will take the value equal to the number of minutes from "first time"
        //in a day until "second time" the next day.
        //Example for the second case:
        //first input: 2200
        //second input: 0100
        //secondMinutes - firstMinutes: -1260
        //resultInMinutes: (24 * 60 - 1260) % 24 * 60 = 180

        System.out.print(resultInMinutes / 60 + " hour(s) " + resultInMinutes % 60 + " minute(s)");
    }
}
