package data;

public class ListNode<D> {
    private D data;
    public ListNode<D> next;

    public ListNode(D data){
        this.data = data;
    }

    public D getData() {
        return data;
    }
}
