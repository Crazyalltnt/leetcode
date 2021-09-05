import java.util.HashSet;
import java.util.Set;

/**
 * No.128 最长连续序列
 *
 * @author Neil
 * @version v1.0
 * @date 2021/9/5 11:56
 */
public class L0128LongestConsecutiveSequence {
    public static void main(String[] args) {

    }

    /**
     * 最长连续序列
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param nums 整数数组
     * @return 最长序列的长度
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longestStreak = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
