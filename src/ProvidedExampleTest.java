import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProvidedExampleTest {

	 private WordCount wordCount = new WordCount("testFiles/testFile.txt");

	    @Test
	    void wordCountTest() {
	        assertEquals("Word count = 9", wordCount.wordCountString());
	    }

	    @Test
	    void averageLengthTest() {
	        assertEquals("Average word length = 4.556", wordCount.averageWordLengthString());
	    }

	    @Test
	    void mostFrequentTest() {
	        assertEquals("The most frequently occurring word length is 2, for word lengths of 4 & 5", wordCount.mostFrequentLengthsString());
	    }

}
