class LLInt {
    private int data;
    private LLInt next;
    public LLInt(int data) {
        this.data = data;
        this.next = null;
    }
    public void setNext(LLInt newNode) {
        this.next = newNode;
    }
    public static void main(String args[]) {
        LLInt ll = new LLInt(2);
        System.out.println(ll.data + " " + ll.next);
        LLInt newll = ll;
        System.out.println(newll + " " + ll);
        System.out.println(newll.data + " " + newll.next);
        ll.setNext(new LLInt(3));
        System.out.println(ll.next.data + " " + ll.data);

    }
}
