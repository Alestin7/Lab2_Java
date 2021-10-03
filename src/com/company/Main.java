package com.company;

import java.util.Random;

public class Main {

    public static Random r = new Random();

    public static void main(String[] args) {
        int n = r.nextInt(5)+1;
        Rectangles rectangles = new Rectangles();
        rectangles.fillRandom(n);
        System.out.println(rectangles);

        
    }
}
