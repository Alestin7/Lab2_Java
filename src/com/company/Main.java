package com.company;

import java.util.Random;

public class Main {

    public static Random r = new Random();

    public static void main(String[] args) {
        int n = r.nextInt(5) + 1;
        Rectangles rectangles = new Rectangles();
        String filename1 = "rectangles.txt";

        // Сериализация
        //System.out.println("\n" + (rectangles.deserialize(filename1) ? "Данные успешно загружены" : "Ошибка загрузки" + " из файлa " + filename1));
        // Загрузка из файла
        //System.out.println("\n" + (rectangles.load(filename1) ? "Данные успешно загружены" : "Ошибка загрузки") + " из файла " + filename1);
        /*System.out.println(rectangles);*/
        rectangles.clear();
        rectangles.fillRandom(n);
        System.out.println(rectangles);

        double mediumSquare = rectangles.findMediumSquare();
        System.out.println("\nСредняя площадь прямоугольников: " + mediumSquare);
        System.out.println("\nКоличество прямоугольников, площадь которых больше, чем средняя: " + rectangles.findQuantity(mediumSquare));

        // Десериализация
        System.out.println("\n" + (rectangles.serialize(filename1) ? "Данные успешно сохранены" : "Ошибка сохранения" + " в файл " + filename1));
        // Сохранение в файл
        //System.out.println("\n" + (rectangles.save(filename1) ? "Данные успешно сохранены" : "Ошибка сохранения") + " в файл " + filename1);

        /*Parallelepipeds parallelepipeds = new Parallelepipeds();
        parallelepipeds.fillRandom(n);
        System.out.println(parallelepipeds);
        System.out.println("\nКоличество кубов: " + parallelepipeds.getCubesQuantity());*/
    }
}
