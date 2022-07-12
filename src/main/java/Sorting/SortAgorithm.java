package Sorting;

import java.util.Arrays;

public class SortAgorithm {
    public static void main(String[] args) {
        int[] list = {100, 1, 43, 54, 23, 15, 45};
//        selectionSort(list);
//        bubbleSort(list);
        insertionSort(list);
//        selectionSort2(list);
        System.out.println(Arrays.toString(list));
    }


    //selection sort trai sang phai
    public static void selectionSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int indexMin = i;
            int min = list[i];
            for (int j = i + 1; j < list.length; j++) {
                if (min > list[j]) {
                    indexMin = j;
                    min = list[j];
                }
            }
            //swap list[i] vaf list[min]
            int temp = list[i];
            list[i] = list[indexMin];
            list[indexMin] = temp;
        }
    }

    //selection sort tu phai sang trai
    public static void selectionSort2(int[] list) {
        for (int i = list.length - 1; i >= 0; i--) {
            int indexMax = i;
            int max = list[i];
            for (int j = i - 1; j >= 0; j--) {
                if (max < list[j]) {
                    indexMax = j;
                    max = list[j];
                }
            }
            //swap list[i] vaf list[min]
            int temp = list[i];
            list[i] = list[indexMax];
            list[indexMax] = temp;
        }
    }




    //buble sort
    public static void bubbleSort(int[] list) {
        for(int i = 0; i < list.length; i++) {
            for(int j = list.length - 1; j > i; j--) {
                if(list[j] > list[j -1]) {
                    int temp = list[j];
                    list[j] = list[j - 1];
                    list[j -1] = temp;
                }
            }
        }
    }

    //insertion sort
    public static void insertionSort(int[] list) {
        for(int i = 0; i < list.length - 1; i++) {
            for(int j = i + 1; j > 0; j--){
                int temp = list[j];
                while(list[j] < list[j -1]){
                    list[j] = list[j - 1];
                    list[j - 1] = temp;
                }
            }
        }
        //note khong co chuyen doi cho
    }
}
