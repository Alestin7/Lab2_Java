package com.company;

import java.util.Random;

public class Parallelepiped extends Rectangle {
    private int c;

    public Parallelepiped(int a, int b, int c) {
        super(a, b);
        this.c = c;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public static Parallelepiped generate(){
        Random r = new Random();
        return new Parallelepiped(r.nextInt(2)+1, r.nextInt(2)+1, r.nextInt(2)+1);
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


