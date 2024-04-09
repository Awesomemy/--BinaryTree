package test8;

//完全二叉树的结点个数

public class NodeCountsOfFullBinaryTree {
    /**
     * 针对完全二叉树的解法
     *
     * 满二叉树的结点数为：2^depth - 1
     * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
     *
     * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
     */
    public int countNodes(TreeNode root) {
        /*
        如果本题未强调是完全二叉树而只是普通二叉树的话
        既可以用迭代法层序遍历每个结点
        也可以用递归法后序遍历每个结点(类似求最大深度)
        但是无论哪种方法,都必须访问到每个结点

        如果利用完全二叉树的特性
        事实上只访问了满二叉树外侧的结点,内侧的结点都没有访问,大大提高了效率
        * */
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 这里初始化为0方便下面求指数
        int leftDepth = 0, rightDepth = 0;
        // 先判断是否为满二叉树,即左右一直遍历到底深度相等(在完全二叉树的前提下可以如此判断)
        while (left != null) {
            leftDepth++;
            left = left.left;
        }
        while (right != null) {
            rightDepth++;
            right = right.right;
        }
        // 若判断为满二叉树,可以直接根据完全二叉树的特性返回结果
        if (leftDepth == rightDepth) {
            // 2<<n 相当于 2^(n+1)
            return (2 << leftDepth) - 1;
        }
        // 如果不是满二叉树则继续向下递归
        return countNodes(root.left) + countNodes(root.right) + 1;
    }


    // 通用递归解法
//    public int countNodes(TreeNode root) {
//        if(root == null) {
//            return 0;
//        }
//        return countNodes(root.left) + countNodes(root.right) + 1;
//    }


    // 迭代法
//    public int countNodes(TreeNode root) {
//        if (root == null) return 0;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        int result = 0;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            while (size -- > 0) {
//                TreeNode cur = queue.poll();
//                result++;
//                if (cur.left != null) queue.offer(cur.left);
//                if (cur.right != null) queue.offer(cur.right);
//            }
//        }
//        return result;
//    }
}
