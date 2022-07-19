package GENERIC.collections.BTVN;

import java.util.Date;
import java.util.Objects;

public class Person implements Comparable<Person>{
    private int id;
    private String name;
    private String address;
    private String phone;
    private Date birthDay;

    public Person(int id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return this.id - o.id;
    }


    @Override
    public boolean equals(Object obj) {
        return ((Person) obj).getName().equals(this.name) && ((Person) obj).getPhone().equals(this.phone);
    }

    public int hashCode() {
        return this.id;
    }

}
