package edu.sjsu.assignment2;
import java.io.*;

public class MyFile {
    /**
     * Read multiple lines from a file, each line containing words separated by commas
     * Take the words that are prime integers and print them to a second file
     * @param file1: the name of the first file
     * @param file2: the name of the second file
     */
    public static void writePrimes(String file1, String file2){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file1))) {
            FileWriter fileWriter = new FileWriter(file2); //The FileWriter creates a new file named file2 (if it does
            // not already exist) and allows us to write to that file
            String fileLine;
            while ((fileLine = bufferedReader.readLine()) != null) { //We read from the file until we reach the end
                String[] words = fileLine.split(","); //We split each line in words (separated by commas)
                for (String word: words) { //We take each word separately
                    int number;
                    try{
                        number = Integer.parseInt(word); //If the word can be passed to int
                        if(isPrime(number)){ //And the int is prime
                            try {
                                fileWriter.write(number + "\n"); //We write it in the file
                            } catch (IOException ignored) {}
                        }
                    }
                    catch (NumberFormatException ignored){}
                }
            }
            fileWriter.close();  //Close the FileWriter when we are done
        }
        catch (IOException ignored) {}
    }

    /**
     * Check if a number is prime
     * @param number: The number that we have to check
     * @return true if the number is prime, false otherwise
     */
    public static boolean isPrime(int number){ //Method that checks if a number is prime
        if(number<=1) return false;
        if(number<=3) return true;
        if(number%2==0) return false;
        if(number<=7) return true;
        for(int i = 3; i*i<=number; i+=2) // We try to divide with every number lower or equal to the square root
            if(number%i==0) return false; // That is because divisors come in pairs (one smaller and one bigger than
        return true;                      // the square root
    }                                     // We skip even numbers because we have already tried dividing by two
}
