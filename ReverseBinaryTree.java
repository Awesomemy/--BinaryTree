package test8;

//给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
public class ReverseBinaryTree {
    /**
     * 前后序遍历都可以
     * 中序不行，因为先左孩子交换孩子，再根交换孩子（做完后，右孩子已经变成了原来的左孩子），再右孩子交换孩子（此时其实是对原来的左孩子做交换）
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        swapChildren(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    private void swapChildren(TreeNode root) {
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
    }
}
