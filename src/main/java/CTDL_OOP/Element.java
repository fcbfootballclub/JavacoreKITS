package CTDL_OOP;

public class Element {
    int data;
    Element next; //kieu tham chieu den phan tu tiep theo

    public Element(int x) {
        this.data = x;
        this.next = null;
    }

    public Element(int x, Element next) {
        this.data = x;
        this.next = next;
    }

}
