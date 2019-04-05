package data;

public class TreeNode<D> {

    private D data;
    TreeNode<D>[] children;

    public TreeNode(D data){
        this.data = data;
    }

    public D getData() {
        return data;
    }
}
