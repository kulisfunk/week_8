package com.example.goober.wordcounter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by goober on 06/11/2017.
 */

public class WordCountTest {
    WordCount prose;
    String text;

    @Before
    public void before(){
        String text = "hello there my name is martin what is yours";


    }

    @Test
    public void stringIsSetup(){
        String text = "hello there my name is martin what is yours";
        WordCount prose = new WordCount(text);
        assertEquals("hello there my name is martin what is yours", prose.hasGotString());
    }

    @Test
    public void canCountWords(){
        WordCount prose = new WordCount("hello there my name is martin what is yours");
        assertEquals(9, prose.countWords());
    }

//    @Test
//    public void checkCanMapWords(){
//        WordCount prose = new WordCount("hello hello how do you do you");
//        assertEquals(2, prose.mapIndividualWords());
//    }

    @Test
    public void canBuildFinalString(){
        WordCount wordTest = new WordCount("hello hello how do you do you know who");
        assertEquals("20", wordTest.finalAnswer(wordTest.mapIndividualWords()));
    }
}
