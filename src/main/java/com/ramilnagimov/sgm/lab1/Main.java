package com.ramilnagimov.sgm.lab1;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        double x0 = -1;
        double xMax = 0;
        double y0 = 1.5;
        // Численное решение с шагом h=0.1
        double h1 = 0.1;
        calculate(x0, y0, xMax, h1);

        //Численное решение с шагом h=0.2
        double h2 = 0.2;
        calculate(x0, y0, xMax, h2);
    }

    private static void calculate(double x0, double y0, double xMax, double h) {

        int n = (int) ((xMax - x0) / h);
        List<Double> xList = new ArrayList<>();
        xList.add(x0);
        List<Double> yList = new ArrayList<>();
        yList.add(y0);
        for (int i = 1; i < n + 1; i++) {
            xList.add(xList.get(i-1) + h);
            yList.add((yList.get(i-1) + Math.pow(xList.get(i-1)+2, 2)*xList.get(i-1)) / (xList.get(i-1) + 2));
        }
        System.out.println("Численное решение с шагом h = " + h);
        System.out.println("i\t Xi\t\tYi");
        DecimalFormat numberFormat = new DecimalFormat("0.0");
        DecimalFormat numberFormat2 = new DecimalFormat("0.000");
        for (int i = 0; i < n + 1; i++) {
            System.out.print(i + "\t");
            System.out.print(numberFormat.format(xList.get(i)) + "\t");
            System.out.print(numberFormat2.format(yList.get(i)) + "\n");
        }
    }
}
