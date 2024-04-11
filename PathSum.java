package test8;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。

//注意本题除了算法逻辑以外,还要十分注意java中的值传递特性
public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        //用来收集所有的结果
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) {
            return res;
        }

        //用来记录过程中的路径结果
        List<Integer> path = new LinkedList<>();
        preorderdfs(root, targetSum, res, path);
        return res;
    }

    //采用前序遍历处理
    //由于需要搜索整棵二叉树且不必处理返回值,所以返回值类型选void
    private void preorderdfs(TreeNode root,int targetSum,List<List<Integer>> res,List<Integer> path){
        if (root==null) {
            return;
        }

        targetSum-=root.val;
        path.add(root.val);
        //若为叶子结点
        if (root.left==null && root.right==null) {
            if (targetSum==0) {
                //这里不能简单地res.add(path);
                //因为引用类型实际上是地址值传递,所以res和path会指向同一片存储区域
                //导致path的改变也会影响到res的对应部分,所以需要另行开辟空间来存储结果
                List<Integer> tempList = new ArrayList<>();
                for(Integer i : path){
                    tempList.add(i);
                }
                res.add(tempList);
            }
        }
        //如果不是叶子结点则继续往下遍历
        if (root.left!=null) {
            preorderdfs(root.left, targetSum, res, path);
            //注意这里要回溯
            //targetSum不用加回去,因为基本数据类型传递的是值的副本,不影响原来的数据
            //path这里需要弹出root.left.val,因为引用数据类型传递的是地址的副本,会改变原数据
            //注意用下标弹出最后一位,而非直接弹出root.left.val这个值
            path.remove(path.size()-1);
        }
        if (root.right!=null) {
            preorderdfs(root.right, targetSum, res, path);
            path.remove(path.size()-1);
        }
    }
}
