package test8;

//另一棵树的子树
//给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
//二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
public class IsSubtree {
    //可以利用之前的相同子树的结论,即遍历结点,只要找到一个结点子树与其相同即可
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //确定递归终止条件
        if (root == null) {
            return false;
        }
        //注意只有这个地方需要判断是否为相同的树
        if (isSameTree(root, subRoot)) {
            return true;
        }
        //后面的递归中调用的不是isSameTree(),而是isSubtree(),这里需要小心(只要左右子树的子树里面有相同子树即可,而不必得是它本身)
        if (root.left != null && root.right != null) {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
        if (root.left != null && root.right == null) {
            return isSubtree(root.left, subRoot);
        }
        if (root.left == null && root.right != null) {
            return isSubtree(root.right, subRoot);
        }
        return false;
    }

    // 该方法用来判断两树是否相同
    private boolean isSameTree(TreeNode p, TreeNode q) {
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
