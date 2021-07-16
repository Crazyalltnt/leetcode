/**
 * No.912 排序数组
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/16 21:26
 */
public class L0912SortAnArray {
    public static void main(String[] args) {

    }

    /**
     * 排序数组 快速排序
     * 时间复杂度 O(NlogN)
     * 空间复杂度 O(H)
     *
     * @param nums 数组
     * @return 排序后数组
     */
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = randomPartition(nums, left, right);
            quickSort(nums, left, mid - 1);
            quickSort(nums, mid + 1, right);
        }
    }

    public int randomPartition(int[] nums, int left, int right) {
        int index = (int)(Math.random() * (right - left + 1)) + left;
        swap(nums, index, right);

        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (nums[j] <= nums[right]) {
                swap(nums, ++i, j);
            }
        }
        swap(nums, i + 1, right);

        return i + 1;
    }

    public void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 排序数组 堆排序
     * 时间复杂度 O(NlogN)
     * 空间复杂度 O(1)
     *
     * @param nums 数组
     * @return 排序后数组
     */
    public int[] sortArray2(int[] nums) {
        heapSort(nums);
        return nums;
    }

    public void heapSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            up(nums, i);
        }

        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            down(nums, 0, i - 1);
        }
    }

    public void up(int[] nums, int index) {
        int father = (index - 1) / 2;
        while (father >= 0 && nums[index] > nums[father]) {
            swap(nums, index, father);
            index = father;
            father = (index - 1) / 2;
        }
    }

    public void down(int[] nums, int index, int boundary) {
        int son = index * 2 + 1;
        while (son <= boundary) {
            if (son + 1 <= boundary && nums[son + 1] > nums[son]) {
                son++;
            }
            if (nums[index] >= nums[son]) {
                break;
            }
            swap(nums, index, son);
            index = son;
            son = index * 2 + 1;
        }
    }

    /**
     * 排序数组 堆排序 版本2
     * 时间复杂度 O(NlogN)
     * 空间复杂度 O(1)
     *
     * @param nums 数组
     * @return 排序后数组
     */
    public int[] sortArray3(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            down(nums, i, nums.length - 1);
        }

        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            down(nums, 0, i - 1);
        }

        return nums;
    }

    int[] temp;
    /**
     * 排序数组 归并排序
     * 时间复杂度 O(NlogN)
     * 空间复杂度 O(1)
     *
     * @param nums 数组
     * @return 排序后数组
     */
    public int[] sortArray4(int[] nums) {
        temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        int i = left, j = mid + 1;
        int cnt = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[cnt++] = nums[i++];
            } else {
                temp[cnt++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[cnt++] = nums[i++];
        }
        while (j <= right) {
            temp[cnt++] = nums[j++];
        }

        if (right - left + 1 >= 0) {
            System.arraycopy(temp, 0, nums, left, right - left + 1);
        }
    }
}
