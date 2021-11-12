/**
 * 剑指 Offer 04. 二维数组中的查找
 *
 * @author Neil
 * @version v1.0
 * @date 2021/11/12 19:29
 */
public class FindNumberIn2DArray {
    public static void main(String[] args) {

    }

    /**
     * 二维数组中的查找
     * 时间复杂度 O(M + N)
     * 空间复杂度 O(1)
     *
     * @param target 目标值
     * @param array 数组
     * @return 是否有目标值
     */
    public boolean Find(int target, int[][] array) {
        int row = array.length - 1, col = 0;
        while (row >= 0 && col < array[0].length) {
            if (array[row][col] > target) {
                row--;
            } else if (array[row][col] < target) {
                col++;
            } else {
                return true;
            }
        }
        return false;
    }

}
