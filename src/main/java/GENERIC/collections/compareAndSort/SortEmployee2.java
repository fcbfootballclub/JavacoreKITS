/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.compareAndSort;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Hung
 */
class EmployeeComparator implements Comparator<Employee2> { 
    public int compare(Employee2 emp1, Employee2 emp2) {
        return emp1.getJoinDate().compareTo(emp2.getJoinDate());
    }
}

public class SortEmployee2 {

    public static void main(String[] args) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<Employee2> listEmployees = new ArrayList<>();
        Employee2 employee1 = new Employee2("Tom", "Eagar", dateFormat.parse("2007-12-03"));
        Employee2 employee2 = new Employee2("Tom", "Smith", dateFormat.parse("2005-06-20"));
        Employee2 employee3 = new Employee2("Bill", "Joy", dateFormat.parse("2009-01-31"));
        Employee2 employee4 = new Employee2("Bill", "Gates", dateFormat.parse("2005-05-12"));
        Employee2 employee5 = new Employee2("Alice", "Wooden", dateFormat.parse("2009-01-22"));
        
        
        listEmployees.add(employee1);
        listEmployees.add(employee2);
        listEmployees.add(employee3);
        listEmployees.add(employee4);
        listEmployees.add(employee5);
        System.out.println("Before sorting: ");
        System.out.println(listEmployees);
        // Sort 1
        Collections.sort(listEmployees);  //      
        System.out.println("After sorting1: ");
        System.out.println(listEmployees);
        
         Employee2 employee = new Employee2("Bill", "Joy" , dateFormat.parse("2009-01-31")); 
         int i= Collections.binarySearch(listEmployees, employee);
         if (i>=0) {
            System.out.println("Tìm thấy "+employee.toString()+"   ở vị trí:"+i);
        } else System.out.println("Không tìm thấy "+ employee.toString());
        
          
         
        //Collections.sort(listEmployees, 
        //        (emp1, emp2) -> emp1.getJoinDate().compareTo(emp2.getJoinDate()));
       //overloading sort
      
       // Sort 2
        Collections.sort(listEmployees , new EmployeeComparator());  
        System.out.println("After sorting2: ");
        System.out.println(listEmployees);
        // Cách làm ko đúng
        i= Collections.binarySearch(listEmployees, employee);
         if (i>=0) {
            System.out.println("Tìm thấy "+employee.toString()+"   ở vị trí:"+i);
        } else System.out.println("Không tìm thấy "+ employee.toString());
        
         // overloading binarySearch
        i= Collections.binarySearch(listEmployees, employee
                                 , new EmployeeComparator());
        if (i>=0) {
            System.out.println("Tìm thấy "+employee.toString()+"   ở vị trí:"+i);
            
        } else System.out.println("Không tìm thấy "+ employee.toString());
    }
}
