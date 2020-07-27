import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WordLengthTest {

	private WordCount wordCount = new WordCount("testFiles/testFile.txt");


    @Test
    void regularWordLengthTest() {
        assertEquals(5, wordCount.calculateWordLength("hello"));
    }

    @Test
    void punctuationLastCharacter() {
        assertEquals(5, wordCount.calculateWordLength("Hello."));
    }

    @Test
    void oneLetterPunctuation() {
        assertEquals(1, wordCount.calculateWordLength("$"));
    }

    @Test
    void punctuationMidWord() {
        assertEquals(6, wordCount.calculateWordLength("Hel&lo"));
    }


}
