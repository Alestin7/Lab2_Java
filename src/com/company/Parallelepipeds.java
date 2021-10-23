package com.company;

import java.util.ArrayList;
import java.util.List;

public class Parallelepipeds {
    private final List<Parallelepiped> parallelepipeds;

    public Parallelepipeds() {
        parallelepipeds = new ArrayList<>();
    }

    public List<Parallelepiped> getParallelepipeds() {
        return parallelepipeds;
    }

    public void add(Parallelepiped paral) {
        this.parallelepipeds.add(paral);
    }

    public void remove(Parallelepiped paral) {
        this.parallelepipeds.remove(paral);
    }

    public void fillRandom(int n){
        for (int i = 0; i < n; i++) {
            parallelepipeds.add(Parallelepiped.generate());
        }
    }

    public int getCubesQuantity(){
        int N = 0;
        for (Parallelepiped paral : this.parallelepipeds){
            if (paral.getA() == paral.getB() && paral.getA() == paral.getC()){
                N++;
            }
        }
        return N;
    }

    @Override
    public String toString() {
        return "\n\n\nПараллелипипеды" + parallelepipeds + "; ";
    }
}
