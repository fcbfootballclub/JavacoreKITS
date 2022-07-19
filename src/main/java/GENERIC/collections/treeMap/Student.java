package collections.treeMap; 

class Student  implements Comparable<Student> 
{ 
    public String code;
    private String name; 
    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

     

    public Student(String code, String name ) {
        this.code = code; 
        this.name = name;
    }

     

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "(Ma SV: " + code + ", Ho ten:" + name +  ")";
    }
 
    public int compareTo(Student other) {
        return code.compareTo(other.code);
    }

}
