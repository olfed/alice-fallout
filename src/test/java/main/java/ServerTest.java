package main.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ServerTest {

    @Test
    void answerTest() {
        String mood = "happy";
        String[] happyAnswers = {"Я так рада, что у тебя всё здорово!", "У меня тоже всё замечательно",
                "Да и вообще мы все молодцы"};
        boolean contains = Arrays.asList(happyAnswers).contains(Server.answer(mood));
        assertTrue(contains);
    }
    @Test
    void answerTest0() {
        String mood = "sad";
        String[] sadAnswers = {"Не грусти, всё пройдёт", "Всё будет хорошо", "Всем иногда бывает грустно"};

        boolean contains = Arrays.asList(sadAnswers).contains(Server.answer(mood));
        assertTrue(contains);
    }
    @Test
    void answerTest1() {
        Date date = new Date();
        String timeAnswer = date.toString();
        String mood = "time";
        Assertions.assertEquals(Server.answer(mood),timeAnswer);
    }
    @Test
    void answerTest2() {
        String mood = "0x42ddvxc";
        String neutralAnswer = "Я не поняла о чём вы. Скажите пожалуйста, к какой категории относится ваше предложение? (sad, happy или другое)";
        Assertions.assertEquals(Server.answer(mood),neutralAnswer);
    }
}