package Javabasic.NameReverse;

import java.util.StringTokenizer;

public class NameReverse {
    public static void main(String[] args) {
        String s = "Dao Dinh Luyen";
        StringBuilder name = new StringBuilder();

        //cach 1:
        StringTokenizer tkz = new StringTokenizer(s);
        System.out.println(tkz);

        String[] chuoi = new String[tkz.countTokens()];




//        cach 2:
//        String[] s1 = s.split(" ");
//        String[] s2 = new String[s1.length];
//
//        if (s1.length - 1 >= 0) System.arraycopy(s1, 0, s2, 1, s1.length - 1);
//        s2[0] = s1[s1.length -1];
//        for(String x : s2){
//            name.append(x).append(" ");
//        }
//        String name2 = String.valueOf(name);
//        System.out.println(name2.trim());

        //cach3:
//        int i = s.trim().lastIndexOf(" ");
//        System.out.println(s.substring(i + 1) + " " + s.substring(0, i));
    }
}
