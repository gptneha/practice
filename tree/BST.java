class Node {
    private int data;
    private Node left;
    private Node right;
    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return this.left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return this.right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node data(int data) {
        this.data = data;
        return this;
    }

    public Node left(Node left) {
        this.left = left;
        return this;
    }

    public Node right(Node right) {
        this.right = right;
        return this;
    }

    public Node insertNodeInTree(int data) {
        Node root = this;
        while(root!=null) {
            System.out.println(root.data + " root data is " + " new node is " + data );
            if (root.data> data) {
                root = root.left;
            } else if (root.data < data) {
                root = root.right;
            } else {
                System.out.println("two can not have same data");
            }
        }
        root = new Node(data, null, null);
        return this;
    }

    public Node createBST(int[] arr) {
        this.data = arr[0];
        for (int i = 1; i < arr.length; i = i+1 ) {
            this.insertNodeInTree(arr[i]);
        }
        return this;
    }
}

class BST {
    public static void main(String[] args) {
        Node root = new Node(0, null, null);
        System.out.println("tree is " +  root.getData());
        
        int[] arr = {1,2,3,4,5,6,7,8,9};
        root.createBST(arr);
    }
}