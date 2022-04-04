package main.java;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class MoodTest {

    @org.junit.jupiter.api.Test
    void getMood() throws Exception {
        String[] example0 = {"фвыпыва" + "is" + 15};
        String mood = Mood.getMood(example0);
        Assertions.assertEquals("blank", mood);
    }
}