package IOJava.BTVN.bai3;
import java.io.*;
import java.util.Arrays;

public class Bai3 {
    Student[] list = new Student[10];
    int count = 0; //dem so student,

    void readStudentFromFile(File file){
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String[] contentLine = new String[10];
            String line = null;
            while((line = bufferedReader.readLine()) != null){
                contentLine[count] = line;
                System.out.println("Line " + count + ": " + contentLine[count]);
                //luu mot line vao object
                String[] splitContentLine = contentLine[count].split(",");
                //
                int id = Integer.parseInt(splitContentLine[0]);
                String name = splitContentLine[1];
                String address = splitContentLine[2];
                int birthYear = Integer.parseInt(splitContentLine[3]);
                float mark = Float.parseFloat(splitContentLine[4]);
                Student student = new Student(id, name, address, birthYear, mark);

                //luu student vao list
                list[count] = student;
                count++;
            }
            sapXepListStudent(list, count);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Object output stream
    void writeObjectStudent(File file){
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(dataOutputStream);
            objectOutputStream.writeObject(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //object input stream
    void readOjectStudent(File file){
        try {
            System.out.println("Read Object Method");
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            ObjectInputStream objectInputStream = new ObjectInputStream(dataInputStream);
            Student[] studentList2 = (Student[]) objectInputStream.readObject();
            for(int i = 0; i < count; i++){
                System.out.println(studentList2[i]);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    //Sap xep chen list student
    void sapXepListStudent(Student[] list, int count){
            for(int i = 0; i < count -1; i++){
                Student temp = list[i + 1];
                int pos = i + 1;
                for(int j = i + 1; j > 0; j--){
                    if(temp.getBirthYear() < list[j - 1].getBirthYear()){
                        list[j] = list[ j - 1];
                        pos--;
                    } else {
                        break;
                    }
                }
                if(pos != i){
                    list[pos] = temp;
                }
            }
            for(int i = 0; i < count; i++){
                System.out.println(list[i]);
            }
    }



    public static void main(String[] args) {
        //file de doc du lieu
        File file = new File("src/main/java/IOJava/BTVN/bai3/Student.txt");
        Bai3 bai3 = new Bai3();
        bai3.readStudentFromFile(file);

        //file de ghi du lieu
        File writeFile = new File("src/main/java/IOJava/BTVN/bai3/WriteFile");
        bai3.writeObjectStudent(writeFile);

        //doc du lieu tu file
        bai3.readOjectStudent(writeFile);

    }
}
