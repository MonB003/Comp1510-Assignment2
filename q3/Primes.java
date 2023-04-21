package q3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * <p>The Primes class has a constructor for a Primes object, which takes in a
 * parameter 'N' that represents the maximum size of the boolean ArrayList that
 * the object has. The constructor calls the method calculatePrimes() with 'N' 
 * as the parameter.</p>
 * 
 * <p>The calculatePrimes() method uses a for loop to go through each number in
 * between 0 and 'N', and checks if the number is prime by calling the method
 * isPrime(). The isPrime() method takes a number as a parameter and checks if
 * it's prime based on the Sieve of Eratosthenes. If the number is 0 or 1, the 
 * number is not prime. If the number is greater than 1, a for loop is used to
 * divide that number by each number between 2 and the number. If any of the
 * remainders equal 0, the number is not prime. Otherwise, it is. A boolean
 * variable stores true if the number is prime and false if it's not. This 
 * variable is returned when the method is finished. The calculatePrimes()
 * method stores each boolean value from the isPrimes() method in the boolean
 * ArrayList. This ArrayList is returned when the method is finished.</p>
 * 
 * <p>The printPrimes() method goes through the boolean ArrayList and checks if
 * each index is true or not. If the number at the index is true, that number
 * is printed to the console. If the number at the index is false, that number
 * is not printed. When the method is finished, all the primes numbers (that
 * had true in the index) are printed.</p>
 * 
 * <p>The countPrimes() method goes through the boolean ArrayList and checks if
 * each index is true or not using a for loop. If the index is true, an integer
 * called numOfPrimes, which stores the total number of primes, is incremented.
 * This integer is returned when the method is finished.</p>
 * 
 * <p>The Primes program main method prompts a user for a number, and uses a
 * while loop to make sure the input is valid. If it's not, it will print a 
 * message telling the user to input another number. The method checkInput() is
 * called in the while loop to make sure the next input is a number. Once a 
 * valid number is inputed, it is stored in a Primes object. This object tests
 * the methods printPrimes() and countPrimes(). The results are printed to the
 * console.</p>
 *
 * @author Monica
 * @version 1.0
 */
public class Primes {
    
    /** Boolean List stores boolean values of each prime (true) and non prime
     * (false) number between 0 and n. */
    private ArrayList<Boolean> booleanPrimes = new ArrayList<Boolean>();
    
    /**
     * Constructor sets primes ArrayList to have a maximum index of n.
     * 
     * @param n integer upper bound
     */
    public Primes(int n) {
        // Call calculate primes method using 'n' as the upper bound
        calculatePrimes(n);
    }
    
    
    /**
     * Returns true if number is prime or false if it's not.
     * 
     * @param number integer number being checked
     * @return numIsPrime boolean
     */
    public boolean isPrime(int number) {
        // Variable stores true or false depending on if parameter number is 
        // prime
        boolean numIsPrime = true;
        
        // If statement checks if number is 0 or 1
        if (number <= 1) {
            // If number is 0 or 1, it's not prime
            numIsPrime = false;
        } else {
            // Checks for prime number by dividing by each divisor that's less
            // than that number
            for (int i = 2; i <= Math.sqrt(number); i++) {
                // If the remainder of the parameter number divided by another 
                // number is zero, it's not prime
                if (number % i == 0) {
                    numIsPrime = false;
                }
            }
        }
        
        // Return true if number is prime, or false if it's not
        return numIsPrime;
    }
    
    
    /**
     * Returns a list of boolean values based on if each number between zero
     * and n is prime (true) or not prime (false). 
     * 
     * @param n integer maximum index
     * @return booleanPrimes ArrayList of boolean values
     */
    private ArrayList<Boolean> calculatePrimes(int n) {
        // For loop checks if each number is prime, and stores a boolean value
        // depending on if it's prime or not
        for (int currentNum = 0; currentNum <= n; currentNum++) {
            // If current number is prime
            if (isPrime(currentNum)) {
                // If prime, add true to the ArrayList
                booleanPrimes.add(true);
            } else {
                // If not prime, add false to the ArrayList
                booleanPrimes.add(false);
            }
        }
        
        // Return boolean primes ArrayList
        return booleanPrimes;
    }


    /**
     * Prints the list of prime numbers calculated.
     */
    public void printPrimes() {
        // For loop checks each boolean index to see if it's true or false
        for (int index = 0; index < booleanPrimes.size(); index++) {
            
            // If current index is true, the number at that index is prime
            if (booleanPrimes.get(index)) {
                // Print the index number
                System.out.print(index + " ");
            }
        }
    }
    
    
    /**
     * Returns an integer representing the number of primes in the range [0, N].
     * 
     * @return numOfPrimes integer
     */
    public int countPrimes() {
        // Variables stores total number of primes in primes ArrayList
        int numOfPrimes = 0;
        
        // For loop checks if each item in boolean ArrayList is true or false
        for (int index = 0; index < booleanPrimes.size(); index++) {
            // If current index is true, that number is prime
            // Increment the number of primes
            if (booleanPrimes.get(index)) {
                numOfPrimes++;
            }
        }
        
        // Return total number of primes
        return numOfPrimes;
    }
    
    
    /**
     * Checks if user input is a number and returns the next valid number.
     * 
     * @param scan scanner
     * @return validInput integer
     */
    public static int checkInput(Scanner scan) {
        // Check that the upper bound is a number
        while (!scan.hasNextInt()) {
            // If input isn't an integer, prompt user to enter a number
            System.out.println("Upper bound must be a number. Enter" 
                    + " another number: ");
            
            // Get next input
            scan.next();
        }
        
        // Variable stores the next valid input
        int validInput = scan.nextInt();
        
        // Return validInput
        return validInput;
    }

    
    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        // Variable stores user's maximum index
        int userMaxIndex;

        // Create Scanner object
        Scanner scan = new Scanner(System.in);

        // Tell user what the program does
        System.out.println("This program uses the sieve of Eratosthenes to" 
            + " determine" + "\n" + "which numbers are prime.");

        // Prompt user to enter an upper bound max number
        System.out.println("Enter an upper bound: ");

        // Store user's upper bound number and calls the checkInput() method
        // to make sure input is valid
        userMaxIndex = checkInput(scan);
        
        // Check that the upper bound is a number greater than one
        while (userMaxIndex <= 1) {
            System.out.println("Upper bound must be greater than one. Enter" 
                    + " another number: ");
            
            // Get next input
            userMaxIndex = checkInput(scan);
        }
        
        // Create Primes object with user's upper bound as the parameter
        Primes userPrimes = new Primes(userMaxIndex);
        
        // Count the number of primes
        int numOfPrimes = userPrimes.countPrimes();

        // Print the number of primes
        System.out.println("There are " + numOfPrimes + " primes: ");

        // Print the list of prime numbers
        System.out.println("The prime numbers between 0 and " + userMaxIndex 
                + " are: ");

        // Print the list of primes
        userPrimes.printPrimes();
        
        // Close scanner
        scan.close();
    }

}
