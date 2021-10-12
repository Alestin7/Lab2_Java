package com.company;

import java.util.Random;

public class Paral extends Rectangle {
    private int c;

    public Paral(int a, int b, int c) {
        super(a, b);
        this.c = c;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public static Paral generate(){
        Random r = new Random();
        return new Paral(r.nextInt(2)+1, r.nextInt(2)+1, r.nextInt(2)+1);
    }

    @Override
    public String toString() {
        return "\n\nПараллелипипед{\n" +
                "\na: " + super.getA() +
                "\nb: " + super.getB() +
                "\nc: " + c +
                "\nПлощадь: " + 2 * (super.getA()*super.getB()+super.getB()*c+super.getA()*c) +
                "\nОбъём: " + super.getA()*super.getB()*c +
                "\n}";
    }
}


