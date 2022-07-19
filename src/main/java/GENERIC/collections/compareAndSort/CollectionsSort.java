/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.compareAndSort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Hung
 */
public class CollectionsSort {

    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Tom", "Peter", "Alice", "Bob", "Sam",
                "Mary", "Jane", "Bill", "Tim", "Kevin");
        System.out.println("Before sorting: " + names);
        Collections.sort(names);
        System.out.println("After sorting: " + names);
        int i= Collections.binarySearch(names, "Bob");
        if (i>0) {
            System.out.println("Tìm thấy ở vị trí:"+i);
        } else System.out.println("Không tìm thấy Bob");
        
        List<Integer> numbers = Arrays.asList(8, 2, 5, 1, 3, 4, 9, 6, 7, 10);
        System.out.println("Before sorting: " + numbers);
        Collections.sort(numbers);
        System.out.println("After sorting: " + numbers);  
    }

}
