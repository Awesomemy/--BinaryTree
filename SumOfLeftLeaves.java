package test8;

public class SumOfLeftLeaves {
    public int result = 0;

    //由于是否为左叶子必须由其父结点判断,所以最好用前序遍历
    public int sumOfLeftLeaves(TreeNode root) {
        sumOfLeft(root, false);
        return result;
    }

    //递归第一要素:确定递归方法的返回值和参数(传入flag参数来标志node是否为其父结点的左孩子)
    private void sumOfLeft(TreeNode node, boolean flag) {
        //递归第二要素:确定递归终止条件
        if (node == null) {
            return;
        }
        //递归第三要素:确定单层处理逻辑
        if (flag) {
            //只有遍历到左叶子才将值加入结果
            if (node.left == null && node.right == null) {
                result += node.val;
            }
        }
        //是左孩子则参数flag传入true
        if (node.left != null) {
            sumOfLeft(node.left, true);
        }
        //是右孩子则参数flag传入false
        if (node.right != null) {
            sumOfLeft(node.right, false);
        }
    }
}
