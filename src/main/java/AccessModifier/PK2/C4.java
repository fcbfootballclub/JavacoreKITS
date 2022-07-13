package AccessModifier.PK2;

import AccessModifier.PK1.C1;

public class C4 extends C1 {

    public static void main(String[] args) {
        C4 c4 = new C4();
        System.out.println(c4.x);
        System.out.println(c4.y);
//        System.out.println(c4.z); //khong the access
//        System.out.println(c4.u); //khong the access

        c4.m();


        //PROTECTED có thể truy cập từ các subclass
        //protected chi trong mot package

    }
}
