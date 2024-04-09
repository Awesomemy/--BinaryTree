package test8;

//二叉树的最大深度
//给定一个二叉树 root ，返回其最大深度。
//二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
public class MaxDepthOfBinaryTree2 {
    /**
     * 首先要分清楚高度和深度
     * 深度是从上往下计数的,高度是自下而上计数的
     * 所以求深度最好用前序遍历,求高度最好用后序遍历
     * 不过本题所求"二叉树最大深度",其实就是"根节点的高度"
     * 于是将求深度转为求高度
     *
     * 本题可以用递归法解决
     * 注意是后序遍历
     */
    public int maxDepth(TreeNode root) {
        if (root==null) {
            return 0;
        }
        int leftDepth=maxDepth(root.left);
        int rightDepth=maxDepth(root.right);
        int depth = Math.max(leftDepth,rightDepth)+1;
        return depth;
    }
}
