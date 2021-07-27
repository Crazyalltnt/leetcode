import java.util.Deque;
import java.util.LinkedList;

/**
 * No.42 接雨水
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/27 9:36
 */
public class L0042TrappingRainWater {
    public static void main(String[] args) {

    }

    /**
     * 接雨水 暴力
     * 时间复杂度 O(N^2)
     * 空间复杂度 O(1)
     *
     * @param height 高度数组
     * @return 雨水量
     */
    public int trap(int[] height) {
        int ans = 0;
        int len = height.length;
        for (int i = 1; i < len - 1; i++) {
            int maxLeft = 0, maxRight = 0;
            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int j = i; j < len; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            ans += Math.min(maxLeft, maxRight) - height[i];
        }
        return ans;
    }

    /**
     * 接雨水 动态编程 先存储
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param height 高度数组
     * @return 雨水量
     */
    public int trap2(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        int ans = 0;
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        leftMax[0] = height[0];
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        rightMax[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        for (int i = 1; i < len - 1; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    /**
     * 接雨水 栈存储
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param height 高度数组
     * @return 雨水量
     */
    public int trap3(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = i - stack.peek() - 1;
                int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[top];
                ans += distance * boundedHeight;
            }
            stack.push(i);
        }
        return ans;
    }

    /**
     * 接雨水 双指针
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param height 高度数组
     * @return 雨水量
     */
    public int trap4(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int ans = 0;
        while (left <= right) {
            if (leftMax < rightMax) {
                ans += Math.max(0, leftMax - height[left]);
                leftMax = Math.max(leftMax, height[left]);
                left++;
            }
            else {
                ans += Math.max(0, rightMax - height[right]);
                rightMax = Math.max(rightMax, height[right]);
                right--;
            }
        }
        return ans;
    }
}
