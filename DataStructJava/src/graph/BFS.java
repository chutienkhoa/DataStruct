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
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author khoa
 */
public class BFS {

    private int x[][];
    private int numVertext; // so dinh cua do thi
    private int numEdge;
    private int visited[];

    public BFS() {
        readData("./src/graph/data1.txt");
    }

    public void readData(String fileName) {
        BufferedReader br = null;
        try {
            File file = new File(fileName);
            br = new BufferedReader(new FileReader(file));
            numVertext = Integer.parseInt(br.readLine());
            x = new int[numVertext][numVertext];
            for (int i = 0; i < numVertext; i++) {
                for (int j = 0; j < numVertext; j++) {
                    x[i][j] = 0;
                }
            }

            String dataLine = br.readLine();
            String data = dataLine;
            while (data != null) {
                String[] data1 = data.split(" ");
                int firstNum = Integer.parseInt(data1[0]);
                int secondNum = Integer.parseInt(data1[1]);
                x[firstNum - 1][secondNum - 1] = 1;
                x[secondNum - 1][firstNum - 1] = 1;
                data = br.readLine();
            }

            for (int i = 0; i < numVertext; i++) {
                for (int j = 0; j < numVertext; j++) {
                    System.out.print(x[i][j] + " ");
                }
                System.out.println("");
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(BFS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BFS.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(BFS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void breadFirstSearch(int start) {
        System.out.println("Thu tu duyet theo BFS");
        visited = new int[numVertext];
        for (int i = 0; i < numVertext; i++) {
            visited[i] = 0; // chua duoc tham
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        while(queue.size()!=0){
            int v = queue.poll();
            visited[v]=1;
            System.out.print((v+1)+" ");
            for(int i=0; i<numVertext;i++){
                if(x[v][i]==1){
                    if(visited[i]==0){
                        queue.add(i);
                        visited[i]=1;
                    }
                }
            }
        }
        
        System.out.println("");
    }

    public void showResult() {

    }

    public static void main(String[] args) {
        BFS obj1 = new BFS();
        obj1.breadFirstSearch(0);
    }
}
