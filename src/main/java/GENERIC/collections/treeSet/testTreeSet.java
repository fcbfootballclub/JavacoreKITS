package collections.treeSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author ManhHung
 */
public class testTreeSet {

    static class compareStudent implements Comparator<Student> {

        public int compare(Student a, Student b) {
            return a.score.compareTo(b.score);
        }
    }
   
    public static void main(String[] args) {
        // Sap xep theo nhu khi xay dung lop Student (theo code)
        Set<Student> stu = new TreeSet<>();
        //code, name, score 
        stu.add(new Student("A06338", "AB", 7));
        stu.add(new Student("A05726-1", "AA", 8));
        stu.add(new Student("A05379", "AC", 6));
        stu.add(new Student("A05726-2", "AD", 9));
        System.out.println("Sorted by code" + stu);

        Student st1 = new Student("A063381", "AA", 6); // code, name, score      
        boolean kt = stu.contains(st1);// tim kiem tren cay         
        if (kt) {
            System.out.println("Found by code");
        } else {
            System.out.println("Not Found by code");
        }

// Thay doi cach so sanh
        SortedSet<Student> sortByScore = new TreeSet<Student>(
                new Comparator<Student>() {
                    public int compare(Student a, Student b) {
                        return a.score.compareTo(b.score);
                    }
                }); // sap xep lai theo score
        sortByScore.addAll(stu);
        System.out.println("Sorted by score:" + sortByScore);
        // Bo sung contains theo score
        kt = sortByScore.contains(st1);// tim kiem tren cay         
        if (kt) {
            System.out.println("Found by score");
        } else {
            System.out.println("Not Found by score");
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
