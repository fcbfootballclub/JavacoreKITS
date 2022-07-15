package Javabasic.Dang5;

import java.util.Arrays;

public class Dang5Bai2 {
    public static void main(String[] args) {
        int[] A = {5, 10,16, 4,6, 8,95, 3, 101, 102, 103};
        timChuoiTangDangLonNhat(A);
    }

    public static void timChuoiTangDangLonNhat(int[] list) {
        int len = 1;
        int maxLen = 1;
        int sum = list[0];

        //luu lại max len của chuỗi tăng dần lớn nhất vào array vị trí
        int[] viTri = new int[list.length];
        int count = 1; //so lan chuoi thoa man xuat hien
        viTri[count - 1] = 0; // luu lai vao vi tri count - 1.

        //lưu lại maxLenIndex vào một chuỗi
        for (int i = 1; i < list.length; i++) {
            if(list[i] >= list[i -1]){
                len++;
                sum += list[i];
            } else {
                len = 1;
                sum = list[i];
            }

            if(len == maxLen && sum >= 100){
                count++;
                viTri[count -1] = i;
            } else if(len > maxLen && sum >= 100) {
                count = 1;
                maxLen = len;
                viTri[count - 1] = i;
            }
        }

        System.out.println(Arrays.toString(viTri));
        System.out.println("count: " + count);
        System.out.println(maxLen);
        System.out.println("sum: " + sum);



//        System.out.println("so lan xuat hien: " );
        for (int i = 0; i < count; i++) {
            System.out.println();
            System.out.println("Vi tri bat dau cua day con thu " + i + " la: " + (viTri[i] - maxLen + 1));
            System.out.println("Day con thu " + i + " la: ");
            for (int j = viTri[i] - maxLen + 1; j <= viTri[i]; j++) {
                System.out.print(list[j] + " ");
            }
        }
    }
}
