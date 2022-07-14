package TryCatch.Chaining;

public class StudentExeption extends Exception{
    public StudentExeption(String message) {
        super(message);
    }

    public StudentExeption(String message, Throwable cause) {
        super(message, cause);
    }
}
