package Javabasic.Test1;

public class BaiTest {
    public static void main(String[] args) {
        int [] D={5, 1, 9};
        dayConTangDanDaiNhat(D);
    }

    //bai 5
    public static void dayConTangDanDaiNhat(int[] list) {
        int maxDay = 1;
        int count = 1;
        int mark = 1;
        int sumMax = list[0];
        int sum = 0;

        for (int i = 1; i < list.length; i++) {
            if (list[i] > list[i - 1]) {
                count++;
                sum += list[i];
                maxDay = count;
            } else {
                count = 1;
                sum = list[i];
            }

            if (sum > 20 && sum < 100) {
                mark = i;
                sumMax = sum;
            }
        }

        System.out.println(maxDay);
        System.out.println(sumMax);
        System.out.println(mark);
    }

}
