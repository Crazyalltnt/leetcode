import java.util.*;

/**
 * 剑指 Offer 40. 最小的k个数
 *
 * @author Neil
 * @version v1.0
 * @date 2022/1/15 19:19
 */
public class JZ40GetLeastNumbers {
    public static void main(String[] args) {

    }

    /**
     * 最小的k个数 优先队列
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param input 输入
     * @param k k
     * @return 第k小数
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (k == 0) {
            return new ArrayList<>();
        }
        PriorityQueue<Integer> res = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : input) {
            if (res.size() < k || num < res.peek()) {
                res.offer(num);
            }
            if (res.size() > k) {
                res.poll();
            }
        }

        ArrayList<Integer> result = new ArrayList<>(res);
        Collections.reverse(result);
        return result;
    }

    /**
     * 最小的k个数 快速排序
     * 时间复杂度 O(NlogN)
     * 空间复杂度 O(N)
     *
     * @param input 输入
     * @param k k
     * @return 第k小数
     */
    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (k == 0) {
            return res;
        }
        quickSort(input, 0, input.length - 1);
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }

    public void quickSort(int[] input, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left, j = right;
        while (i < j) {
            while (i < j && input[j] >= input[left]) {
                j--;
            }
            while (i < j && input[i] <= input[left]) {
                i++;
            }
            swap(input, i, j);
        }
        swap(input, i, left);
        quickSort(input, left, i - 1);
        quickSort(input, i + 1, right);
    }

    public void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    /**
     * 最小的k个数 快速排序 数组划分
     * 时间复杂度 O(N)
     * 空间复杂度 O(logN)
     *
     * @param input 输入
     * @param k k
     * @return 第k小数
     */
    public ArrayList<Integer> GetLeastNumbers_Solution3(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (k == input.length) {
            for (int i : input) {
                res.add(i);
            }
        } else if (k != 0){
            int[] tmp = quickSort(input, k, 0, input.length - 1);
            for (int i = 0; i < k; i++) {
                res.add(tmp[i]);
            }
        }
        return res;
    }

    public int[] quickSort(int[] input, int k, int left, int right) {
        int i = left, j = right;
        while (i < j) {
            while (i < j && input[j] >= input[left]) {
                j--;
            }
            while (i < j && input[i] <= input[left]) {
                i++;
            }
            swap(input, i, j);
        }
        swap(input, i, left);
        if (i > k) {
            return quickSort(input, k, left, i - 1);
        }
        if (i < k) {
            return quickSort(input, k, i + 1, right);
        }
        return Arrays.copyOf(input, k);
    }
}
