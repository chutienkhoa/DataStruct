/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import java.util.Random;

/**
 *
 * @author khoa
 */
public class QuickSort {

    private int[] a;
    private int n;
    private Random r;

    public QuickSort() {
        this.n = 8;
        enterData();
        quickSort(a, 0, n - 1);
//        chosePivot(a, 0, n - 1);
        showResult();
    }

    public void enterData() {
        r = new Random();
        a = new int[8];
        for (int i = 0; i < 8; i++) {
            a[i] = r.nextInt(100);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }

    void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void chosePivot(int a[], int left, int right) {
        int i = left;
        int j = right;
        int mid = (int) (left + right) / 2;
        do {
            while (a[i] < a[mid]) {
                i++;
            }
            while (a[mid] < a[j]) {
                j--;
            }
            if (i < j) {
                swap(a, i, j);
                i++;
                j--;
            }
        } while (i < j);
        if (left < j) {
            chosePivot(a, left, j);
        }
        if (i < right) {
            chosePivot(a, i, right);
        }
//        return j;
    }

//    public void quickSort(int a[], int left, int right) {
//        int pivot;
//        if (left < right) {
//            pivot = chosePivot(a, left, right);
//            if (left < pivot) {
//                quickSort(a, left, pivot);
//            } else {
//                quickSort(a, pivot+1, right);
//            }
//        }
//    }
    public void quickSort(int[] arr, int left, int right) {
        if (arr == null || arr.length == 0) {
            return;
        }

        if (left >= right) {
            return;
        }

        int middle = left + (right - left) / 2;
        int pivot = arr[middle];
        int i = left, j = right;

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        if (left < j) {
            quickSort(arr, left, j);
        }

        if (right > i) {
            quickSort(arr, i, right);
        }
    }

    public void showResult() {
        for (int i = 0; i < this.n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
    }
}
