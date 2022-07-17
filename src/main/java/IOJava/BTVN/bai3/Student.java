package IOJava.BTVN.bai3;


import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;
    private String address;

    private int birthYear;
    private float mark;

    public Student(int id, String name, String address, int birthYear, float mark) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.birthYear = birthYear;
        this.mark = mark;
    }

    public Student() {
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

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", birthYear=" + birthYear +
                ", mark=" + mark +
                '}';
    }
}
