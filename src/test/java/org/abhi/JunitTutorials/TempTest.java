package org.abhi.JunitTutorials;

import org.junit.jupiter.api.*;


public class TempTest {

    @BeforeEach
    public void Check(){
        System.out.println("Before");
    }

    @AfterEach
    public void after(){
        System.out.println("After EAch");
    }

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Before All");
    }

    @AfterAll
    public static void AfterAll(){
        System.out.println("After ALl");
    }
    @Test
    public void work(){
        System.out.println("Working...");
    }

    @Test
    public void play(){
        System.out.println("Playing..");
    }


}
