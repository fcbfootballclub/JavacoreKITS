/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.compareAndSort;

import java.util.Arrays;

/**
 *
 * @author Hung
 */
public class ArraysSort {
    public static void main(String[] args) {
        int[] arr = {13, 7, 6, 45, 21, 9, 101, 102}; 
        Arrays.sort(arr); 
        System.out.printf("Modified arr[] : %s",
                          Arrays.toString(arr));
        int i= Arrays.binarySearch(arr,45);
        if (i>0) {
            System.out.println("Tìm thấy 45 ở vị trí:"+i);
        } else System.out.println("Không tìm thấy 45");
        
              
    }
}
