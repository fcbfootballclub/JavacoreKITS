package CTDL_OOP.BinarySearchTree;

public class BinaryTree {
    Node root;

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            root = newNode;
            return;
        }

        Node findNode = root;
        Node parentNode = root;
        while (findNode != null) {
            if (findNode.data == data) {
                System.out.println(data + " da ton tai!");
            }
            parentNode = findNode;
            if (findNode.data > data) {
                findNode = findNode.left;
            } else {
                findNode = findNode.right;
            }
        }
        //ket thuc vong while
        if (parentNode.data > data) {
            parentNode.left = newNode;
        } else {
            parentNode.right = newNode;
        }
    }

    //Nut trái cùng của bên phải
    public Node nodeTraiCung(Node root) {
        if (root != null) {
            if (root.left == null) {
                return root;
            } else {
                return nodeTraiCung(root.left);
            }
        }
        return null;
    }

    //Xóa không đệ quy (xóa giá trị x)
    //1. Tìm nút chứa x
    //1.1 nút chứa x là nút lá: Đặt tham chiếu từ node cha của x = null
    //1.2 nút chứa x chỉ có một con khác null: Đặt tham chiếu từ node cha của x đến node con của x
    Node findNode(int x) {
        Node node = root;
        while (node != null && node.data != x) {
            if (node.data > x) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node; //node = null khi list rong hoac khoong tim  thay x
    }

    boolean delete(int x) {
        Node parent = null;
        Node node = root;
        while (node != null && node.data != x) {
            parent = node;
            if (node.data > x) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        if (node == null) return false;
        //xóa node có ít nhất 1 con
        if (node.left == null || node.right == null) { //case 1 va 2
            if (parent == null) {
                if (root.right == null) {
                    root = root.left;
                } else {
                    root = root.right;
                }
                return true;
            }
            if (parent.data < x) {
                if (node.left == null) {
                    parent.right = node.right;
                } else {
                    parent.right = node.left;
                }
            } else {
                if (node.left == null) {
                    parent.left = node.right;
                } else {
                    parent.left = node.left;
                }
            }

            //xóa node có 2 con
        } else {
            //bai tap ve nha
            Node traicung = node.right;
            Node parentTraiCung = null;
            while(traicung.left != null){
                parentTraiCung = traicung;
                traicung = traicung.left;
            }

            node.data = traicung.data;
            if (parentTraiCung == null) {
                node.right = traicung.right;
            }
            else  {
                parentTraiCung.left = traicung.right;
            }
            System.out.println();
            System.out.println("node trai cung: " + traicung.data);
//            System.out.println("Parent node trai cung: " + parentTraiCung.data);
        }
        return true;
    }


    //xoa mot Tree node
    public void deleteData(int a) {
        if (root == null) return;
        if (root.left == null && root.right == null && root.data == a) {
            root = null;
            return;
        }

        Node findNode = root;
        Node parentNode = null;
        boolean found = false;
        while (findNode != null) {
            if (findNode.data == a) {
                found = true;
                break;
            }
            parentNode = findNode;
            if (findNode.data > a) {
                findNode = findNode.left;
            } else {
                findNode = findNode.right;
            }
        }

        if(found && parentNode == null) {
            if(root.left == null){
                root = root.right;
            }
            else if(root.right == null){
                root = root.left;
            }
            else {
                Node minNode = nodeTraiCung(root.right);
                delete(minNode.data);
                root.data = minNode.data;
            }
            return;
        }

        if (found) {
            if (findNode.left == null && findNode.right == null) {
                if (parentNode.data > a) {
                    parentNode.left = null;
                } else {
                    parentNode.right = null;
                }
            }
            else if (findNode.right != null && findNode.left == null) {
                if (parentNode.right == findNode) {
                    parentNode.right = findNode.right;
                } else {
                    parentNode.left = findNode.right;
                }
            }
            else if (findNode.right == null) {
                if (parentNode.left == findNode) {
                    parentNode.left = findNode.left;
                } else {
                    parentNode.right = findNode.left;
                }
            } else {
                Node minNode = nodeTraiCung(findNode.right);
                System.out.println();
                System.out.println("min node data la: " + minNode.data);
                deleteData(minNode.data);
                findNode.data = minNode.data;
            }
        } else {
            System.out.println();
            System.out.println(a + " khong tim thay node de xoa!");
        }

    }


    public void printTree(Node node) {
        if (node == null) {
            return;
        }
        printTree(node.left);
        System.out.print(node.data + " ");
        printTree(node.right);
    }

//    public static void main(String[] args) {
//        BinaryTree binaryTree = new BinaryTree();
//        binaryTree.insert(15);
//        binaryTree.insert(20);
//        binaryTree.insert(10);
//        binaryTree.insert(40);
//        binaryTree.insert(30);
//        binaryTree.insert(35);
//        binaryTree.insert(32);
//        binaryTree.insert(37);
//        binaryTree.printTree(binaryTree.root);
//        binaryTree.deleteData(10);
//        binaryTree.deleteData(30);
//        System.out.println();
//        System.out.println();
//        binaryTree.printTree(binaryTree.root);
//        System.out.println();
//        System.out.println(binaryTree.root.data);

//    }
}
