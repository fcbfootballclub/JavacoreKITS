package GENERIC.collections.BTVN;

import java.util.TreeMap;

public class App {
    public static void main(String[] args) {
        TreeMap<Person, Double> list = new TreeMap<>();

        Person person1 = new Person(1, "Henry1", "HN", "0901");
        Person person2 = new Person(2, "Henry2", "HN", "0902");
        Person person3 = new Person(3, "Henry3", "HN", "0903");
        Person person4 = new Person(4, "Henry4", "HN", "0904");
        Person person5 = new Person(5, "Henry5", "HN", "0905");
        list.put(person1, 10.02);
        list.put(person2, 3.02);
        list.put(person3, 40.02);
        list.put(person4, 50.02);
        list.put(person5, 50.09);
        //check người gửi tiền đã có trong list chưa
        System.out.println("Check bạn Henry5 đã có trong list: ");
        Person person6 = new Person(5, "Henry5", "HN", "0905");

        System.out.println(list.containsKey(person6));
        if(list.containsKey(person6)){
            list.put(person6, list.get(person6) + 100);
        } else {
            list.put(person6, 100.00);
        }

        for(Person x : list.keySet()){
            System.out.println(x.toString() + ". Tien gui: " + list.get(x));
        }

    }
}
