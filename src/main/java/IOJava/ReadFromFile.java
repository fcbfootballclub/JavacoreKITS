
package IOJava;
 
import java.text.*;
import java.io.*;
public class ReadFromFile {
    public static void main(String[] args) {     
        String inputFile = "C:\\Users\\MULTICAMPUSPC\\Desktop\\KITS java core\\Buoi1\\src\\main\\java\\IOJava\\test.txt";
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy"); 
        try {
                ObjectInputStream objectInput
                    = new ObjectInputStream(new FileInputStream(inputFile));          
            while (true) {
                Student student = (Student) objectInput.readObject(); 
                
                System.out.print(student.getName() + "\t");
                System.out.print(dateFormat.format(student.getBirthday()) + "\t");
                System.out.print(student.getGender() + "\t");
                System.out.print(student.getAge() + "\t");
                System.out.println(student.getGrade());
            } 
        } catch (EOFException eof) {
            System.out.println("Reached end of file");
        } catch (IOException ignored){}
        catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
 
}
