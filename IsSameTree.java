package test8;

//给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
//如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
public class IsSameTree {
    /*
     * 本题和判断是否为对称二叉树很相似
     * 只不过对称二叉树是在一棵树上判断
     * 本题是在两棵树上判断罢了
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null && q != null) {
            return false;
        }
        if (p != null && q == null) {
            return false;
        }
        // 剩下的是p,q均非空的情况
        if (p.val != q.val) {
            return false;
        }
        // 现在只剩p,q非空且值相等的情况
        boolean leftSide = isSameTree(p.left, q.left);
        boolean rightSide = isSameTree(p.right, q.right);
        return leftSide && rightSide;
    }
}
