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
public class LCS {

    private int[] x;
    private int m;
    private int[] y;
    private int n;
    private int[][] c;

    private Random r;

    public LCS(int m, int n) {
        this.n = n;
        this.m = m;
        readData();
        showResult();
    }

    public void readData() {
        r = new Random();
        x = new int[m];
        y = new int[n];
        for (int i = 0; i < this.m; i++) {
            x[i] = r.nextInt(10);
        }
        for (int i = 0; i < this.n; i++) {
            y[i] = r.nextInt(8);
        }
        System.out.println("");
        for (int i = 0; i < this.m; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println("");
        for (int i = 0; i < this.n; i++) {
            System.out.print(y[i] + " ");
        }
        System.out.println("");
    }

    public int lastestCommonSeq(int x[], int y[]) {
        c = new int[m][n];
        for (int i = 0; i < this.m; i++) {
            c[i][0] = 0;
        }
        for (int i = 0; i < this.n; i++) {
            c[0][i] = 0;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (x[i] == y[j]) {
//                    System.out.print(y[j] + " ");
                    c[i][j] = c[i - 1][j - 1] + 1;
                } else {
                    c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
                }
            }
        }
        System.out.println("");
        return c[m - 1][n - 1];

    }

    public void showResult() {
        System.out.println("Day con chung dai nhat la: " + lastestCommonSeq(x, y));
    }

    public static void main(String[] args) {
        LCS obj1 = new LCS(10, 8);
    }
}
