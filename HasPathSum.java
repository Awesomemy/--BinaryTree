package test8;

//给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
//叶子节点 是指没有子节点的节点。
public class HasPathSum {
    //注意,本题只要求判断是否存在,所以不必遍历全部结点,找到一条符合要求的路径就返回即可
    //只找某一条路径时递归方法必须有返回值,因为要判断找到了就及时返回结果
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root==null) {
            return false;
        }
        //此处采用累减而非累加,这样做代码会简单一些
        //把targetSum的改变放在这里,实际上隐藏了回溯的过程
        targetSum-=root.val;
        //如果是访问的是叶子结点
        if (root.left==null && root.right==null) {
            return targetSum==0;
        }
        //如果不是叶子结点就继续递归
        if(root.left!=null){
            if (hasPathSum(root.left,targetSum)) {
                return true;//这里是将左子树里面有符合要求的路径这一点通过true返回给上层知晓
            }
        }
        if (root.right!=null) {
            if (hasPathSum(root.right,targetSum)) {
                return true;
            }
        }
        //左右子树里面都不存在符合要求的路径
        return false;
    }
}
