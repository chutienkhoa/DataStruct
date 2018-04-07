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
public class NormalSorts {
    private int x[];
    private int n;
    private Random r;
    
    public NormalSorts(int n){
        this.n = n;
        readData();
        bubbleSort(x);
        showResutl();
        readData();
        insertSort(x);
        showResutl();
        readData();
        selectSort(x);
        showResutl();
    }
    
    private void readData(){
        System.out.println("");
        x = new int[n];
        r = new Random();
        for(int i=0;i<n;i++){
            x[i] = r.nextInt(100);
        }
        for(int i=0;i<this.n;i++){
            System.out.print(x[i]+" ");
        }
        System.out.println("");
    }
    
    private void showResutl(){
        for(int i=0;i<n;i++){
            System.out.print(x[i]+" ");
        }
        System.out.println("");
    }
    
    public void swap(int x[], int i, int j){
        int tmp = x[i];
        x[i] = x[j];
        x[j] =tmp;
    }
    
    
    private void bubbleSort(int x[]){
        System.out.println("Truong hop 1");
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(x[i]>x[j]){
                    swap(x, i, j);
                }
            }
        }
    }
    
    private void insertSort(int x[]){
        System.out.println("Truong hop 2");
        for(int i=1;i<this.n;i++){
            for(int j=0;j<i;j++){
                if(x[i]<x[j]){
                    swap(x, i, j);
                }
            }
        }
    }
    
    private void selectSort(int x[]){
        System.out.println("Truong hop 3");
        for(int i=0;i<this.n-1;i++){
            int min = i;
            for(int j=i+1; j<this.n; j++){
                if(x[min]>x[j]){
                    min = j;
                }
            }
            swap(x, i, min);
        }
    }
    
    public static void main(String[] args) {
        NormalSorts obj1 = new NormalSorts(10);
    }
}
