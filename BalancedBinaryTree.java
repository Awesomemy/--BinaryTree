package test8;

//平衡二叉树
//给定一个二叉树，判断它是否是
//平衡二叉树:是指该树所有节点的左右子树的深度相差不超过 1。
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    // 用-1作为返回值表示该结点已不符合平衡二叉树的要求
    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 若左右孩子有返回-1说明根节点必定不符合平衡二叉树要求
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        // 进行到这里说明左右子树都符合平衡二叉树标准
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
