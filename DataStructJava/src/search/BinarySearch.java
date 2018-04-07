/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import java.util.Random;
import sort.MergeSort;

/**
 *
 * @author khoa
 */
public class BinarySearch {

    private int x[];
    private int n;
    private Random r;

    public BinarySearch(int n) {
        this.n = n;
        readData();
//        java.util.Arrays.sort(x,0,n-1);

        showResult();
    }

    public void readData() {
        x = new int[n];
        r = new Random();
        for (int i = 0; i < n; i++) {
            x[i] = r.nextInt(100);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println("");
    }

    public boolean binarySearch(int a[], int key, int left, int right) {
//        MergeSort sort = new MergeSort();
//        sort.mergeSort(a, 0, (right-left)-1);
//        for(int i=0; i<this.n; i++){
//            System.out.print(a[i]+" ");
//        }
        System.out.println("");
        if (left <= right) {
            int mid = (left + right) / 2;
            if (x[mid] == key) {
                return true;
            } else if (x[mid] > key) {
                return binarySearch(a, key, left, mid);
            } else {
                return binarySearch(a, key, mid + 1, right);
            }
        }
        return false;
    }

    public void showResult() {
        System.out.println(binarySearch(x, 10, 0, n - 1));
    }

    public static void main(String[] args) {
        BinarySearch obj1 = new BinarySearch(10);
    }

}
