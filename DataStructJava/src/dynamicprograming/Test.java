/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicprograming;

/**
 *
 * @author khoa
 */
public class Test {
    int [] a;
    int n;
    public Test(){
        n = 10;
        inputData();
        showResult();
    }
    
    public void inputData(){
        a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = i;
        }
    }
    
    public void cong(int b[]){
//        System.out.println(b[1]);
        for(int i=0;i<n;i++){
            b[i] = i;
        }
        for(int i=0; i<n; i++){
            a[i] = a[i]+b[i];
        }
    }
    
    public void showResult(){
        cong(a);
        for(int i=0; i<n; i++){
            System.out.print(a[i]+" ");
        }
    }
    public static void main(String[] args) {
        Test t1 = new Test();
    }
}
