import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * No.179 最大数
 *
 * @author Neil
 * @version v1.0
 * @date 2021/9/16 14:33
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

            return (int)(sx * y + x - sy * x - y);
        });

        if (numsArray[0] == 0) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        for (Integer num : numsArray) {
            ans.append(num);
        }
        return ans.toString();
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
