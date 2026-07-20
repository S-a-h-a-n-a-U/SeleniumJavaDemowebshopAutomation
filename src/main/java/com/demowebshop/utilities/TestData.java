package com.demowebshop.utilities;

public class TestData {

    public static String email;
    public static final String password = "Test@123";

    static {
        email = getRandomEmail();
    }

    public static String getRandomEmail() {
        email = "user" + System.currentTimeMillis() + "@gmail.com";
        return email;
    }
}