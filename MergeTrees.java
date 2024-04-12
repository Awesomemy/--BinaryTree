package test8;

/**
 * 给你两棵二叉树： root1 和 root2 。
 *
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 *
 * 返回合并后的二叉树。
 *
 * 注意: 合并过程必须从两个树的根节点开始。
 */
public class MergeTrees {
    //本题和对称二叉树一样,考察同时对两棵树进行操作
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // 下面这两个判断已经包括了都为空的情况
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        // 只剩下root1,root2都非空的情况
        TreeNode root = new TreeNode(root1.val + root2.val);
        // 树1和树2是同步遍历的
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);
        return root;
    }
}
