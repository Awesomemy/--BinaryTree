package test8;

//对称二叉树
//给你一个二叉树的根节点 root ， 检查它是否轴对称

/**
 * 首先想清楚，判断对称二叉树要比较的是哪两个节点，要比较的可不是左右节点！
 * 对于二叉树是否对称，要比较的是根节点的左子树与右子树是不是相互翻转的，理解这一点就知道了其实我们要比较的是两个树（这两个树是根节点的左右子树），所以在递归遍历的过程中，也是要同时遍历两棵树。
 *那么如何比较呢？
 * 比较的是两个子树的里侧和外侧的元素是否相等。
 * 那么遍历的顺序应该是什么样的呢？
 * 本题遍历只能是“后序遍历”，因为我们要通过递归函数的返回值来判断两个子树的内侧节点和外侧节点是否相等。
 * 正是因为要遍历两棵树而且要比较内侧和外侧节点，所以准确的来说是一个树的遍历顺序是左右中，一个树的遍历顺序是右左中。
 * 但都可以理解算是后序遍历，尽管已经不是严格上在一个树上进行遍历的后序遍历了。
 */
public class SymmetricalBinaryTree {

    // 递归法
    public boolean isSymmetric(TreeNode root) {
        if (root==null) {
            return true;
        }
        return compare(root.left, root.right);
    }

    //注意,这里定义的left,right并不是指左右孩子,而是左右两侧镜像对称的结点
    //这点在"判断是否为相同的树"中能很好地看出来
    private boolean compare(TreeNode left, TreeNode right) {
        // 先排除所有空结点的情况
        if (left == null && right == null) {
            return true;
        }
        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }
        // 然后排除左右结点非空但值不相等的情况
        if (left.val != right.val) {
            return false;
        }
        //程序走到这里只剩下左右结点非空且值相等的情况了
        // 此时才做递归，做下一层的判断
        //严格来说这不算后序遍历,不过可以这么理解

        //比较外侧
        boolean outside = compare(left.left,right.right);
        boolean inside = compare(left.right, right.left);
        boolean result = outside && inside;
        return result;
    }


    /**
     * 迭代法
     * 使用双端队列，相当于两个栈
     */
/*
    public boolean isSymmetric2(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root.left);
        deque.offerLast(root.right);
        while (!deque.isEmpty()) {
            TreeNode leftNode = deque.pollFirst();
            TreeNode rightNode = deque.pollLast();
            if (leftNode == null && rightNode == null) {
                continue;
            }
//            if (leftNode == null && rightNode != null) {
//                return false;
//            }
//            if (leftNode != null && rightNode == null) {
//                return false;
//            }
//            if (leftNode.val != rightNode.val) {
//                return false;
//            }
            // 以上三个判断条件合并
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }
            deque.offerFirst(leftNode.left);
            deque.offerFirst(leftNode.right);
            deque.offerLast(rightNode.right);
            deque.offerLast(rightNode.left);
        }
        return true;
    }
*/

    /**
     * 迭代法
     * 使用普通队列
     */
/*
    public boolean isSymmetric3(TreeNode root) {
        Queue<TreeNode> deque = new LinkedList<>();
        deque.offer(root.left);
        deque.offer(root.right);
        while (!deque.isEmpty()) {
            TreeNode leftNode = deque.poll();
            TreeNode rightNode = deque.poll();
            if (leftNode == null && rightNode == null) {
                continue;
            }
//            if (leftNode == null && rightNode != null) {
//                return false;
//            }
//            if (leftNode != null && rightNode == null) {
//                return false;
//            }
//            if (leftNode.val != rightNode.val) {
//                return false;
//            }
            // 以上三个判断条件合并
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }
            // 这里顺序与使用Deque不同
            deque.offer(leftNode.left);
            deque.offer(rightNode.right);
            deque.offer(leftNode.right);
            deque.offer(rightNode.left);
        }
        return true;
    }
*/
}
