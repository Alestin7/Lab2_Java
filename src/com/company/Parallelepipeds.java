package com.company;

import java.util.ArrayList;
import java.util.List;

public class Parallelepipeds {
    private final List<Parallelepiped> parals;

    public Parallelepipeds() {
        parals = new ArrayList<>();
    }

    public List<Parallelepiped> getParals() {
        return parals;
    }

    public void add(Parallelepiped paral) {
        this.parals.add(paral);
    }

    public void remove(Parallelepiped paral) {
        this.parals.remove(paral);
    }

    public void fillRandom(int n){
        for (int i = 0; i < n; i++) {
            parals.add(Parallelepiped.generate());
        }
    }

    public int getCubesQuantity(){
        int N = 0;
        for (Parallelepiped paral : this.parals){
            if (paral.getA() == paral.getB() && paral.getA() == paral.getC()){
                N++;
            }
        }
        return N;
    }

    @Override
    public String toString() {
        return "\n\n\nПараллелипипеды" + parals + "; ";
    }
}
