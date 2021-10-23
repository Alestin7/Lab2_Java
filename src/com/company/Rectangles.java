package com.company;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;

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
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean serializeFastJSON(String filename){
        try {
            FileWriter outStream = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(outStream);
            bw.write(JSON.toJSONString(rectangles));
            bw.close();
            outStream.close();
        }
        catch (IOException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deserializeFastJSON(String filename){
        try {
            Scanner scanner = new Scanner(new FileReader(filename));

            rectangles.clear();

            List<JSONObject> JSONList = JSON.parseObject(filename, List.class);
            for (JSONObject st : JSONList){
                rectangles.add(new Rectangle(st.getIntValue("a"), st.getIntValue("b")));
            }
            scanner.close();
        }
        catch (IOException e){
            e.printStackTrace();
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
