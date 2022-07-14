package TryCatch;

public class Exeption01 {
    public static void main(String[] args) {
        float x;
        try{
            System.out.println("1.1 Test cau lenh 1");
            x = 1/0;
            System.out.println("1.2 test cay lenh 2");
        } catch(Exception e) {
            System.out.println("2 Cau lenh catch");
        } finally {
            System.out.println("3. Cau lenh finally");
        }
    }


}
