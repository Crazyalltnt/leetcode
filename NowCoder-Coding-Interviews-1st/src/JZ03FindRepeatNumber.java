import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 03. 数组中重复的数字
 *
 * @author Neil
 * @version v1.0
 * @date 2022/1/15 15:09
 */
public class JZ03FindRepeatNumber {
    public static void main(String[] args) {

    }

    /**
     * 数组中重复的数字 哈希表
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param numbers 数组
     * @return 重复的数字
     */
    public int duplicate(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : numbers) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    /**
     * 数组中重复的数字 原地交换
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param numbers 数组
     * @return 重复的数字
     */
    public int duplicate2(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        int index = 0;
        while (index < numbers.length) {
            if (numbers[index] == index) {
                index++;
                continue;
            }
            if (numbers[numbers[index]] == numbers[index]) {
                return numbers[index];
            }
            int tmp = numbers[index];
            numbers[index] = numbers[tmp];
            numbers[tmp] = tmp;
        }
        return -1;
    }
}
