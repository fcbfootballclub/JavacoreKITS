/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.hashMap;
import java.util.HashMap;
import java.util.Map; 
/**
 *
 * @author Hung
 */ 
// Driver code
public class HashMap_HashCodeAndEquals { 
   static class Employee{
     String name;
     int id; 
    Employee(String name, int id) {

        this.name = name;
        this.id = id;
    } 
    @Override
    public boolean equals(Object obj) {  
        if (this == obj) {
            return true;
        } 
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }  
        Employee geek = (Employee) obj; 
        return (geek.name.equals(this.name) && geek.id == this.id);
    } 
    @Override
    public int hashCode() { 
        return this.id;
    } 
}

    public static void main(String[] args) {  
        Employee g1 = new Employee("aditya", 1);
        Employee g2 = new Employee("aditya", 1);

        Map<Employee, String> map = new HashMap<Employee, String>();
        map.put(g1, "CSE"); //
        map.put(g2, "IT"); // Ghi đè
        
        for (Employee geek : map.keySet()) {
            System.out.println(map.get(geek).toString());
        }

    }
}
