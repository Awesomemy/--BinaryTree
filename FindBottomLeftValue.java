package test8;

//找出树左下角的值
//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
//假设二叉树中至少有一个节点。

//本题也可以用层序遍历迭代,只需要返回最后一行第一列的值即可
public class FindBottomLeftValue {
    //递归法求解和求最大最小值异曲同工,都是在遇到更深(大/小)的结点时更新记录
    private int Deep = -1; //用来记录当前能访问到结点的最大深度,大于Deep(比记录更深)就更新value
    private int value;

    public int findBottomLeftValue(TreeNode root) {
        value=root.val;
        findLeftValue(root,0);
        return value;
    }

    private void findLeftValue(TreeNode root,int deep){
        //递归终止条件
        if (root==null) {
            return;
        }
        //如果是叶子结点
        if (root.left==null && root.right==null) {
            //每层最左边的叶子结点一定是第一个被遍历到的,
            //一旦遍历到更深的叶子结点就更新记录
            //deep=Deep说明是同一层的靠右的叶子结点,不会引起记录的更新
            if (deep>Deep) {
                Deep=deep;
                value=root.val;
            }
        }
        //如果不是叶子结点,继续往下遍历
        if (root.left!=null) {
            /*
            其实这里隐藏了回溯的过程,原本的回溯过程应该是:
            deep++;
            findLeftValue(root.left,deep);
            deep--;  //回溯
            */
            findLeftValue(root.left, deep+1);
        }
        if (root.right!=null) {
            findLeftValue(root.right, deep+1);
        }
    }
}
