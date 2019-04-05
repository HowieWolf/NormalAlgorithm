package data;

public class BinaryTreeNode<D> {

    private D data;
    public BinaryTreeNode<D> left;
    public BinaryTreeNode<D> right;

    public BinaryTreeNode(D data) {
        this.data = data;
    }

    public D getData() {
        return data;
    }
}
