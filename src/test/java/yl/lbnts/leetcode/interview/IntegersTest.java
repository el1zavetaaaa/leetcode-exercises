package yl.lbnts.leetcode.interview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntegersTest {
    @Test
    public void compareIntegerObjToInt(){
        Integer num1 = 120;
        int num2 = 120;

        assertTrue( num1 == num2);
    }

    @Test
    public void compareIntegersOutOfIntegerPool(){
        Integer num1 = 400;
        Integer num2 = 400;

        int primitive1 = 400;
        int primitive2 = 400;

        assertFalse(num1 == num2);
        assertTrue(primitive1 == primitive2);
    }

    @Test
    public void compareIntegersInTheScopeOfIntegerPool(){
        Integer numInTheScopeOfIntegerCache1 = 127;
        Integer numInTheScopeOfIntegerCache2 = 127;

        int primitive1 = 127;
        int primitive2 = 127;

        assertTrue(numInTheScopeOfIntegerCache1 == numInTheScopeOfIntegerCache2);
        assertTrue(primitive1 == primitive2);
    }

}
