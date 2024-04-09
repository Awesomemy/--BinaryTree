package test8;

import java.util.ArrayList;
import java.util.List;

//二叉树的所有路径
//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
//叶子节点 是指没有子节点的节点。
public class AllPathsOfBinaryTree {
    //迭代与回溯是相辅相成的
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();  //用来存放最终的结果
        if (root==null) {
            return res;
        }
        List<Integer> paths = new ArrayList<>(); //作为结果中的路径
        traversal(root, paths, res);
        return res;
    }

    //采用前序遍历
    private void traversal(TreeNode root,List<Integer> paths, List<String> res){
        //一访问到就要添加结点值,以免漏掉了叶子结点
        paths.add(root.val);
        //如果是叶子结点的话,将路径转为字符串存入结果列表中
        if (root.left==null && root.right==null) {
            //StringBuilder用来拼接字符串速度更快
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size()-1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            //记录最后一个结点
            sb.append(paths.get(paths.size()-1));
            //收集到一条路径
            res.add(sb.toString());
            return;
        }
        // 递归和回溯是同时进行，所以要放在同一个花括号里
        if (root.left!=null) {
            traversal(root.left,paths,res);
            //将刚刚加入的结点移除
            paths.remove(paths.size()-1); //回溯
        }
        if (root.right!=null) {
            traversal(root.right, paths, res);
            paths.remove(paths.size()-1);
        }
    }
}
