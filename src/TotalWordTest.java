import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TotalWordTest {

	private WordCount emptyFile = new WordCount("testFiles/emptyFile.txt");
    private WordCount shortFile = new WordCount("testFiles/shortFile.txt");
    private WordCount mediumFile = new WordCount("testFiles/mediumFile.txt");
    private WordCount longFile = new WordCount("testFiles/longFile.txt");


    @Test
    void emptyFileLengthTest() {
        assertEquals("Word count = 0", emptyFile.wordCountString());
    }

    @Test
    void shortFileLengthTest() {
        assertEquals("Word count = 19", shortFile.wordCountString());
    }

    @Test
    void mediumFileLengthTest() {
        assertEquals("Word count = 150", mediumFile.wordCountString());
    }

    @Test
    void longFileLengthTest() {
        assertEquals("Word count = 750", longFile.wordCountString());
    }

}
