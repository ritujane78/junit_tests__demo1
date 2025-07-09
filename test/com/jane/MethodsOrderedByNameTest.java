package com.jane;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class MethodsOrderedByNameTest {
    @Test
    void testB(){
        System.out.println("Running test B");
    }

    @Test
    void testA(){
        System.out.println("Running test A");
    }


    @Test
    void testC(){
        System.out.println("Running test C");
    }

    @Test
    void testE(){
        System.out.println("Running test E");
    }

    @Test
    void testD(){
        System.out.println("Running test D");
    }

}
