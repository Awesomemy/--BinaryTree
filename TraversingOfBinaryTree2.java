package test8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//用迭代法(非递归)遍历前中后序
//实际上所有递归都可以用栈实现,只不过有些比较复杂的递归就没必要了
//迭代法并不像递归那样
public class TraversingOfBinaryTree2 {
    //前序遍历
    //前序遍历的结点的访问顺序和处理顺序是一样的,所以写起来代码才比较简洁
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root==null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            //注意这里由于栈的"先进后出"特性,所以应当先将右孩子入栈,再将左孩子入栈
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    //后序遍历
    //后序遍历可以在前序遍历的基础上只改变几处代码的顺序来实现
    //前序:根左右->(交换左右孩子入栈的顺序)根右左->(反转结果数组)左右根->这即是后序
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root==null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            //第一处修改:交换左右孩子的入栈顺序
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        //第二处修改,反转结果数组
        Collections.reverse(result);
        return result;
    }

    //中序遍历
    //在使用迭代法写中序遍历，就需要借用指针的遍历来帮助访问节点，栈则用来处理节点上的元素
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root==null) {
            return result;
        }
        //栈则用来处理节点上的元素
        Stack<TreeNode> stack = new Stack<>();
        //需要借用指针的遍历来帮助访问节点
        TreeNode cur = root;
        while (cur!=null || !stack.isEmpty()) {
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else{
                cur=stack.pop();
                result.add(cur.val);
                cur=cur.right;
            }
        }
        return result;
    }

}
