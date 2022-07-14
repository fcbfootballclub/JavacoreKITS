package TryCatch.Chaining;

public class StudentManager {
    private StudentDAO dao;

    public StudentManager(StudentDAO dao) {
        this.dao = dao;
    }

    public void findStudents(String keyword) throws StudentExeption{
        try {
            dao.list();
        } catch (DAOExeption e) {
            throw new StudentExeption("Error finding students", e);
        }
    }
}
