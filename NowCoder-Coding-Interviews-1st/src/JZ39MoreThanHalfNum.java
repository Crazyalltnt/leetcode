import java.util.Arrays;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 *
 * @author Neil
 * @version v1.0
 * @date 2022/2/3 15:46
 */
public class JZ39MoreThanHalfNum {
    public static void main(String[] args) {

    }

    /**
     * 数组中出现次数超过一半的数字 选举
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param array 数组
     * @return 数字
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        int res = array[0];
        int count = 0;
        for (int num : array) {
            if (count == 0) {
                res = num;
            }
            if (res == num) {
                count++;
            } else {
                count--;
            }
        }
        return res;
    }

    /**
     * 数组中出现次数超过一半的数字 排序
     * 时间复杂度 O(NlogN)
     * 空间复杂度 O(1)
     *
     * @param array 数组
     * @return 数字
     */
    public int MoreThanHalfNum_Solution2(int [] array) {
        Arrays.sort(array);
        return array[array.length / 2];
    }

    /**
     * 数组中出现次数超过一半的数字 排序
     * 时间复杂度 O(NlogN)
     * 空间复杂度 O(1)
     *
     * @param array 数组
     * @return 数字
     */
    public int MoreThanHalfNum_Solution3(int [] array) {
        Arrays.sort(array);
        return array[array.length / 2];
    }
}
