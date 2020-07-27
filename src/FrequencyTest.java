import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FrequencyTest {

	 private WordCount frequency = new WordCount("testFiles/frequencyTest1.txt");
	 private WordCount frequencyTwo = new WordCount("testFiles/frequencyTest2.txt");

	    @Test
	    void oneTest() {
	        for(int i = 0; i < 51; i++) {
	            if (i == 1) {
	                assertEquals(4, (int)frequency.getFrequency(i));
	            } else if (i == 2) {
	                assertEquals(2, (int)frequency.getFrequency(i));
	            } else if (i == 4) {
	                assertEquals(5, (int)frequency.getFrequency(i));
	            } else if (i == 7) {
	                assertEquals(1, (int)frequency.getFrequency(i));
	            } else {
	                assertEquals(0, (int)frequency.getFrequency(i));
	            }
	        }

	    }

	    @Test
	    void twoTest() {
	        for(int i = 0; i < 51; i++) {
	            if (i == 1) {
	                assertEquals(1, (int)frequencyTwo.getFrequency(i));
	            } else if (i == 2) {
	                assertEquals(1, (int)frequencyTwo.getFrequency(i));
	            } else if (i == 4) {
	                assertEquals(3, (int)frequencyTwo.getFrequency(i));
	            } else if (i == 5) {
	                assertEquals(1, (int)frequencyTwo.getFrequency(i));
	            } else if (i == 7) {
	                assertEquals(1, (int)frequencyTwo.getFrequency(i));
	            } else if (i == 11) {
	                assertEquals(1, (int)frequencyTwo.getFrequency(i));
	            } else {
	                assertEquals(0, (int)frequencyTwo.getFrequency(i));
	            }
	        }
	    }

}
