package IOJava;
import java.util.Date;
import java.io.Serializable;
public class Student implements Serializable  {//
    private String name;
    private Date birthday;
    private boolean gender; // true is male, false is female
    private int age;
    private float grade; 
    
    public Student() {    } 
    
    public Student(String name, Date birthday,
            boolean gender, int age, float grade) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.age = age;
        this.grade = grade;
    } 
    
    public String getName() {
        return this.name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public Date getBirthday() {
        return this.birthday;
    }
 
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
 
    public boolean getGender() {
        return this.gender;
    }
 
    public void setGender(boolean gender) {
        this.gender = gender;
    }
 
    public int getAge() {
        return this.age;
    }
 
    public void setAge(int age) {
        this.age = age;
    }
 
    public float getGrade() {
        return this.grade;
    }
 
    public void setGrade(float grade) {
        this.grade = grade;
    }

    
}
    

