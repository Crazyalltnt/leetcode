package array;

/**
 * No.11 盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water
 *
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器。
 *
 * 示例 1：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 *
 * 示例 3：
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 *
 * 示例 4：
 * 输入：height = [1,2,1]
 * 输出：2
 *
 * 提示：
 * n = height.length
 * 2 <= n <= 3 * 104
 * 0 <= height[i] <= 3 * 104
 *
 * @author Neil
 * @version v1.0
 * @date 2021/6/8 9:28
 */
public class L0011ContainerWithMostWater {
    public static void main(String[] args) {

    }

    /**
     * 盛最多水的容器 暴力 超时
     * 时间复杂度 O(N^2)
     * 空间复杂度 O(1)
     *
     * @param height 高度数组
     * @return 容量
     */
    public static int maxArea(int[] height) {
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height.length; j++) {
                int capacity = Math.min(height[i], height[j]) * (j - i);
                ans = Math.max(ans, capacity);
            }
        }
        return ans;
    }

    /**
     * 盛最多水的容器 双指针
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param height 高度数组
     * @return 容量
     */
    public static int maxArea2(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            int capacity = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, capacity);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
