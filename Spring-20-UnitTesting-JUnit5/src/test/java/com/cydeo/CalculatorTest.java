package com.cydeo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.AccessDeniedException;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeEach
    void setUpEach(){
        System.out.println("Before each executed");
    }

    @BeforeEach
    void tearDownEach(){
        System.out.println("After each executed");
    }

    @Test
    void testCase1(){
       fail("Not Implemented yet");
    }

    @Test
    void testCase2(){
      assertTrue(Calculator.operator.equals("add"), "Operator is not matching: "+ Calculator.operator);
      //assertEquals("add",Calculator.operator, "Operator is not matching: "+Calculator.operator);
    }

    @Test
    void testCase3(){
      assertArrayEquals(new int[]{1,2,3}, new int[]{1,2,3});
        assertArrayEquals(new int[]{1,2,3}, new int[]{1,3,2});
    }

    @Test
    void testCase4(){

        String nullString = null;
        String notNullString = "Cydeo";
        assertNull(notNullString);
        //assertNotNull(notNullString);
    }

    @Test
    void testCase5(){

        Calculator c1 = new Calculator();
        Calculator c2 = c1; //they both referencing to same object
        assertSame(c1,c2);
        Calculator c3= new Calculator();

        assertNotSame(c1,c3);
    }

    @Test
    void add(){
        int actual = Calculator.add(2,3);
        assertEquals(5,actual,"Actual response is not matching: "+actual);

    }

    @Test
    void add2(){
       assertThrows(AccessDeniedException.class, ()-> Calculator.add2(5,2));

    }

}