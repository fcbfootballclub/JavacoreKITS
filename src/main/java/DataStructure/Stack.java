package DataStructure;

public class Stack {
    int count = -1;
    int[] StackDemo = new int[5];

    //push data
    public void push(int data) {
        if(count == -1) {
            StackDemo[++count] = data;
        }
        else if(count < 4) {
            StackDemo[++count] = data;
        }
        else {
            System.out.println("Full slot!");
        }
    }

    //pop data
    public int pop() {
        if(count != -1){
            int number = StackDemo[count];
            count--;
            return number;
        }
        else {
            System.out.println("Empty list");
            return -1;
        }
    }

    //display
    public void display() {
        if(count != -1) {
            System.out.println();
            for(int i = 0; i < count; i++){
                System.out.print(StackDemo[i] + ", ");
            }
            System.out.print(StackDemo[count]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Stack demoStack = new Stack();
        demoStack.push(1);
        demoStack.push(2);
        demoStack.push(3);
        demoStack.push(4);
        demoStack.push(5);
        demoStack.push(5);
        demoStack.display();
        System.out.println(demoStack.pop());
        demoStack.display();
    }

}
