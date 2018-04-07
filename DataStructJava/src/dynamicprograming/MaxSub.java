/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicprograming;

import java.util.Random;

/**
 *
 * @author khoa
 */
public class MaxSub {

    private int[] x;
    private int n;
    private Random r;

    public MaxSub(int n) {
        this.n = n;
        readData();
//        maxSub();
        showResult();
    }

    public void readData() {
        r = new Random();
        x = new int[n];
        for (int i = 0; i < this.n; i++) {
            x[i] = r.nextInt(10)-5;
        }
        for (int i = 0; i < this.n; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println("");
    }

    public int maxSub() {
        int sumMax = x[0];
        int[] resultTmp = new int[n];
        resultTmp[0] = x[0];
        for (int i = 1; i < this.n; i++) {
            resultTmp[i] = Math.max(x[i], x[i] + resultTmp[i - 1]);
            sumMax = Math.max(sumMax, resultTmp[i]);
        }
        return sumMax;
    }

    public void showResult() {
        System.out.println("Result: " + maxSub());
    }

    public static void main(String[] args) {
        MaxSub obj1 = new MaxSub(10);
    }

}
