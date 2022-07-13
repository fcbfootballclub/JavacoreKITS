package CTDL_OOP;

public class QueueLinkedList extends StackLinkedList{
    int front = -1;
    int rear = -1;


    //push data into queue
    public void push(int data){
        if (isEmpty()) {
            front++;
        }
        rear++;
        super.addFront(data);
    }

    //pop data from queue
    public int pop(){
        int data = -1;
        if(!isEmpty()){
            if(front == rear) {
                data = head.data;
                front --;
                rear--;
                return data;
            } else {
                data =super.deleteRear2();
                rear--;
            }
        } else {
            System.out.println("Empty list!");
        }
        return data;
    }

    //peek
    public int peek(){
        if(!isEmpty()){
            Element element = this.head;
            while (element.next != null) {
                element = element.next;
            }
            return element.data;
        }
        else {
            System.out.println("Empty list!");
            return -1;
        }
    }

    public static void main(String[] args) {
        QueueLinkedList queueLinkedList = new QueueLinkedList();
        queueLinkedList.push(1);
        queueLinkedList.push(2);
        queueLinkedList.push(3);
        queueLinkedList.push(4);
        queueLinkedList.push(5);
        queueLinkedList.display();
        System.out.println(queueLinkedList.front);
        System.out.println(queueLinkedList.rear);
        System.out.println("----------");
        System.out.println("pop :" + queueLinkedList.pop());
        queueLinkedList.display();
        System.out.println("pop :" + queueLinkedList.pop());
        queueLinkedList.display();
        System.out.println(queueLinkedList.front);
        System.out.println(queueLinkedList.rear);
        System.out.println("peek: " + queueLinkedList.peek());
    }

}
