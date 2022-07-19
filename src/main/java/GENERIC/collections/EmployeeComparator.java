package GENERIC.collections;
import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee2> {
    @Override
    public int compare(Employee2 o1, Employee2 o2) {
        return o1.getJoinDate().compareTo(o2.getJoinDate());
    }
}
