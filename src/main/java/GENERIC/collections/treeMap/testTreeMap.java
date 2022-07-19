package collections.treeMap;

import collections.treeSet.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author ManhHung
 */
public class testTreeMap {

    static class compareStudent implements Comparator<Student> {

        public int compare(Student a, Student b) {
            return a.getName().compareTo(b.getName());
        }
    }

    public static void main(String[] args) {
        // Sap xep theo nhu khi xay dung lop Student (theo code)
        Map<Student, Double> stu = new TreeMap<>(); // Student -> Diem TB
        //code, name, score 
        stu.put(new Student("A06338", "AB"), 7.5);
        stu.put(new Student("A05726-1", "AA"), 8.6);
        stu.put(new Student("A05379", "AC"), 6.5);
        stu.put(new Student("A05726-2", "AD"), 6.5);
        // System.out.println("Sorted by code" + stu);

        Student st_key1 = new Student("A06338", "AA"); // code, name, score      
        boolean kt = stu.containsKey(st_key1);//          
        if (kt) {
            System.out.println("Found key");
        } else {
            System.out.println("Not Found keye");
        }
        // Tìm kiếm điểm TB theo mã sinh sinh
        Student st_ = new Student("A06338", "");
        Double dtb = stu.get(st_);
        if (dtb != null) {
            System.out.println(dtb);
        }

        // Thay doi cach so sanh
        SortedMap<Student, Double> sortByScore; // sap xep lai theo score
        sortByScore = new TreeMap<Student, Double>(
                new Comparator<Student>() {
            public int compare(Student a, Student b) {
                return a.getName().compareTo(b.getName());
            }
        });
        sortByScore.putAll(stu);

        //  System.out.println("Sorted by score:" + sortByScore);
        System.out.println("====================");
        // Bo sung contains theo score
        kt = sortByScore.containsKey(st_key1);// tim kiem tren cay         
        if (kt) {
            System.out.println("Found key");
        } else {
            System.out.println("Not Found key");
        }

        st_ = new Student("", "AA");
        dtb = sortByScore.get(st_);
        if (dtb != null) {
            System.out.println(dtb);
        }
        sortByScore.put(new Student("A05726-123", "AA"), 8.9);

        for (Student st : sortByScore.keySet()) {
            Double dtb1 = sortByScore.get(st);
            System.out.println(st.toString() + ", " + dtb1);
        }

    }

}
/*
 SortedSet<Student> sortByScore = new TreeSet<Student> ( new Comparator<Student>()                 
 { public int compare(Student a, Student b) {   
 return a.score.compareTo(b.score);
 }
 }); // sap xep lai theo score
 sortByScore.addAll(stu);         
 System.out.println("Sorted by score:"+sortByScore);
 // Bo sung contains theo score
 kt = stu.contains(st1);// tim kiem tren cay         
 if (kt)
 System.out.println("Found by code"); 
 else
 System.out.println("Not Found by code");

 // 
 List<Student> lst=new ArrayList<Student>();  
 lst.addAll( stu);
 // Tim kiem theo dieu kien nhu khi xay dung lop Student (theo code)
 int i =Collections.binarySearch( lst, st1);
           
 if (i>=0) {System.out.print("Found by code:"+ lst.get(i) ); }
 else  System.out.println("Not Found by code");
 //// Tim kiem theo score
 i =Collections.binarySearch( lst, st1,new Comparator<Student> (){   @Override
 public int compare(Student a, Student b) {
 return a.getScore().compareTo(b.getScore());
 } });// tim theo score
           
 if (i>=0) {System.out.print("Found by score:"+ lst.get(i) ); }
 else  System.out.println("Not Found by score");
 */
