package TryCatch.Chaining;

public class StudentProgram {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        StudentManager studentManager = new StudentManager(dao);
        try {
            studentManager.findStudents("Tom");
        } catch (StudentExeption e) {
            e.printStackTrace();
        }
    }
}
