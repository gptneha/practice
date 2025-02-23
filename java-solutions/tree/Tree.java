import java.util.*;
class Node {
    private List<Node> children;
    public Node(List<Node> children) {
        this.children = children;
    }  
    public void setChildren(Node child) {
        this.children.add(child);
    }  
    public List<Node> getAllChild() {
        return this.children;
    }
}
class IntNode extends Node {
    private int data;
    public IntNode(List<Node> children, int data) {
        super(children);
        this.data = data;
    }
    public int getData() {
        return this.data;
    }
}

class Tree {
    public static void main(String args[]) {
        List<Node> arr1 = new ArrayList<>();
        List<Node> arr2 = new ArrayList<>();
        IntNode two = new IntNode(arr1, 2);
        IntNode three = new IntNode(arr2, 3);
        List<Node> list1 = new ArrayList<>();
        list1.add(two);
        list1.add(three);
        IntNode one = new IntNode(list1, 1);    
        System.out.println(one.getAllChild().get(0) + " all child are innocent" );
    }
}