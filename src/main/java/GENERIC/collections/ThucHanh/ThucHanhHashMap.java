package GENERIC.collections.ThucHanh;

import GENERIC.collections.Employee2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ThucHanhHashMap {
    public static void main(String[] args) throws ParseException {
        HashMap<Employee2, Integer> list = new HashMap<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Employee2 employee1 = new Employee2("Tom", "Eagar", dateFormat.parse("2007-12-03"));
        Employee2 employee2 = new Employee2("Tom", "Smith", dateFormat.parse("2005-06-20"));
        Employee2 employee3 = new Employee2("Bill", "Joy", dateFormat.parse("2009-01-31"));
        Employee2 employee4 = new Employee2("Bill", "Gates", dateFormat.parse("2005-05-12"));
        Employee2 employee5 = new Employee2("Alice", "Wooden", dateFormat.parse("2009-01-22"));
        Employee2 employee6 = new Employee2("Alice", "Btest", dateFormat.parse("2007-01-22"));


        list.put(employee1, 1);
        System.out.println(list.containsKey(employee2));

        list.put(employee2, 2);
        list.put(employee3, 3);
        list.put(employee4, 4);
        list.put(employee5, 5);
        list.put(employee6, 6);

        //Check contain
        //override hashcode and equals for contain working
        System.out.println("Check contain key: ");
        System.out.println(list.containsKey(new Employee2("Alice", "Btest", dateFormat.parse("2007-01-22"))));


        //Check hàm put method
        //Key đã contain thì sẽ bị ghi đè value
        System.out.println("Ham put: ");
        Employee2 employee7 = new Employee2("Alice", "Btest", dateFormat.parse("2007-01-22"));
        list.put(employee7, 7);
        for(Employee2 em: list.keySet()){
            System.out.println(em + ". Value: " + list.get(em));
        }


    }
}
