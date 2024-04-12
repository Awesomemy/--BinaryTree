package test8;

//给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
//
//创建一个根节点，其值为 nums 中的最大值。
//递归地在最大值 左边 的 子数组前缀上 构建左子树。
//递归地在最大值 右边 的 子数组后缀上 构建右子树。
//返回 nums 构建的 最大二叉树 。
public class BuilderMaxTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // 从头到尾都要坚持左闭右开的标准
        return construct(nums, 0, nums.length);
    }

    private TreeNode construct(int[] nums, int leftIndex, int rightIndex) {
        if (rightIndex - leftIndex < 1) {
            return null;
        }
        // 这里是到叶子结点了
        if (rightIndex - leftIndex == 1) {
            return new TreeNode(nums[leftIndex]);
        }
        int maxIndex = leftIndex;
        int maxVal = nums[leftIndex];
        for (int i = leftIndex+1; i < rightIndex; i++) {
            if (maxVal < nums[i]) {
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);

        root.left = construct(nums, leftIndex, maxIndex);
        root.right = construct(nums, maxIndex + 1, rightIndex);

        return root;
    }
}
