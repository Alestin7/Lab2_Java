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

    @Override
    public String toString() {
        return "Rectangles" + rectangles + "; ";
    }
}
