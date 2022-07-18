package CTDL_OOP.BinarySearchTree;

public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(15);
        binaryTree.insert(20);
        binaryTree.insert(10);
        binaryTree.insert(40);
        binaryTree.insert(30);
        binaryTree.insert(35);
        binaryTree.insert(32);
        binaryTree.insert(37);
        binaryTree.insert(17);
        binaryTree.printTree(binaryTree.root);
        binaryTree.delete(10);
        binaryTree.delete(30);
        binaryTree.delete(20);
        binaryTree.delete(35);
//        binaryTree.delete(15);
        System.out.println();
        System.out.println();
        binaryTree.printTree(binaryTree.root);
        System.out.println();
        System.out.println(binaryTree.root.data);

    }
}
