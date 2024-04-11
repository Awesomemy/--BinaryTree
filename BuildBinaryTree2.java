package test8;

import java.util.HashMap;
import java.util.Map;

//从前序和中序遍历序列构造二叉树
//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
public class BuildBinaryTree2 {
    Map<Integer,Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map=new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);  //题目中规定数组没有重复元素
        }
        //从头至尾都要坚持一种分区间方式->这里选择"左闭右开"
        return findNode(preorder,0,preorder.length,inorder,0,inorder.length);
    }

    private TreeNode findNode(int[] preorder, int preStart,int preEnd,int[] inorder,int inStart,int inEnd){
        if(preStart>=preEnd || inStart>=inEnd){
            return null;
        }
        int rootIndex=map.get(preorder[preStart]);
        TreeNode root = new TreeNode(inorder[rootIndex]);
        int lenOfLeft = rootIndex-inStart;
        root.left=findNode(preorder,preStart+1,preStart+lenOfLeft+1,inorder,inStart,inStart+lenOfLeft);
        root.right=findNode(preorder,preStart+lenOfLeft+1,preEnd,inorder,rootIndex+1,inEnd);
        return root;
    }
}
