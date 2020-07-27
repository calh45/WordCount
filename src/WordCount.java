import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * API to read contents of a plain text file and display total number of words,
 * average word length, most frequently occurring word length and a list of the
 * number of words of each length
 * @author Calvin Hothi
 * @version 1.0
 */
public class WordCount {
    private static final int LONGEST_WORD = 51; //Length of longest word in language

    private int wordCount; //Number of words in file
    private int maxFrequency; //Most frequent word length
    private ArrayList<Integer> mostFrequentLengths; //List of word lengths with highest frequency
    private Integer[] wordLengthTally; //Array holding frequency tally of word length corresponding to values index

    public WordCount(String fileName) {
        //Initialise variables
        this.wordCount = 0;
        this.maxFrequency = 0;
        this.mostFrequentLengths = new ArrayList<Integer>();
        this.wordLengthTally = new Integer[LONGEST_WORD];
        Arrays.fill(wordLengthTally, 0);

        //Execute programme
        openFile(fileName);
    }

    /**
     * Opens File that needs to be read
     * @return inFile. FileReader initialised from opened file
     */
    public void openFile(String fileName) {
        //Attempt to open File
        FileReader inFile = null;
        try {
            //Create FileReader from filename
            inFile = new FileReader(fileName);
            readFile(inFile);
        } catch (IOException e){
            //Notify user that file does not exist and retry
            System.out.println("File not found");
        }
    }

    /**
     * Function to read through file and tally total word count and lengths of each word.
     * @param inFile File being read.
     * @throws IOException If fileReader fails
     */
    public void readFile(FileReader inFile) throws IOException {
        BufferedReader fileReader = new BufferedReader(inFile);

        //Loop over each line in file
        String line = null;
        while ((line = fileReader.readLine()) != null) {
            //Convert line String to String array containing each word
            String[] lineArray = line.split(" ");

            //Loop through each word in line, finding true length of word (removing any punctuation at end of word)
            for (String currentWord : lineArray) {
                if (!currentWord.equals("")) {
                    //Increment word count with number of words from new line
                    wordCount += 1;

                    //Retrieve length of word
                    int wordLength = calculateWordLength(currentWord);

                    //Increment counter for relevant word length
                    wordLengthTally[wordLength] += 1;
                }
            }
        }
        //Print word count
        System.out.println(wordCountString());

        //Print word lengths and frequencies
        System.out.println(generateFrequenciesString());
    }

    /**
     * Function to generate output String showing Average Word Length,
     * Frequencies of each word length and most frequently occurring word lengths.
     * @return String containing generated output.
     */
    public String generateFrequenciesString() {
        //Find the frequency of the most frequent word length
        maxFrequency = Collections.max(Arrays.asList(wordLengthTally));

        String toPrint = ""; //String displaying frequencies and most frequent lengths

        //Loop through each word length
        for (int currentCount=0; currentCount<=(wordLengthTally.length-1); currentCount++) {
            //If word has a frequency of more than 0, add to frequencies String
            if (wordLengthTally[currentCount] > 0) {
                //Generate String to display word length and its frequency
                toPrint += wordLengthFrequencyString(currentCount, wordLengthTally[currentCount]);

                //If frequency = highestFrequency, add length to most frequent lengths String
                if (wordLengthTally[currentCount] == maxFrequency) {
                    mostFrequentLengths.add(currentCount);
                }
            }
        }
        //Generate String displaying most frequent word lengths and add to output String
        toPrint += mostFrequentLengthsString();

        //Print average word length to screen
        System.out.println(averageWordLengthString());

        return toPrint;
    }

    /**
     * Function to calculate length of a given word (Removes last character if it
     * is punctuation)
     * @param word Word to find length of.
     * @return Length of word.
     */
    public int calculateWordLength(String word) {
        //Convert word to character array
        char[] currentWordChar = word.toCharArray();

        //Get length of word
        int wordLength = currentWordChar.length;

        //Check if last character of word is punctuation if word length is > 1
        if (currentWordChar.length > 1) {
            //Retrieve final character of word
            char lastChar = currentWordChar[currentWordChar.length - 1];

            //Remove final character if it is not a character or digit
            if (!(Character.isDigit(lastChar) || Character.isLetter(lastChar))) {
                wordLength -= 1;
            }
        }
        return wordLength;
    }

    /**
     * Generate String displaying the amount of words in file.
     * @return String displaying word count
     */
    public String wordCountString() {
        return "Word count = " + wordCount;
    }

    /**
     * Generate String displaying average word length of file
     * @return String displaying average word length of file
     */
    public String averageWordLengthString() {
        //Calculate total number of letters in file
        int total = 0;
        for (int i = 0; i < LONGEST_WORD; i++) {
            total += wordLengthTally[i]*i;
        }

        return "Average word length = " + String.format("%.3f",
                (float)total/(float)wordCount);
    }

    /**
     * Generate String displaying the most frequently occurring word lengths
     * @return String displaying most frequent word lengths
     */
    public String mostFrequentLengthsString() {
        //Initialise String to return
        String toReturn =  "The most frequently occurring word length is " +
                maxFrequency + ",";

        //Loop over most frequent lengths
        if (mostFrequentLengths.size() > 0) {
            //Add first length
            toReturn += " for word lengths of " + mostFrequentLengths.get(0);

            //If there are more than one highest frequency lengths, add the rest
            for(int arrayListCount = (mostFrequentLengths.size()-1); arrayListCount > 0; arrayListCount--) {
                toReturn += " & " + mostFrequentLengths.get(arrayListCount);
            }
        }
        return toReturn;
    }

    /**
     * Generate String displaying a word length and its frequency
     * @param wordLength Word Length
     * @param frequency Frequency of words with associated wordLength
     * @return String displaying word length and frequency
     */
    public static String wordLengthFrequencyString(int wordLength, int frequency) {
        return "Number of words of length " + wordLength +
                " is " + frequency + "\n";
    }

    /**
     * Function to return frequency of a word length from array (FOR UNIT TESTING PURPOSES)
     * @param length Word Length to get frequency of.
     * @return Frequency of word length.
     */
    public Integer getFrequency(int length) {
        return wordLengthTally[length];
    }
}
