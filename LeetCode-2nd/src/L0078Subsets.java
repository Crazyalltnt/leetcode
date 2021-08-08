import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * No.78 子集
 *
 * @author Neil
 * @version v1.0
 * @date 2021/8/8 23:01
 */
public class L0078Subsets {
    public static void main(String[] args) {

    }

    List<List<Integer>> ans = new LinkedList<>();
    List<Integer> temp = new LinkedList<>();
    /**
     * 子集 递归回溯
     * 时间复杂度 O(N * 2^N)
     * 空间复杂度 O(N)
     *
     * @param nums 数组
     * @return 子集
     */
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, nums);
        return ans;
    }

    public void backtrack(int index, int[] nums) {
        if (index == nums.length) {
            ans.add(new LinkedList<>(temp));
            return;
        }
        temp.add(nums[index]);
        backtrack(index + 1, nums);
        temp.remove(temp.size() - 1);
        backtrack(index + 1, nums);
    }

    /**
     * 子集 二进制模拟
     * 时间复杂度 O(N * 2^N)
     * 空间复杂度 O(N)
     *
     * @param nums 数组
     * @return 子集集合
     */
    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> setList = new ArrayList<>();
        int n = nums.length;

        int bitFlag = 0;
        while (bitFlag < Math.pow(2, n)) {
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (((bitFlag >> i) & 1) == 1) {
                    subList.add(nums[i]);
                }
            }
            setList.add(subList);
            bitFlag += 1;
        }
        return setList;
    }
}
