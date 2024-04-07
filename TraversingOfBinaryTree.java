package test8;

import java.util.ArrayList;
import java.util.List;

//分别用前,中,后序遍历二叉树
//写之前先确定递归的三要素
public class TraversingOfBinaryTree {
    //前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preoder(root, result);
        return result;
    }

    public void preoder(TreeNode root , List<Integer> result){
        if (root==null) {
            return;
        }
        result.add(root.val);
        preoder(root.left, result);
        preoder(root.right, result);
    }

    //中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    public void inorder(TreeNode root , List<Integer> result){
        if (root==null) {
            return;
        }
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    //后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    public void postorder(TreeNode root , List<Integer> result){
        if (root==null) {
            return;
        }
        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
    }

}

//树结点的定义
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {

    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}