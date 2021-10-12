package com.company;

import java.util.ArrayList;
import java.util.List;

public class Parals {
    private final List<Paral> parals;

    public Parals() {
        parals = new ArrayList<>();
    }

    public List<Paral> getParals() {
        return parals;
    }

    public void add(Paral paral) {
        this.parals.add(paral);
    }

    public void remove(Paral paral) {
        this.parals.remove(paral);
    }

    public void fillRandom(int n){
        for (int i = 0; i < n; i++) {
            parals.add(Paral.generate());
        }
    }

    public void Cube(){
        int N = 0;
        for (Paral paral : this.parals){
            if (paral.getA() == paral.getB() && paral.getA() == paral.getC()){
                N++;
            }
        }
        System.out.println("\nКоличество кубов: " + N);
    }

    @Override
    public String toString() {
        return "\n\n\nПараллелипипеды" + parals + "; ";
    }
}
