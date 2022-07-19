package GENERIC.collections.ThucHanh;

import GENERIC.collections.Employee2;

import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TreeMap;

public class ThucHanhTreeMap {
    public static void main(String[] args) throws ParseException {
        TreeMap<Employee2, Integer> list = new TreeMap<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Employee2 employee1 = new Employee2("Tom", "Eagar", dateFormat.parse("2007-12-03"));
        Employee2 employee2 = new Employee2("Tom", "Smith", dateFormat.parse("2005-06-20"));
        Employee2 employee3 = new Employee2("Bill", "Joy", dateFormat.parse("2009-01-31"));
        Employee2 employee4 = new Employee2("Bill", "Gates", dateFormat.parse("2005-05-12"));
        Employee2 employee5 = new Employee2("Alice", "Wooden", dateFormat.parse("2009-01-22"));
        Employee2 employee6 = new Employee2("Alice", "Btest", dateFormat.parse("2007-01-22"));

        list.put(employee1, 1);
        list.put(employee2, 2);
        list.put(employee3, 3);
        list.put(employee4, 4);
        list.put(employee5, 5);
        list.put(employee6, 6);

        //contain key
        //check hashcode và equals
        System.out.println("Check contain key: ");
        Employee2 employee7 = new Employee2("Alice", "Btest", dateFormat.parse("2007-01-22"));
        System.out.println(list.containsKey(employee7));

        //put object into list
        // key đã tồn tại nên ghi đè value
        System.out.println("Test put object: ");
        list.put(employee7, 7);
        for(Employee2 em : list.keySet()){
            System.out.println(em + ". Value: " + list.get(em));
        }


    }
}
