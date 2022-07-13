package CTDL_OOP;

import java.util.Currency;

public class SingleLinkedList {
    Element head;
    int len;
    public SingleLinkedList() {
        head = null;
    }

    //check length single linked list
    public int len(){
        int count = 0;
        if(!isEmpty()) {
            Element current = head;
            count = 1;
            while(current.next != null){
                current = current.next;
                count++;
            }
        } else {
            System.out.println("empty list!");
        }
//        System.out.println("Len element: " + count);

        return count;
    }


    //check empty
    public boolean isEmpty() {
        return head == null;
    }

    //insert gia tri x vao dang truoc nut
    public void addFront(int x){
        Element element = new Element(x);
        if(isEmpty()) {
            head = element;
        } else {
            element.next = head;
            this.head = element;
        }
    }

    //insert rear
    public void addRear(int x) {
        Element element = new Element(x);
        if (isEmpty()){
            head = element;
        } else {
            Element current = head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = element;
        }
    }

    //public void add middle
    public void addMiddle(int index, int data) {

    }

    //in ra phan tu cuoi cung
    public void lastElement(){
        if(!isEmpty()){
            Element current = head;
            while(current.next != null){
                current = current.next;
            }
            System.out.println("Last data is: " + current.data);
        }
    }


    //delete phan tu dau tien
    public int deleteHead() {
        if(!isEmpty()){
            int deleteNumber = head.data;
            head = head.next;
            return deleteNumber;
        } else {
            System.out.println("Empty list!");
        }
        return -1;
    }

    //delete phan tu cuoi cung
    public int deleteRear(){
        len = len();
        if(!isEmpty()) {
            int count = 1;
            if(len == 1) {
                head = null;
            }
            else {
                Element current = head;
                while(current.next != null){
                    count++;
                    if(count == len) {
                        int deleteNumber = current.next.data;
                        current.next = null;
                        return deleteNumber;
                    }
                    current = current.next;
                }
            }

        } else {
            System.out.println("empty list!");
        }
        return -1;
    }

    public int deleteAfter2(){
        int data = -1;
        if(!isEmpty()){
            if(head.next == null){
                data = head.data;
                head = null;
            } else {
                Element current = this.head;
            }
        }
        return data;
    }

    //in ra single linkedlist
    public void display(){
        Element current = head;
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    boolean Ktra() {
        if(!isEmpty()) {
            int temp;
            Element current = head;
            if(head.next == null) {
                return true;
            } else {
                while(current.next != null) {
                    temp = current.data;
                    current = current.next;
                    if(temp < current.data){
                        return false;
                    }
                }
            }
        }
        return true;
    }



    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //chen vao va lay ra hoac xoa
//        singleLinkedList.addFront(1);
        singleLinkedList.addFront(12);
        singleLinkedList.addFront(10);
        singleLinkedList.addRear(9);
        singleLinkedList.addRear(20);
        singleLinkedList.addRear(30);
        singleLinkedList.addRear(40);
        singleLinkedList.display();
        singleLinkedList.lastElement();

        System.out.println("---------");
//        singleLinkedList.deleteHead();
        singleLinkedList.display();
        singleLinkedList.len();

        System.out.println("---------");
        System.out.println(singleLinkedList.len());
        System.out.println(singleLinkedList.deleteHead());
        System.out.println(singleLinkedList.deleteRear());
        System.out.println(singleLinkedList.len());
        singleLinkedList.display();


        System.out.println(singleLinkedList.Ktra());

        if(singleLinkedList.Ktra()){
            singleLinkedList.display();
        }


    }
}
