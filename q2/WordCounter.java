package q2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * <p>The WordCounter program counts how many distinct words there are in the
 * text file of the King James Bible. The parseBook() method is used to count
 * the distinct words. It takes in a Scanner, which is used to scan each line in
 * the text file. Another scanner called lineScan is used to scan each word in 
 * a line. While loops are used to go through each word in the line while there
 * is still another word. Each word is stored in a Word object. The method 
 * checkWordInList() is called with the parameter of the current word in the 
 * line. The checkWordInList() method takes in a word and an ArrayList of word
 * objects. It goes through the ArrayList and compares each word with the 
 * parameter word to see if they are the same. If they are, the 
 * incrementFrequency() method from the Word class is used to increment the 
 * word's frequency by one. It then returns true if the word was found in the 
 * ArrayList, or false if it wasn't found. If the method returns false, the 
 * word is added to the ArrayList in the parseBook() method. Once all the words
 * have been checked, the next step is to use a for loop to go through all the
 * words in the ArrayList and count them. The integer totalUniqueWords stores
 * the total number of unique words in the text file, and is returned once the
 * method is finished. This result is printed to the console.</p>
 * 
 * <p>The printTopWords() method implements the Comparable Word interface, and
 * uses the sort() method, which sorts each word from highest frequency (first)
 * to lowest frequency (last). The compareTo() method from the Word class is 
 * takes two word's frequencies and subtracts the parameter word from the "this"
 * word. The method returns an integer based on the difference. If the number is
 * negative, the "this" word comes before the word in parameters If number is 
 * positive, the parameter word comes before "this" word. This is how the words
 * in the ArrayList are sorted. The printTopWords() method takes an integer 
 * parameter, which is the number of words that is returned. A for loop is used
 * to go through the ArrayList and get each word from index zero until the 
 * index of the parameter number. These top words are stored in another 
 * ArrayList, which is returned when the method is finished. This list is 
 * printed to the console.</p>
 * 
 * <p>In the main method, a WordCounter object is created to test the methods
 * parseBook() and printTopWords(). The results are printed to the console.
 * Please note that the parseBook() takes around five minutes before it will
 * print a result to the console because it has to scan a long text file. 
 * However, all the methods in this class work.</p>
 *
 * @author Monica
 * @version 1.0
 */
public class WordCounter {
    /** List of Words. */
    private ArrayList<Word> listOfWord = new ArrayList<Word>();

    
    /**
     * Returns true if a word is already stored in a word ArrayList.
     * 
     * @param word Word
     * @param currWordList ArrayList of words
     * @return containsWords boolean
     */
    public boolean checkWordInList(Word word, ArrayList<Word> currWordList) {
        // Variables stores true or false depending on if ArrayList contains
        // the word
        boolean containsWords = false;
        
        // For loop checks each element in the word list and compares it to
        // the parameter word
        for (int index = 0; index < currWordList.size(); index++) {
            // Get the string word of the parameter
            String parameterWord = word.getWord();
            
            // Get the string word of the next word in the ArrayList
            String anotherWord = currWordList.get(index).getWord();
            
            // If the parameter word equals a word in the list, the word is 
            // already in the word list
            if (parameterWord.equals(anotherWord)) {
                // Boolean stores true because the list contains the word
                containsWords = true;
                
                // Word object stores the word at the current index
                Word sameWord = currWordList.get(index);
                
                // Increment its frequency
                sameWord.incrementFrequency();
            }
        }
        
        // Return true or false depending on if ArrayList contains the word
        return containsWords;
    }


    /**
     * Returns the total number of unique words stored in the list.
     * 
     * @param fileName string
     * @return totalUniqueWords integer
     */
    public int parseBook(String fileName) throws FileNotFoundException {
        // Create scanner to read the file
        Scanner fileScan = new Scanner(new File(fileName));
        
        // Create scanner to read each line
        Scanner lineScan;
        
        // While loop to read and process each line of the file
        while (fileScan.hasNext()) {
            // Gets next line
            lineScan = new Scanner(fileScan.nextLine());
            
            // Each word is separated by a space
            lineScan.useDelimiter(" ");
            
            // While loop runs if there is a next line
            while (lineScan.hasNext()) {
                // Get the next word
                String currWord = lineScan.next();
                
                // Store next word in a Word object
                Word currentWord = new Word(currWord);
                
                // Check if word is not in the ArrayList
                if (!checkWordInList(currentWord, listOfWord)) {
                    // If the word is not in the word list, add it
                    listOfWord.add(currentWord);
                }
            }
        }
        // Close scanner
        fileScan.close();
        
        // Calculate the total number of unique words
        int totalUniqueWords = 0;
        
        // For loop counts how many words are in the list
        for (int i = 0; i < listOfWord.size(); i++) {
            // Count each word in the list
            totalUniqueWords++;
        }
        
        // Return the total number of unique words
        return totalUniqueWords;
    }
    
    
    /**
     * Prints the n most frequent words in order (most frequent ones first).
     * 
     * @param n integer number of words being returned
     * @return ArrayList of most frequent words
     */
    public ArrayList<Word> printTopWords(int n) {
        // Sort the ArrayList
        Collections.sort(listOfWord);
        
        // Create an ArrayList to store the top words
        ArrayList<Word> topWords = new ArrayList<Word>();

        // Get each of the most frequent words in order starting from 0 to n
        for (int i = 0; i < n; i++) {
            topWords.add(listOfWord.get(i));
        }
       
        // Return the ArrayList of top words
        return topWords;
    }
    
            
    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) throws FileNotFoundException {
        // Create a Word Counter object
        WordCounter wordCounter = new WordCounter();
        
        // Parse book method
        int parseBookResult = wordCounter.parseBook("./src/bible.txt");
        System.out.println("Total number of unique words: " + parseBookResult);
        
        // Variable for number of top words
        final int numTopWords = 10;
        
        // Stores top 10 words
        ArrayList<Word> userTopWords = new ArrayList<Word>();
        
        // Print top words
        userTopWords = wordCounter.printTopWords(numTopWords);
        System.out.println(numTopWords + " most frequent words: " 
                + userTopWords);
    }

}
