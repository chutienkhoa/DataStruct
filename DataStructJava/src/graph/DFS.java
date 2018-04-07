/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author khoa
 */
public class DFS {

    private int x[][];
    private int numVertext;
    private int visited[];

    public DFS() {
        readData("./src/graph/data1.txt");
    }

    public void readData(String fileName) {
        BufferedReader br = null;
        try {
            File file = new File(fileName);
            br = new BufferedReader(new FileReader(file));
            numVertext = Integer.parseInt(br.readLine());
            x = new int[numVertext][numVertext];
            for (int i = 0; i < this.numVertext; i++) {
                for (int j = 0; j < this.numVertext; j++) {
                    x[i][j] = 0;
                }
            }

            String data = br.readLine();
            String dataLine = br.readLine();
            while (dataLine != null) {
                String[] data1 = dataLine.split(" ");
                int firstNum = Integer.parseInt(data1[0]);
                int secNum = Integer.parseInt(data1[1]);
                x[firstNum - 1][secNum - 1] = 1;
                x[secNum - 1][firstNum - 1] = 1;
                dataLine = br.readLine();
            }

            for (int i = 0; i < this.numVertext; i++) {
                for (int j = 0; j < this.numVertext; j++) {
                    System.out.print(x[i][j] + " ");
                }
                System.out.println("");
            }
            System.out.println("-------------------");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DFS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DFS.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(DFS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void deepFirstSearch(int u) {
//        Stack<Integer> stack = new Stack<>();
        visited = new int[numVertext];
        for(int i=0;i<this.numVertext;i++){
            visited[i] = 0; // tat ca cac dinh chua duoc duyet
        }
//        stack.push(u);
//        visited[u] = 1;
////        System.out.print(u+" ");
//        while(stack.isEmpty()==false){
//            int k;
//            k = stack.pop();
//            System.out.print(k+" ");
//            for(int j=numVertext-1;j>=0;j--){
//                if(visited[j]==0){
//                    stack.push(j);
//                    visited[j] = 1;
//                }
//            }
//        }
          System.out.print(u+" ");
          visited[u] = 1;
          for(int i=0;i<numVertext;i++){
              if((x[u][i]==1)&&(visited[i]==0)){
                  deepFirstSearch(i);
                  
              }
          }
        
        
    }

    public static void main(String[] args) {
        DFS obj1 = new DFS();
        obj1.deepFirstSearch(0);
        
    }
}
