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
public class HashMap_HashCode {

    static class Employee {

        int id;
        String name;

        Employee(int id, String name) {
            this.name = name;
            this.id = id;
        }

        @Override
        public int hashCode() {
            return this.id;
        }

    }

    public static void main(String[] args) {
        Employee g1 = new Employee(1,"aditya" );
        Employee g2 = new Employee(1, "aditya" );
        

        Map<Employee, String> map = new HashMap<Employee, String>();
        map.put(g1, "CSE");
        map.put(g2, "IT");

        for (Employee geek : map.keySet()) {
            System.out.println(map.get(geek).toString());
        }

    }
}
