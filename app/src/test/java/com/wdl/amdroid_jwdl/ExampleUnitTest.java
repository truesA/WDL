package com.wdl.amdroid_jwdl;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    private float dealCredScore(int value,double valueb){
        value=120;
        valueb=0.3;
        float lastValue = (float) (value*valueb);
        return lastValue;
    }
}