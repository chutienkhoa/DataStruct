/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author khoa
 */
public class MergeSort {
    private int[] a;
    private int n;
    private Random r;
    public MergeSort(){
        this.n = 10;
        inputData();
        mergeSort(a, 0, this.n-1);
        showResutl(a);
    }
    
    public void inputData(){
        a = new int[n];
        r = new Random();
        for(int i=0; i<n; i++){
            a[i] = r.nextInt(100);
            System.out.print(a[i]+" ");
        }
        System.out.println("");
        
    }
    public void merge(int a[], int left, int mid, int right){
        int first1 = left;
        int last1 = mid;
        int first2 = mid+1;
        int last2 = right;
        int index = first1;
        //int n = right-left+1;
        int[]tmp = new int[n];
        while((first1<=last1)&&(first2<=last2)){
            if(a[first1]<=a[first2]){
                tmp[index] = a[first1];
                first1++;
//                index++;
            }
            else{
                tmp[index] = a[first2];
                first2++;
//                index++;
            }
            index++;
        }
        
        while(first1<=last1){
            tmp[index] = a[first1];
            index++;
            first1++;
        }
        
        while(first2<=last2){
            tmp[index] = a[first2];
            index++;
            first2++;
//            a[index] = tmp[index];
        }
        for(int i=left; i<=right; i++){
            a[i] = tmp[i];
        }
          
        
    }
    
    
    public void mergeSort(int a[], int l, int r){
        if(l<r){
            int m= (l+r)/2;
            this.mergeSort(a,l,m);
            this.mergeSort(a, m+1, r);
            this.merge(a, l, m, r);
        }
    }
    
    private void showResutl(int a[]){
        for(int i=0;i<this.n;i++){
            System.out.print(a[i]+ " ");
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        
    }
}
