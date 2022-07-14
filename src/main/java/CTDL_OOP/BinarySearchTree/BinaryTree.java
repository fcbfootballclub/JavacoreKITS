package CTDL_OOP.BinarySearchTree;

public class BinaryTree {
    Node root;

    public boolean isEmpty(){
        return root == null;
    }
    public void insert(int data){
        Node newNode = new Node(data);

        if(isEmpty()){
            root = newNode;
            return;
        }

        Node findNode = root;
        Node parentNode = root;
        while(findNode != null){
            if(findNode.data == data) {
                System.out.println(data + " da ton tai!");
            }
            parentNode = findNode;
            if(findNode.data > data) {
                findNode = findNode.left;
            } else {
                findNode = findNode.right;
            }
        }
        //ket thuc vong while
        if(parentNode.data > data) {
            parentNode.left = newNode;
        } else {
            parentNode.right = newNode;
        }
    }

    //Nut trái cùng của bên phải
    public Node nodeTraiCung(Node root){
        if(root != null) {
            if(root.left == null) {
                return root;
            } else {
                return nodeTraiCung(root.left);
            }
        }
        return null;
    }



    //xoa mot Tree node
    public void deleteData(int a){
        if(root == null) return;
        if(root.left == null && root.right == null){
            root = null;
        }

        Node findNode = root;
        Node parentNode = null;
        boolean found = false;
        while(findNode != null){
            if(findNode.data == a){
                found = true;
                break;
            }
            parentNode = findNode;
            if(findNode.data > a) {
                findNode = findNode.left;
            } else {
                findNode = findNode.right;
            }
        }

        if(found){
            if(findNode.left == null && findNode.right == null){
                if(parentNode.data > a){
                    parentNode.left = null;
                } else {
                    parentNode.right = null;
                }
            }

            if(findNode.right != null && findNode.left == null){
                parentNode.right = findNode.right;
            }
            if(findNode.left != null && findNode.right == null){
                parentNode.left = findNode.left;
            }
            else {
                try{
                    Node minNode = nodeTraiCung(findNode.right); //khi gọi câu lệnh xóa node thì lệnh này bị lỗi
                    System.out.println();
//                System.out.println("min node data la: " + minNode.data);
                    deleteData(minNode.data);
                    findNode.data = minNode.data;
                } catch (Exception e){
                    System.out.println("Da xoa min node");
                }
            }
        }
        else {
            System.out.println();
            System.out.println(a + " khong tim thay note de xoa!");
        }

    }


    public void printTree(Node node){
        if(node == null){
            return;
        }
        printTree(node.left);
        System.out.print(node.data + " ");
        printTree(node.right);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(8);
        binaryTree.insert(3);
        binaryTree.insert(10);
        binaryTree.insert(12);
        binaryTree.insert(1);
        binaryTree.insert(4);
        binaryTree.insert(0);
        binaryTree.insert(2);
        binaryTree.printTree(binaryTree.root);
//        binaryTree.deleteData(10);
        binaryTree.deleteData(3);
        System.out.println();
        binaryTree.printTree(binaryTree.root);
        binaryTree.deleteData(1);
        binaryTree.printTree(binaryTree.root);


    }
}
