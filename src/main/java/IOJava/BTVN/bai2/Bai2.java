package IOJava.BTVN.bai2;

import java.io.*;
import java.util.Arrays;

public class Bai2 {
    int[] list;
    BufferedReader bufferedReader = null;

    //Đọc file bằng buffer reader và in ra chuỗi sắp xếp
    public void readFile(File file) {
        String stringList;
        try {
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            stringList = bufferedReader.readLine();
            String[] list2 = stringList.split(" ");
            System.out.println("List truoc khi sap xep: ");
            System.out.println(Arrays.toString(list2));
            sapXep(list2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    //Datainput stream và in ra chuỗi chẵn dài nhất
    void readNumbersDatFile(File file) {
        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            String stringInput = dataInputStream.readUTF();
//            System.out.println("StringInput: " + stringInput);
            dayChanLonNhat(stringInput);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //write to file chuỗi đã sắp xếp bằng data output stream
    public void writeFile(File fileWrite) {
        StringBuilder stringContent = new StringBuilder();
        for (int i : list) {
            stringContent.append(i).append(" ");
        }
//        System.out.println("String content: " + stringContent);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileWrite);
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
            dataOutputStream.writeUTF(String.valueOf(stringContent));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //sắp xếp file int
    public void sapXep(String[] list2) {
        list = new int[list2.length];
        //copy list string sang list int[]
        for (int i = 0; i < list2.length; i++) {
            list[i] = Integer.parseInt(list2[i]);
        }
        //Sap xep chen
        for (int i = 0; i < list.length - 1; i++) {
            int temp = list[i + 1];
            int pos = i + 1;
            for (int j = i + 1; j > 0; j--) {
                if (temp < list[j - 1]) {
                    list[j] = list[j - 1];
                    pos = j - 1;
                } else {
                    break;
                }
            }
            if (pos != i + 1) {
                list[pos] = temp;
            }
        }
        System.out.println("List sau khi sap xep: " + Arrays.toString(list));
    }

    //In ra dãy chắn có độ dài lớn nhất
    public void dayChanLonNhat(String stringInput) {
        String[] numArray = stringInput.split(" ");
        for (int i = 0; i < numArray.length; i++) {
            list[i] = Integer.parseInt(numArray[i]);
        }
        System.out.println();
        dayConTangDanSoChan(list);
        System.out.println();
    }

    //dang 5 Bai 3
    public static void dayConTangDanSoChan(int[] list) {
        int last_index = -1;
        int len = 0;
        int countMaxLen = 0;

        //luu  vi tri cua last_index vao list vitriMax
        int[] viTriMax = new int[list.length];
        int count = 0; //so lan xuat hien cua chuoi dai nhat

        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] % 2 == 0) {
                if (len == 0) {
                    len = 1;
                    last_index = i;
                }

                if (list[i] < list[i + 1] && list[i + 1] % 2 == 0) {
                    len++;
                    last_index = i + 1;
                } else {
                    len = 0;
                }

            } else {
                len = 0;
            }

            if (len == countMaxLen && len != 0) {
                count++;
                viTriMax[count - 1] = last_index;
            } else if (len > countMaxLen) {
                countMaxLen = len;
                count = 1;
                viTriMax[count - 1] = last_index;
            }
        }
//        System.out.println(last_index);
//        System.out.println(countMaxLen);
//        System.out.println(Arrays.toString(viTriMax));

        //in ra cac day la so chan tang dan
        for (int i = 0; i < count; i++) {
            System.out.println("");
            System.out.println("Day thu " + i + " la: ");
            for (int j = viTriMax[i] - countMaxLen + 1; j <= viTriMax[i]; j++) {
                System.out.print(list[j] + " ");
            }
        }
    }


    public static void main(String[] args) {
        Bai2 bai2 = new Bai2();

        //đọc file int và in ra một dãy đã sắp xếp
        File file = new File("C:\\Users\\Big Man\\Desktop\\KITS\\Core\\JavacoreKITS\\src\\main\\java\\IOJava\\BTVN\\bai2\\Data.txt");
        bai2.readFile(file);

        //write List đó ra một file khác bằng data out put stream
        File fileWrite = new File("C:\\Users\\Big Man\\Desktop\\KITS\\Core\\JavacoreKITS\\src\\main\\java\\IOJava\\BTVN\\bai2\\Numbers.dat");
        bai2.writeFile(fileWrite);

        //Đọc file vừa ghi bằng data input stream
        bai2.readNumbersDatFile(fileWrite);
    }


}
