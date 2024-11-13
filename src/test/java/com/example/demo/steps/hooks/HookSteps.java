package com.example.demo.steps.hooks;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class HookSteps {
    @BeforeAll()
    public static void beforeAll() {
        System.out.println("before Test");
    }

    @AfterAll()
    public static void afterAll() {
        System.out.println("After Test");
    }

}
