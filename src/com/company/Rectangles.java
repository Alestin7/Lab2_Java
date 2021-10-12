package com.company;

import java.util.ArrayList;
import java.util.List;

public class Rectangles {
    private final List<Rectangle> rectangles;

    public Rectangles(){rectangles = new ArrayList<>();}

    public List<Rectangle> getRectangles() {
        return rectangles;
    }

    public void add(Rectangle rectangle){this.rectangles.add(rectangle);}

    public void remove(Rectangle rectangle){this.rectangles.remove(rectangle);}

    public void fillRandom(int n)
    {
        for (int i = 0; i < n; i++) {
            rectangles.add(Rectangle.generate());
        }
    }

    public void findMediumSquare(){
        double medsquare = 0;
        int N = 0;
        for (Rectangle rectangle : this.rectangles){
            medsquare += rectangle.getA()*rectangle.getB();
        }
        medsquare /= rectangles.size();
        System.out.println("\nСредняя площадь прямоугольников: " + medsquare);
        for (Rectangle rectangle : this.rectangles){
            if (rectangle.getA() * rectangle.getB()>medsquare){
                N++;
            }
        }
        System.out.println("\nКоличество прямоугольников, площадь которых больше, чем средняя: " + N);
    }

    @Override
    public String toString() {
        return "Прямоугольники" + rectangles + "; ";
    }
}
