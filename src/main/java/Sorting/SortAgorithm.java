package Sorting;

import com.sun.source.tree.WhileLoopTree;

import java.util.Arrays;

public class SortAgorithm {
    public static void main(String[] args) {
        int[] list = {100, 1, 43, 54, 23, 15, 45};
//        selectionSort(list);
//        bubbleSort(list);
//        insertionSort(list);
          insertionSort2(list);
//        System.out.println(Arrays.toString(list));
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

    //insertion sort tu phai sang trai
    public static void insertionSort(int[] list) {
        int n = list.length - 1;
        int i, j, x;

        for(i = n - 1; i >= 0; i--) {
            x = list[i];
            j = i + 1;
            while(j <= n && x > list[j]) {
                list[j - 1] = list[j];
                j++;
            }
            list[j - 1] = x;
        }
    }

    //insertion sort tu trai sang phai
    public static void insertionSort2(int[] list) {

        int i, j;
        i = 0;
        int pos = i;

        int x = list[i];
        for(j = i + 1; j >= 0; j--) {
            if(x > list[j]) {
                list[j] = list[j + 1];
                pos++;
            }
            list[pos] = x;
        }

        System.out.println(Arrays.toString(list));

    }

    //fdsaf
    static void Check2(int[] array){
        for (int i = array.length - 2; i >= 0 ; i--) {
            int value = array[i];
            int hole = i;
            for (int j = i; j < array.length - 1; j++) {
                if (array[j + 1] < value) {
                    array[j] = array[j + 1];
                    hole++;
                }
                else {
                    break;
                }
            }
            if (hole != i) {
                array[hole] = value;
            }
        }
        System.out.print("\n 2 \n");
        System.out.println(Arrays.toString(array));
    }
}
