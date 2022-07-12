package Javabasic.NameReverse;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Bai4 {
    public static void main(String[] args) {
        int[] A = {5, 7, 9, 10, 16, 9};
        int[] B = {5, -1, 9, -10, 16};
        int[] C = {5, 17, 11};
        System.out.println(dayTangDan(A));
        System.out.println(dayTraiDau(B));
        System.out.println(isDayPrime(C));

        int [] D={5, 7, 1, 9, 10, 16, 4, 6, 8, 3};
        dayConTangDanDaiNhat(D);

    }

    public static boolean dayTangDan(int[] A) {

        for (int i = 0; i < A.length -1 ; i++) {
            if(A[i] > A[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean dayTraiDau(int[] B) {
        if (B[0] > 0) {
            for (int i = 0; i < B.length; i = i + 2) {
                if (B[i] != Math.abs(B[i])) {
                    return false;
                }
            }
            for (int i = 1; i < B.length; i = i + 2) {
                if (B[i] == Math.abs(B[i])) {
                    return false;
                }
            }
            return true;
        } else {
            for (int i = 0; i < B.length; i = i + 2) {
                if (B[i] == Math.abs(B[i])) {
                    return false;
                }
            }
            for (int i = 1; i < B.length; i = i + 2) {
                if (B[i] != Math.abs(B[i])) {
                    return false;
                }
            }
            return true;
        }
    }

    //check mot so nguyen to
    public static boolean isPrime(int x) {
        if (x < 2) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(x); i++) {
                if (x % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    //check mot array nguyen to
    public static boolean isDayPrime(int[] C) {
        for (int j : C) {
            if (!isPrime(j)) {
                return false;
            }
        }
        return true;
    }

    //bai 5
    public static void dayConTangDanDaiNhat(int[] list) {
        int maxDay = 0;
        int count = 0;
        int mark =0;
        for(int i = 0; i < list.length -1; i++) {
            count++;
            if(count > maxDay) {
                maxDay = count;
                mark = i;
            }
            if(list[i] > list[i + 1]){
                count = 0;
            }
        }
        System.out.println(list[mark]);
        int[] dayConDaiNhat = new int[maxDay];

        System.arraycopy(list, mark - maxDay + 1, dayConDaiNhat, 0,maxDay);
        System.out.println("Do dai day con lon nhat la: " + maxDay);
        System.out.println(Arrays.toString(dayConDaiNhat));
    }

}
