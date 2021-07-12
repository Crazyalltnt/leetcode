package binarysearch;


/**
 * No.875 爱吃香蕉的珂珂
 * https://leetcode-cn.com/problems/koko-eating-bananas
 * <p>
 * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 * <p>
 * 示例 1：
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 * <p>
 * 示例 2：
 * 输入: piles = [30,11,23,4,20], H = 5
 * 输出: 30
 * <p>
 * 示例 3：
 * 输入: piles = [30,11,23,4,20], H = 6
 * 输出: 23
 * <p>
 * 提示：
 * 1 <= piles.length <= 10^4
 * piles.length <= H <= 10^9
 * 1 <= piles[i] <= 10^9
 *
 * @author Neil
 * @version v1.0
 * @date 2021/4/25 15:33
 */
public class L0875KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20};
        int H = 5;
        System.out.println(minEatingSpeed(piles, H));
    }

    /**
     * 爱吃香蕉的珂珂 二分查找
     * 时间复杂度 O(NlogW)
     * 空间复杂度 O(1)
     *
     * @param piles 数组
     * @param h     时间
     * @return 速度
     */
    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = piles[0];
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (!canEat(piles, h, mid)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static boolean canEat(int[] piles, int h, int k) {
        int time = 0;
        for (int pile : piles) {
            time += Math.ceil(pile * 1.0 / k);
        }
        return time <= h;
    }
}
