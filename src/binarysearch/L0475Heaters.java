package binarysearch;

import java.util.Arrays;

/**
 * No.475 供暖器
 * https://leetcode-cn.com/problems/heaters
 * <p>
 * 冬季已经来临。你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 * 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
 * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
 * <p>
 * 示例 1:
 * 输入: houses = [1,2,3], heaters = [2]
 * 输出: 1
 * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
 * <p>
 * 示例 2:
 * 输入: houses = [1,2,3,4], heaters = [1,4]
 * 输出: 1
 * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
 * <p>
 * 示例 3：
 * 输入：houses = [1,5], heaters = [2]
 * 输出：3
 * <p>
 * 提示：
 * 1 <= houses.length, heaters.length <= 3 * 104
 * 1 <= houses[i], heaters[i] <= 109
 *
 * @author Neil
 * @version v1.0
 * @date 2021/4/29 15:36
 */
public class L0475Heaters {
    public static void main(String[] args) {

    }

    /**
     * 供暖器 双指针
     * 时间复杂度 O()
     * 空间复杂度 O()
     *
     * @param houses  房子
     * @param heaters 取暖器
     * @return 最小半径
     */
    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int res = 0;
        int i = 0;

        for (int house : houses) {
            while (i < heaters.length - 1 && Math.abs(heaters[i] - house) >= Math.abs(heaters[i + 1] - house)) {
                i++;
            }
            res = Math.max(res, Math.abs(heaters[i] - house));
        }
        return res;
    }

    /**
     * 供暖器 二分查找
     * 时间复杂度 O()
     * 空间复杂度 O()
     *
     * @param houses  房子
     * @param heaters 取暖器
     * @return 最小半径
     */
    public static int findRadius2(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int res = 0;
        int n = heaters.length;
        for (int house : houses) {
            int left = 0;
            int right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (house > heaters[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (right == 0) {
                res = Math.max(res, Math.abs(heaters[right] - house));
            } else if (right == n) {
                res = Math.max(res, Math.abs(heaters[right - 1] - house));
            } else {
                res = Math.max(res, Math.min(Math.abs(heaters[right] - house), Math.abs(heaters[right - 1] - house)));
            }
        }
        return res;
    }
}
