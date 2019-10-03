/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblesort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Nati Gonzalez
 */
    
public class BubbleSort {

    
    int swaps;
    int comparaciones;
    int counter;
    LinkedList steps= new LinkedList();
    
    public void sort(Integer[] array) {  
        int n = array.length;  
        int temp;  
        
            for(int i=0; i < n; i++){  
                for(int j=1; j < (n-i); j++){  
                    if(array[j-1] > array[j]){
                        //Swap 
                        swaps++;
                        temp = array[j-1];  
                        array[j-1] = array[j];  
                        array[j] = temp;  
                        }  
                    comparaciones++;  
                 }
               
                steps.add(arrayToString(array));
                
         }
           
         System.out.println(" ");
         System.out.println("Swaps: "+swaps);
         System.out.println("Comparaciones: "+comparaciones);
         
    }
    public void printArray(Integer[] array){
        System.out.print("Array: [");
        for (int i =0; i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.print("]");
    }
    
    public String arrayToString(Integer[] array){
        String str;
        str="[";
        
        for (int i =0; i<array.length;i++){
            str=str+array[i]+" ";
        }
        str=str+"]";
        
        return str;
    }
    public void printbySteps(){
        if (counter == steps.size()){
            counter=0;
        }
        else{
            System.out.print(counter+1+". ");
            String array = (String)steps.get(counter);
            System.out.println(array);
            counter++;
        }
    }
    
    
}
