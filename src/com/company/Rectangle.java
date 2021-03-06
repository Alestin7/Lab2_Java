package com.company;

import java.util.Random;

public class Rectangle {
    private int a;
    private int b;

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public static Rectangle generate(){
        Random r = new Random();
        return new Rectangle(r.nextInt(10)+1, r.nextInt(10)+1);
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "\n\nПрямоугольник{\n" +
                "a: " + a +
                "\nb: " + b +
                "\nДиагональ: " + Math.sqrt((Math.pow(a, 2)+Math.pow(b, 2))) +
                "\nПериметр: " + 2 * (a + b) +
                "\nПлощадь: " + a * b +
                "\n}";
    }
}
