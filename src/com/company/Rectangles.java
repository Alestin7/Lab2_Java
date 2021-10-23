package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rectangles {
    private List<Rectangle> rectangles;

    public Rectangles() {
        rectangles = new ArrayList<>();
    }

    public List<Rectangle> getRectangles() {
        return rectangles;
    }

    public void add(Rectangle rectangle) {
        this.rectangles.add(rectangle);
    }

    public void remove(Rectangle rectangle) {
        this.rectangles.remove(rectangle);
    }

    public void fillRandom(int n) {
        for (int i = 0; i < n; i++) {
            rectangles.add(Rectangle.generate());
        }
    }

    public double findMediumSquare() {
        double medsquare = 0;
        for (Rectangle rectangle : this.rectangles) {
            medsquare += rectangle.getA() * rectangle.getB();
        }
        medsquare /= rectangles.size();
        return medsquare;
    }

    public int findQuantity(double medsquare) {
        int N = 0;
        for (Rectangle rectangle : this.rectangles) {
            if (rectangle.getA() * rectangle.getB() > medsquare) {
                N++;
            }
        }
        return N;
    }

    public boolean save(String filename) {
        FileWriter outStream = null;
        try {
            outStream = new FileWriter(filename);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        BufferedWriter bw = new BufferedWriter(outStream);
        for (Rectangle rectangle : this.rectangles) {
            try {
                bw.write(String.valueOf(rectangle.getA()) + System.lineSeparator());
                bw.write(String.valueOf(rectangle.getB()) + System.lineSeparator());
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

        try {
            bw.close();
            outStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean load(String filename) {
        this.clear();
        try {
            Scanner scanner = new Scanner(new FileReader(filename));
            do {
                if (scanner.hasNextInt()) {
                    rectangles.add(new Rectangle(scanner.nextInt(), scanner.nextInt()));
                } else
                    break;
            } while (scanner.hasNextLine());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean serialize(String filename){
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(rectangles);
            out.close();
            fileOut.close();
        }
        catch (IOException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deserialize(String filename){
        rectangles.clear();
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            rectangles = (List) in.readObject();
            in.close();
            fileIn.close();
        }
        catch (IOException e){
            e.printStackTrace();
            return false;
        }
        catch (ClassNotFoundException c){
            c.printStackTrace();
            return false;
        }
        return true;
    }

    public void clear() {
        rectangles.clear();
    }

    @Override
    public String toString() {
        return "Прямоугольники" + rectangles + "; ";
    }
}
