package Javabasic.Dang5;

import java.util.Arrays;

public class Dang5Bai2 {
    public static void main(String[] args) {
        int[] A = {5, 95, 9, 5, 1, 9, 10,16, 4,6, 8, 3,5, 1, 9, 5, 1, 9, 10,16, 4,6, 8, 3, 101};
        timChuoiTangDangLonNhat(A);
    }

    public static void timChuoiTangDangLonNhat(int[] list) {
        int count = 1;
        int maxLen = 1;
        int sum = list[0];

        //luu lại max len của chuỗi tăng dần lớn nhất vào array vị trí
        int[] viTri = new int[list.length];

        //lưu lại maxLenIndex vào một chuỗi
        for (int i = 1; i < list.length; i++) {
            if(list[i] >= list[i -1]){
                count++;
                sum += list[i];
            } else {
                count = 1;
                sum = list[i];
            }
            if(count >= maxLen && sum >= 100){
                maxLen = count;
                viTri[i] = maxLen;
            }
        }

        System.out.println(Arrays.toString(viTri));
        System.out.println(maxLen);

        //tim số lần maxLen xuất hiện trong dãy vị trí và index của maxLen chính là last_index của chuỗi tăng dần có độ dài lớn nhất
        int[] positionMaxViTri = new int[viTri.length];
        int countMaxViTri = -1;
        for(int i = 0; i < viTri.length; i++) {
            if(viTri[i] == maxLen) {
                positionMaxViTri[++countMaxViTri] = i;
            }
        }
        System.out.println(Arrays.toString(positionMaxViTri));


//        System.out.println("so lan xuat hien: " + countMaxViTri);
        for (int i = 0; i <= countMaxViTri; i++) {
            System.out.println();
            System.out.println("Vi tri bat dau cua day con thu " + i + " la: " + (positionMaxViTri[i] - maxLen + 1));
            System.out.println("Day con thu " + i + " la: ");
            for (int j = positionMaxViTri[i] - maxLen + 1; j <= positionMaxViTri[i]; j++) {
                System.out.print(list[j] + " ");
            }
        }
    }
}
