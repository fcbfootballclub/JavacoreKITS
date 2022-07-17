package Javabasic.Dang5;

import java.util.Arrays;

public class Dang5bai3 {
    public static void main(String[] args) {
        int[] A={1,0,2, 4, 6, 8, 14, 3, 4, 6, 8, 14, 16, 18};
        dayConTangDanSoChan(A);
    }


    //dang 5 Bai 3
    public static void dayConTangDanSoChan(int[] list) {
        int last_index = -1;
        int len = 0;
        int countMaxLen = 0;

        //luu  vi tri cua last_index va max-len vao list vitriMax
        int[] viTriMax = new int[list.length];
        int count = 0;

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

            if(len == countMaxLen && len != 0) {
                count++;
                viTriMax[count - 1] = last_index;
            } else if(len > countMaxLen){
                count = 1;
                countMaxLen = len;
                viTriMax[count - 1] = last_index;
            }
        }

        System.out.println("Count so day chan = " + count);
        System.out.println("Count max len: " + countMaxLen);
        System.out.println(Arrays.toString(viTriMax));


//        System.out.println(Arrays.toString(index));

        //in ra cac day la so chan tang dan
        for(int i = 0; i < count; i++) {
            System.out.println("");
            System.out.println("Day thu " + i + " la: ");
            for(int j = viTriMax[i] - countMaxLen + 1; j <= viTriMax[i]; j++) {
                System.out.print(list[j] + " ");
            }
        }
    }

}
