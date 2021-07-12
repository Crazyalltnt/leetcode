package string;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * No.179 最大数
 * https://leetcode-cn.com/problems/largest-number
 * <p>
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * <p>
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 * 示例 1：
 * 输入：nums = [10,2]
 * 输出："210"
 * <p>
 * 示例 2：
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * <p>
 * 示例 3：
 * 输入：nums = [1]
 * 输出："1"
 * <p>
 * 示例 4：
 * 输入：nums = [10]
 * 输出："10"
 * <p>
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/5 10:09
 */
public class L0179LargestNumber {
    public static void main(String[] args) {

    }

    /**
     * 最大数 排序
     * 时间复杂度 O(NlogNlogM)
     * 空间复杂度 O(N)
     *
     * @param nums 数组
     * @return 最大整数字符串
     */
    public String largestNumber(int[] nums) {
        int n = nums.length;
        Integer[] numsArray = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsArray[i] = nums[i];
        }
        Arrays.sort(numsArray, (x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }

            long compare = sx * y + x - (sy * x + y);
            if (compare > 0) {
                return 1;
            } else if (compare < 0) {
                return -1;
            } else {
                return 0;
            }
        });

        if (numsArray[0] == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (Integer num : numsArray) {
            sb.append(num);
        }

        return sb.toString();
    }

    /**
     * 最大数 优先队列
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param nums 数组
     * @return 最大整数字符串
     */
    public String largestNumber2(int[] nums) {
        PriorityQueue<String> heap = new PriorityQueue<>((x, y) -> (y + x).compareTo(x + y));
        for (int num : nums) {
            heap.offer(String.valueOf(num));
        }
        StringBuilder sb = new StringBuilder();
        while (heap.size() > 0) {
            sb.append(heap.poll());
        }
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}
