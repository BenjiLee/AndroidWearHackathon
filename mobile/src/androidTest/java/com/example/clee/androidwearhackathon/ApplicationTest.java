package com.example.clee.androidwearhackathon;

import java.io.IOException;

import junit.framework.TestCase;


public class ApplicationTest extends TestCase {

    private GetMbtaData thingy = new GetMbtaData();

    public void testGetPrice() throws IOException {
        System.out.println("string other than Tests failed");
        System.out.println("test net:" + thingy.getData());

    }
}