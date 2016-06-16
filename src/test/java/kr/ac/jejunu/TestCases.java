package kr.ac.jejunu;

import org.junit.Test;

import java.util.Random;
import static org.junit.Assert.*;

/**
 * Created by neo-202 on 2016-06-16.
 */
public class TestCases {

    @Test
    public void randomNumberTest(){
        Random random = new Random();
        assertEquals(random.nextInt(1) + 1 , 1);
        assertTrue(random.nextInt(10) < 10);
    }

    @Test
    public void randomStringTest(){
        assertTrue(MyUtil.randomStrGenerate(10).length() == 10);
        assertNotEquals(MyUtil.randomStrGenerate(20), MyUtil.randomStrGenerate(20));
    }
}
