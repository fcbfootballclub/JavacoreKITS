package CTDL_OOP;

import DataStructure.Stack;

public class StackLinkedList extends SingleLinkedList{
    int top = -1;

    //Push element into stack
    public void push(int data){
        super.addFront(data);
        top++;
    }

    //remove element from stack
    public int pop(){
        if(top != -1) {
            int popData = super.deleteHead();
            top--;
            return popData;
        }
        return -1;
    }

    //peek element
    public int peek(){
        if(!isEmpty()) {
            return head.data;
        }
        else return -1;
    }




    public static void main(String[] args) {
        StackLinkedList stackLinkedList = new StackLinkedList();
        stackLinkedList.push(1);
        stackLinkedList.push(2);
        stackLinkedList.push(3);
        stackLinkedList.display();
        System.out.println("Pop test: " + stackLinkedList.pop());
        System.out.println("Peek test: " + stackLinkedList.peek());
        stackLinkedList.display();
    }
}
