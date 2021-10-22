package com.company;

import java.util.Random;

public class Main {

    public static Random r = new Random();

    public static void main(String[] args) {
        int n = r.nextInt(5) + 1;
        Rectangles rectangles = new Rectangles();
        rectangles.fillRandom(n);
        System.out.println(rectangles);
        double mediumSquare = rectangles.findMediumSquare();
        System.out.println("\nСредняя площадь прямоугольников: " + mediumSquare);
        System.out.println("\nКоличество прямоугольников, площадь которых больше, чем средняя: " + rectangles.findQuantity(mediumSquare));

        Parallelepipeds parallelepipeds = new Parallelepipeds();
        parallelepipeds.fillRandom(n);
        System.out.println(parallelepipeds);
        System.out.println("\nКоличество кубов: " + parallelepipeds.getCubesQuantity());
    }
}
