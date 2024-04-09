package test8;

//二叉树的最小深度
//给定一个二叉树，找出其最小深度。
//最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//说明：叶子节点是指没有子节点的节点。
public class MinDepthOfBinaryTree2 {
    public int minDepth(TreeNode root) {
        if (root==null) {
            return 0 ;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        //这里的处理和求最大深度不一样,不能简单地取二者最小值然后加1
        if (root.left==null) {
            return rightDepth+1;
        }
        if (root.right==null) {
            return leftDepth+1;
        }
        //剩下的才是左右结点都不为空的情况
        return Math.min(leftDepth, rightDepth)+1;
    }
}
