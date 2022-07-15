package Javabasic.Dang5;

import java.util.Arrays;

public class Dang5 {
    public static void main(String[] args) {
        int[] A = {5,1, 3, 7, 8, 4, 6, 8, 10, 11};
        timChuoiTangDangLonNhat(A);
    }

    public static void timChuoiTangDangLonNhat(int[] list) {
        int[] viTri = new int[list.length];
        int len = 1;
        int max_len = 1;

        int count = 1; //so lan xuat hien cua chuoi lon nhat
        viTri[count - 1] = 0; //vitri xua hien cua chuoi lon nhat


        for (int i = 1; i < list.length; i++) {
            if (list[i - 1] <= list[i]) {
                len++;
            } else {
                len = 1;
            }

            if (len == max_len) {
                count++;
                viTri[count - 1] = i;
            } else if (len > max_len) {
                max_len = len;
                count = 1;
                viTri[count - 1] = i;
            }
        }

        System.out.println("maxLen = " + max_len);
//        System.out.println("count = " + cnt);


        System.out.println(Arrays.toString(viTri));

        System.out.println("so lan xuat hien: " + count);

        for (int i = 0; i < count; i++) {
            System.out.println();
            System.out.println("Vi tri bat dau cua day con thu " + i + " la: " + (viTri[i] - len +1));
            System.out.println("Day con thu " + i + " la: ");
            for (int j = viTri[i] - len +1; j <= viTri[i]; j++) {
                System.out.print(list[j] + " ");
            }
        }
    }
}