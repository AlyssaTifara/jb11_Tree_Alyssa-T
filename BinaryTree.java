public class BinaryTree{
    Node root;
    int size;

    public BinaryTree(){
        root = null;
    }
    
    boolean isEmpty(){
        return root == null;
    }

    void add(int data){
        if (isEmpty()) {
            root = new Node(data);
        } else {
            Node current = root;
            while (true) {
                if (data<current.data) {
                    if (current.left!=null) {
                        current = current.left;
                    } else {
                        current.left = new Node(data);
                        break;
                    }
                } else if (data>current.data){
                    if (current.right!=null) {
                        current = current.right;
                    } else {
                        current.right = new Node(data);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    boolean find (int data){
        boolean hasil = false;
        Node current = root;
        while (current!=null) {
            if (current.data == data) {
                hasil = true;
                break;
            } else if (data<current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return hasil;
    }

    void traversePre0rder(Node node){
        if (node != null) {
            System.out.print(" " + node.data);
            traversePre0rder(node.left);
            traversePre0rder(node.right);
        }
    }

    void traversePost0rder(Node node){
        if (node != null) {
            traversePost0rder(node.left);
            traversePost0rder(node.right);
            System.out.print(" " + node.data);
        }
    }

    void traverseIn0rder (Node node){
        if (node != null) {
            traverseIn0rder(node.left);
            System.out.print(" " + node.data);
            traverseIn0rder(node.right);
        }
    }

    Node getSuccessor (Node del){
        Node successor = del.right;
        Node successorParent = del;
        while (successor.left != null) {
            successorParent = successor;
            successor = successor.left;
        }
        if (successor!=del.right) {
            successorParent.left = successor.right;
            successor.right = del.right;
        }
        return successor;
    }

    void delete(int data){
        if (isEmpty()) {
            System.out.println("Tree is empty!");
            return;
        }
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;
        while (current!=null) {
            if (current.data == data) {
                break;
            } else if (data<current.data){
                parent = current;
                current = current.left;
                isLeftChild = true;
            } else if (data>current.data){
                parent = current;
                current = current.right;
                isLeftChild = false;
            }
        }
        if (current==null) {
            System.out.println("Couldn't find data!");
            return;
        } else {
            if (current.left==null && current.right==null) {
                if (current==root) {
                    root = null;
                } else {
                    if (isLeftChild) {
                        parent.left=null;
                    } else {
                        parent.right=null;
                    }
                }
            } else if (current.left==null){
                if (current==root) {
                    root = current.right;
                }else {
                    if (isLeftChild) {
                        parent.left = current.right;
                    } else {
                        parent.right = current.right;
                    }
                }
            } else if (current.right==null){
                if (current==root) {
                    root = current.left;
                } else {
                    if (isLeftChild) {
                        parent.left = current.left;
                    } else {
                        parent.right = current.left;
                    }
                }
            } else {
                Node successor = getSuccessor(current);
                if (current==root) {
                    root = successor;
                } else {
                    if (isLeftChild) {
                        parent.left = successor;
                    } else {
                        parent.right = successor;
                    }
                    successor.left = current.left;
                }
            }
        }
    }

    void addRecursive(int data) {
        root = addRecursive(root, data);
    }
    
    Node addRecursive(Node current, int data) {
        if (current == null) {
            return new Node(data);
        }
        if (data < current.data) {
            current.left = addRecursive(current.left, data);
        } else if (data > current.data) {
            current.right = addRecursive(current.right, data);
        }
        return current;
    }

    int findMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Tree is empty");
        }

        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }

    int findMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Tree is empty");
        }

        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }
}