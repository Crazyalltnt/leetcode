package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * No.498 对角线遍历
 * https://leetcode-cn.com/problems/diagonal-traverse
 *
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 *
 * 示例:
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出:  [1,2,4,7,5,3,6,8,9]
 *
 * 说明:
 * 给定矩阵中的元素总数不会超过 100000 。
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/10 16:50
 */
public class L0498DiagonalTraverse {
    public static void main(String[] args) {

    }

    /**
     * 对角线遍历 对角线迭代和翻转
     * 时间复杂度 O(MN)
     * 空间复杂度 O(min(M,N))
     *
     * @param mat 矩阵
     * @return 遍历结果
     */
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return new int[0];
        }

        int m = mat.length, n = mat[0].length;
        int[] result = new int[m * n];
        int index = 0;
        List<Integer> tempDiagonal = new ArrayList<>();

        for (int diagonal = 0; diagonal < m + n - 1; diagonal++) {
            tempDiagonal.clear();
            int row = diagonal < n ? 0 : diagonal - n + 1;
            int col = diagonal < n ? diagonal : n - 1;
            while (row < m && col >= 0) {
                tempDiagonal.add(mat[row][col]);
                row++;
                col--;
            }

            if (diagonal % 2 == 0) {
                Collections.reverse(tempDiagonal);
            }

            for (Integer integer : tempDiagonal) {
                result[index++] = integer;
            }
        }
        return result;
    }

    /**
     * 对角线遍历 模拟
     * 时间复杂度 O(MN)
     * 空间复杂度 O(min(M,N))
     *
     * @param mat 矩阵
     * @return 遍历结果
     */
    public int[] findDiagonalOrder2(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return new int[0];
        }

        int m = mat.length, n = mat[0].length;
        int[] result = new int[m * n];
        int row = 0, col = 0;
        int direction = 1;
        int index = 0;
        while (row < m && col < n) {
            result[index++] = mat[row][col];
            int newRow = row + (direction == 1 ? -1 : 1);
            int newCol = col + (direction == 1 ? 1 : -1);
            if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) {
                if (direction == 1) {
                    row += (col < n - 1 ? 0 : 1);
                    col += (col < n - 1 ? 1 : 0);
                } else {
                    col += (row < m - 1 ? 0 : 1);
                    row += (row < m - 1 ? 1 : 0);
                }
                direction = -direction;
            } else {
                row = newRow;
                col = newCol;
            }
        }
        return result;
    }
}
