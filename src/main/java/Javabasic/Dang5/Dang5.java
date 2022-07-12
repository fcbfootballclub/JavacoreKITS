package Javabasic.Dang5;

public class Dang5 {
    public static void main(String[] args) {
        int[] A = {5, 3, 7, 8, 4, 6, 8, 3};
        timChuoiTangDangLonNhat(A);
    }

    public static void timChuoiTangDangLonNhat(int[] list) {
        int count = 0;
        int maxLen = 0;

        //luu lại max len của chuỗi tăng dần lớn nhất vào array vị trí
        int[] viTri = new int[list.length];

        //lưu lại maxLenIndex vào một chuỗi


        for (int i = 0; i < list.length - 1; i++) {
            count++;
            if (count >= maxLen) {
                maxLen = count;
                viTri[i] = maxLen;
            }
            if (list[i] > list[i + 1]) {
                count = 0;
            }
        }
//        System.out.println(Arrays.toString(viTri));
//        System.out.println(maxLen);

        //tim số lần maxLen xuất hiện trong dãy vị trí và index của maxLen chính là last_index của chuỗi tăng dần có độ dài lớn nhất
        int maxVitri = viTri[0];
        int countMaxViTri = 1;
        int[] positionMaxViTri = new int[viTri.length];
        positionMaxViTri[countMaxViTri - 1] = 0;
        for (int i = 1; i < viTri.length; i++) {
            if (maxVitri == viTri[i]) {
                countMaxViTri++;
                positionMaxViTri[countMaxViTri - 1] = i;
            } else if (maxVitri < viTri[i]) {
                maxVitri = viTri[i];
                countMaxViTri = 1;
                positionMaxViTri[countMaxViTri - 1] = i;
            }
        }

//        System.out.println("maxvitri: " + maxVitri);
//        System.out.println("so lan xuat hien: " + countMaxViTri);
        for (int i = 0; i < countMaxViTri; i++) {
            System.out.println("Vi tri bat dau cua day con thu " + i + " la: " + (positionMaxViTri[i] - maxLen + 1));
            System.out.println("Day con thu " + i + " la: ");
            for (int j = positionMaxViTri[i] - maxLen + 1; j <= positionMaxViTri[i]; j++) {
                System.out.println(list[j]);
            }
        }
    }

}
