package edu.sjsu.assignment2;
import edu.sjsu.assignment2.TimeDifference;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TimeDifferenceTest {
    @Test
    void timeFrom2203To2205is2(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        TimeDifference.printTimeDifference(2203, 2205);
        assertEquals("0 hour(s) 2 minute(s)", outContent.toString());
    }

    @Test
    void timeFrom0900To2359is899(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        TimeDifference.printTimeDifference(900, 2359);
        assertEquals("14 hour(s) 59 minute(s)", outContent.toString());
    }

    @Test
    void timeFrom2300To505is365(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        TimeDifference.printTimeDifference(2300, 505);
        assertEquals("6 hour(s) 5 minute(s)", outContent.toString());
    }

    @Test
    void timeFrom0000To0000is0(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        TimeDifference.printTimeDifference(0, 0);
        assertEquals("0 hour(s) 0 minute(s)", outContent.toString());
    }
}