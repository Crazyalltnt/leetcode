import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 *
 * @author Neil
 * @version v1.0
 * @date 2022/1/26 20:04
 */
public class JZ61IsContinuous {
    public static void main(String[] args) {

    }

    /**
     * 扑克牌中的顺子 哈希表+遍历
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param numbers 抽出的牌
     * @return 是否顺子
     */
    public boolean IsContinuous(int [] numbers) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for (int number : numbers) {
            if (number == 0) {
                continue;
            }
            max = Math.max(max, number);
            min = Math.min(min, number);
            if (repeat.contains(number)) {
                return false;
            }
            repeat.add(number);
        }
        return max - min < 5;
    }

    /**
     * 扑克牌中的顺子 排序+遍历
     * 时间复杂度 O(NlogN)
     * 空间复杂度 O(1)
     *
     * @param numbers 抽出的牌
     * @return 是否顺子
     */
    public boolean IsContinuous2(int [] numbers) {
        int zeroCounts = 0;
        Arrays.sort(numbers);
        for (int i = 0; i < 4; i++) {
            if (numbers[i] == 0) {
                zeroCounts++;
            } else if (numbers[i] == numbers[i + 1]){
                return false;
            }
        }
        return numbers[4] - numbers[zeroCounts] < 5;
    }
}
