package AccessModifier.PK1;

public class C2 {
    public static void main(String[] args) {
        C1 c1 = new C1();
        System.out.println(c1.x);
        System.out.println(c1.y);
        System.out.println(c1.z);
//        System.out.println(c1.u);
        c1.m();
    }
}
