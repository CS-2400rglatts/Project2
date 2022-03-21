package com.example;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

/**
 * Unit test for Calculator class
 * @author Rebecca Glatts
 */
public class CalculatorTest 
{
    /**
     * Tests whether addition is converted correctly in convertToPostfix
     */
    @Test
    public void testAdditionConvert() {
        String result = "";
        result = Calculator.convertToPostFix("a+b");
        assertEquals(result, "ab+");
    }

    /**
     * Tests whether subtraction is converted correctly in convertToPostfix
     */
    @Test
    public void testSubtractionConvert() {
        String result = "";
        result = Calculator.convertToPostFix("b-a");
        assertEquals(result, "ba-");
    }


    /**
     * Tests whether multiplcation is converted correctly in convertToPostfix
     */
    @Test
    public void testMultiplcationConvert() {
        String result = "";
        result = Calculator.convertToPostFix("a*b");
        assertEquals(result, "ab*");
    }


    /**
     * Tests whether division is converted correctly in convertToPostfix
     */
    @Test
    public void testDivisionConvert() {
        String result = "";
        result = Calculator.convertToPostFix("e/a");
        assertEquals(result, "ea/");
    }

    /**
     * Tests whether exponents are converted correctly in convertToPostfix
     */
    @Test
    public void testExponentsConvert() {
        String result = "";
        result = Calculator.convertToPostFix("a^b");
        assertEquals(result, "ab^");
    }


    /**
     * Tests whether addition is evaluated correctly in evaluatePostfix
     */
    @Test
    public void testAdditionEvaluate() {
        int result = 0;
        result = Calculator.evaluatePostfix("ab+");
        assertEquals(result, 5);
    }

    /**
     * Tests whether subtraction is evaluated correctly in evaluatePostfix
     */
    @Test
    public void testSubtractionEvaluate() {
        int result = 0;
        result = Calculator.evaluatePostfix("ba-");
        assertEquals(result, 1);
    }

    /**
     * Tests whether multiplcation is evaluated correctly in evaluatePostfix
     */
    @Test
    public void testMultiplicationEvaluate() {
        int result = 0;
        result = Calculator.evaluatePostfix("ab*");
        assertEquals(result, 6);
    }

    /**
     * Tests whether division is evaluated correctly in evaluatePostfix
     */
    @Test
    public void testDivisionEvaluate() {
        int result = 0;
        result = Calculator.evaluatePostfix("ea/");
        assertEquals(result, 3);
    }


   


}
