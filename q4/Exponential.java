package q4;

/**
 * <p>The exponential program has an exp() method, which calculates the
 * exponential sum of a number. The exp() method takes in a number as the
 * parameter, which is the number whose exponential is being calculated. An 
 * integer called limit stores the number of times the exponential sum will be
 * added. A for loop is used to go through and add each sum. Two variables
 * called previousTerm and nextTerm are initialized and used to store the
 * current terms being added in the sum. The previousTerm is calculated by
 * multiplying itself by the parameter number divided by 'k' + 1. 'K' represents
 * a number that increments by 1 each time the for loop is run. The nextTerm
 * and previousTerm are added together in each loop. Once the loop has reached
 * the limit of times to loop, that sum is stored in a variable called
 * exponential, which is returned when the method is finished.</p>
 * 
 * <p>The main method of the exponential program calculates the exponentials of
 * the numbers -10 to 10. A for loop is used to get each number between -10 and
 * 10, and calls the exp() method to calculate that number's exponential. The
 * results are printed to the console.</p>
 *
 * @author Monica
 * @version 1.0
 */
public class Exponential {
    
    /**
     * Calculates and returns the exponential of a number.
     * 
     * @param num double
     * @return exponential double
     */
    public static double exp(double num) {
        // Variable sets the limit for the number of times the sum is added
        final int limit = 100;
        
        // Variables store initial values of the previous term and next term
        double previousTerm = 1;
        double nextTerm = 1;
        
        // For loop adds the sum until "k" equals the limit
        for (int k = 0; k < limit; k++) {
            // Calculates the sum
            previousTerm *= (num / (k + 1));
            nextTerm += previousTerm;
        }
        
        // Variable stores the result of the sum (exponential)
        double exponential = nextTerm;
        
        // Return the exponential
        return exponential;
    }
    
        
    /**
     * Drives the program. Calculates the exponential of the numbers between
     * -10 and 10 (inclusive).
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Variable for number, which we will find the exponential of
        final double number = -10.0;
        
        // Last number we will find the exponential of
        final double ten = 10.0;
        
        // Variable stores next exponential result
        double nextExp;
        
        // For loop goes through each number between -10 and 10 and calculates
        // that number's exponential
        for (double x = number; x <= ten; x++) {
            // Call method to calculate exponential
            nextExp = exp(x);
            
            // Print the exponential
            System.out.println("x = " + x + "\t" + "e^x = " + nextExp);
        }
    }
}

