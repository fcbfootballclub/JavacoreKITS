package DataStructure;

public class QueueDemo {
    int front = -1;
    int rear = -1;
    int[] queue = new int[5];


    //enqueue
    public void enqueue(int data){
        if(front == -1) {
            queue[0] = data;
            front = rear = 0;
        }
        else if(rear < 4) {
            queue[++rear] = data;
        } else {
            System.out.println("Full slot!");
        }
    }


    //dequeue
    public int dequeue(){
        if(front != -1) {
            int number = queue[0];
            for(int i = 0; i < rear; i++) {
                queue[i] = queue[i +1];
            }
            rear--;
            return number;
        }
        else {
            System.out.println("Queue empty!");
            return -1;
        }
    }

    //display list
    public void display(){
        System.out.println();
        for(int i = 0; i < rear; i++) {
            System.out.print(queue[i] + ", ");
        }
        System.out.println(queue[rear] + ".");
    }

    public static void main(String[] args) {
        QueueDemo queueDemo = new QueueDemo();
        queueDemo.enqueue(1);
        queueDemo.enqueue(2);
        queueDemo.enqueue(3);
        queueDemo.enqueue(4);
        queueDemo.enqueue(5);
        queueDemo.display();

        queueDemo.enqueue(6);
        queueDemo.display();
        System.out.println(queueDemo.dequeue());
        System.out.println(queueDemo.dequeue());
        queueDemo.display();
    }
}
