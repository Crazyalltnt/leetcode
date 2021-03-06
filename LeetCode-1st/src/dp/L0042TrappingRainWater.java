package dp;

import java.util.Deque;
import java.util.LinkedList;

/**
 * No.42 接雨水
 * https://leetcode-cn.com/problems/trapping-rain-water
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * <p>
 * 示例 2：
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 * @author Neil
 * @version v1.0
 * @date 2021/3/18 16:02
 */
public class L0042TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap2(height));
    }

    /**
     * 接雨水 暴力
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(1)
     *
     * @param height 高度数组
     * @return 雨水量
     */
    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int result = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int maxLeft = 0;
            int maxRight = 0;
            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int j = i; j < size; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }

            result += Math.min(maxLeft, maxRight) - height[i];
        }

        return result;
    }

    /**
     * 接雨水 动态编程
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     *
     * @param height 高度数组
     * @return 雨水量
     */
    public static int trap2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int result = 0;
        int size = height.length;
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];

        leftMax[0] = height[0];
        for (int i = 1; i < size; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        rightMax[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        for (int i = 1; i < size - 1; i++) {
            result += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return result;
    }

    /**
     * 接雨水 使用栈
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     *
     * @param height 高度数组
     * @return 雨水量
     */
    public static int trap3(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int result = 0;
        int index = 0;
        Deque<Integer> stack = new LinkedList<>();
        while (index < height.length)  {
            while (!stack.isEmpty() && height[index] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = index - stack.peek() - 1;
                int boundedHeight = Math.min(height[index], height[stack.peek()]) - height[top];
                result += distance * boundedHeight;
            }
            stack.push(index++);
        }

        return result;
    }

    /**
     * 接雨水 双指针
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     *
     * @param height 高度数组
     * @return 雨水量
     */
    public static int trap4(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int result = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    result += (leftMax - height[left]);
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    result += (rightMax - height[right]);
                }
                right--;
            }
        }
        return result;
    }
}
