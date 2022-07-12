package Javabasic.NameReverse;

public class Songuyento {
    public static void main(String[] args) {

        isPrime(5);
    }

    public static boolean isPrime(int x) {
        if(x < 2) {
            System.out.println(x + " khong phai la so nguyen to!");
            return false;
        }
        else {
            int count = 0;
            for(int i = 1; i <= Math.sqrt(x); i++) {
                if(x % i == 0) {
                    count++;
                }
                if(count > 1) {
                    System.out.println(x + " khong phai la so nguyen to!");
                    return false;
                }
            }
            if(count == 1) {
                System.out.println(x + " la so nguyen to");
                return true;
            }
        }
        return true;
    }
}
