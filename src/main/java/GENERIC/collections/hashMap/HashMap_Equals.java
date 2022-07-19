 
package collections.hashMap; 
import java.util.HashMap;
import java.util.Map; 
public class HashMap_Equals { 
   static class Employee { 
        String name;
        int id; 
      public  Employee(String name, int id) {
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
    }

    public static void main(String[] args) { 
        Employee g1 = new Employee("aditya", 1); // key1
        Employee g2 = new Employee("aditya", 1); // key2
        
        Map<Employee, String> map = new HashMap<Employee, String>();
        
        map.put(g1, "CSE");//
        map.put(g2, "IT"); //
        
        for (Employee geek : map.keySet()) {
            System.out.println(map.get(geek).toString());
        }

    }
}
