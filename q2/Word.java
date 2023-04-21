package q2;

/**
 * Word class represents a word and its frequency.
 * 
 * @author Monica
 * @version 1.0
 *
 */
public class Word implements Comparable<Word> {
    /** Word. */
    private final String word;
    
    /** Frequency. */
    private int frequency;


    /**
     * Constructor sets the initial value of word.
     * 
     * @param word string
     */
    public Word(String word) {
        this.word = word;
        this.frequency = 1;
    }

    /**
     * Returns the value of word as a string.
     * @return the word
     */
    public String getWord() {
        return word;
    }

    /**
     * Returns the value of frequency as an integer.
     * @return the frequency
     */
    public int getFrequency() {
        return frequency;
    }


    /**
     * Increments the frequency by 1.
     * @return the frequency
     */
    public int incrementFrequency() {
        // Increment frequency by 1
        this.frequency++;
        
        // Return the incremented frequency
        return this.frequency;
    }

    /**
     * Returns a string of the word and its frequency.
     * 
     * @return toString description
     */
    public String toString() {
        return "Word: " + word + ", Frequency: " + frequency;
    }


    /**
     * Returns the word with higher frequency.
     * 
     * @param anotherWord word
     * @return higherFrequency integer
     */
    public int compareTo(Word anotherWord) {
        // Variable stores the number of the higher frequency
        int higherFrequency; 
        
        // Higher frequency is the parameter word minus the this word
        higherFrequency = anotherWord.getFrequency() - getFrequency();
        
        // Return the higher frequency
        // If number is negative, "this" word comes before the word in
        // parameters
        // If number is positive, parameter word comes before "this" word
        return higherFrequency;
    }

}
