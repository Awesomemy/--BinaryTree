package test8;

import java.util.HashMap;
import java.util.Map;

//从中序和后序遍历序列构造二叉树
//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
public class BuildBinaryTree {
    Map<Integer,Integer> map; //方便根据数值查找位置

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map=new HashMap<>();
        // 用map保存中序序列的数值对应位置
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }

        return findNode(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    //注意不变量,要是选择"左闭右开",就应该从始至终按照"左闭右开"来写
    public TreeNode findNode(int[] inorder,int inStart,int inEnd,int[] postorder,int postStart,int postEnd){
        // 不满足左闭右开，说明没有元素，返回空树
        if (inStart>=inEnd || postStart>=postEnd) {
            return null;
        }
        // 找到后序遍历的最后一个元素在中序遍历中的位置
        int rootIndex = map.get(postorder[postEnd-1]);
        // 构造当前子树的根结点
        TreeNode root = new TreeNode(inorder[rootIndex]);
        // 保存中序左子树个数，用来确定后序数列的个数
        int lenOfLeft = rootIndex-inStart;
        // 接收该结点的左右孩子
        root.left=findNode(inorder, inStart, rootIndex, postorder, postStart, postStart+lenOfLeft);
        root.right=findNode(inorder, rootIndex+1, inEnd, postorder, postStart+lenOfLeft, postEnd-1);
        // 返回子树根结点作为结果
        return root;
    }
}
