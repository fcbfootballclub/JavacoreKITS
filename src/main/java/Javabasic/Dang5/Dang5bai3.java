package Javabasic.Dang5;

import java.util.Arrays;

public class Dang5bai3 {
    public static void main(String[] args) {
        int[] A={1,0,2, 4, 6, 8, 14, 3, 4, 6, 8, 14, 16};
        dayConTangDanSoChan(A);
    }


    //dang 5 Bai 3
    public static void dayConTangDanSoChan(int[] list) {
        int last_index = -1;
        int len = 0;
        int countMaxLen = 0;

        //luu  vi tri cua last_index va max-len vao list vitriMax
        int[] viTriMax = new int[list.length];

        for(int i = 0; i < list.length - 1; i++) {
            if(list[i] % 2 == 0) {
                if(len == 0) {
                    len = 1;
                    last_index = i;
                }

                if(list[i] < list[i+1] && list[i + 1] % 2 == 0) {
                    len++;
                    last_index = i + 1;
                } else {
                    len = 0;
                }

            } else {
                len = 0;
            }

            if(len >= countMaxLen && len != 0) {
                countMaxLen = len;
                viTriMax[last_index] = countMaxLen;
            }
        }

        System.out.println(last_index);
        System.out.println(countMaxLen);
        System.out.println(Arrays.toString(viTriMax));

        //vi tri last_index cua day chan tang dan can tim luu vao list index
        int[] index = new int[viTriMax.length];
        int countSoDay = 0;
        for(int i = 0; i < viTriMax.length; i++) {
            if(countMaxLen == viTriMax[i]){
                index[countSoDay++] = i;
            }
        }
//        System.out.println(Arrays.toString(index));

        //in ra cac day la so chan tang dan
        for(int i = 0; i < countSoDay; i++) {
            System.out.println("");
            System.out.println("Day thu " + i + " la: ");
            for(int j = index[i] - countMaxLen + 1; j <= index[i]; j++) {
                System.out.print(list[j] + " ");
            }
        }
    }

}
