package CTDL_OOP.DoubleLinkedList;

public class DoubleLinkedList {
    Node head;
    Node rear;
    int data;

    public boolean isEmpty(){
        return head == null;
    }

    public int length(){
        int len = 0;
        if(!isEmpty()){
            Node current = head;
            while(current != null){
                len++;
                current = current.next;
            }
        }
        return len;
    }

    //insert to head
    public void insertHead(int data){
        Node newNode = new Node(data);
        if(isEmpty()) {
            head = newNode;
            rear = newNode;
            return;
        }
        //head hiện tại liên kết với new node
        newNode.next = head;
        head.previous = newNode;
        //gan head bang node moi
        head = newNode;
    }

    //insert from rear
    public void insertRear(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            head = newNode;
            rear = newNode;
            return;
        }
        //lien ket rear va node moi
        rear.next = newNode;
        newNode.previous = rear;
        // gan rear bang node moi
        rear = newNode;
    }


    public void display(){
        if (!isEmpty()){
            Node current = head;
            while(current != null){
                System.out.print(current.data + " ");
                current = current.next;
            }
        }
        System.out.println();
    }

    public void displayFromRear(){
        if(!isEmpty()){
            Node current = rear;
            while(current != null){
                System.out.print(current.data + " ");
                current = current.previous;
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        DoubleLinkedList demo = new DoubleLinkedList();
        demo.insertHead(10);
        demo.insertHead(20);
        demo.insertHead(30);
        demo.insertRear(40);
        demo.insertRear(50);
        demo.display();
        demo.displayFromRear();
        System.out.println(demo.length());
    }


}
