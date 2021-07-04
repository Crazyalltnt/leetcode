package array;

/**
 * No.240 搜索二维矩阵 II
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 *
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * 示例 1：
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 *
 * 示例 2：
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 *
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -109 <= matix[i][j] <= 109
 * 每行的所有元素从左到右升序排列
 * 每列的所有元素从上到下升序排列
 * -109 <= target <= 109
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/4 9:18
 */
public class L0240SearchA2dMatrix2 {
    public static void main(String[] args) {

    }

    /**
     * 搜索二维矩阵 II 暴力
     * 时间复杂度 O(MN)
     * 空间复杂度 O(1)
     *
     * @param matrix 二维矩阵
     * @param target 目标值
     * @return 索引
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 搜索二维矩阵 II 二分查找
     * 时间复杂度 O(log(N!))
     * 空间复杂度 O(1)
     *
     * @param matrix 二维矩阵
     * @param target 目标值
     * @return 索引
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < Math.min(m, n); i++) {
            boolean rowSearch = binarySearch(matrix, target, i, true);
            boolean colSearch = binarySearch(matrix, target, i, false);
            if (rowSearch || colSearch) {
                return true;
            }
        }
        return false;
    }

    public boolean binarySearch(int[][] matrix, int target, int diagonal, boolean vertical) {
        int left = diagonal;
        int right = vertical ? matrix[0].length - 1 : matrix.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (vertical) {
                if (matrix[diagonal][mid] < target) {
                    left = mid + 1;
                } else if (matrix[diagonal][mid] > target) {
                    right = mid - 1;
                } else {
                    return true;
                }
            } else {
                if (matrix[mid][diagonal] < target) {
                    left = mid + 1;
                } else if (matrix[mid][diagonal] > target) {
                    right = mid - 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 搜索二维矩阵 II 搜索空间的缩减 递归
     * 时间复杂度 O(NlogN)
     * 空间复杂度 O(logN)
     *
     * @param matrix 二维矩阵
     * @param target 目标值
     * @return 索引
     */
    public boolean searchMatrix3(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        return searchRecursion(matrix, target, 0, 0, matrix[0].length - 1, matrix.length - 1);
    }

    public boolean searchRecursion(int[][] matrix, int target, int left, int up, int right, int down) {
        if (left > right || up > down) {
            return false;
        } else if (target < matrix[up][left] || target > matrix[down][right]) {
            return false;
        }

        int mid = left + (right - left) / 2;
        int row = up;
        while (row <= down && matrix[row][mid] <= target) {
            if (matrix[row][mid] == target) {
                return true;
            }
            row++;
        }

        return searchRecursion(matrix, target, left, row, mid - 1, down) || searchRecursion(matrix, target, mid + 1, up, right, row - 1);
    }

    /**
     * 搜索二维矩阵 II 行列搜索
     * 时间复杂度 O(M + N)
     * 空间复杂度 O(1)
     *
     * @param matrix 二维矩阵
     * @param target 目标值
     * @return 索引
     */
    public boolean searchMatrix4(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else {
                return true;
            }
        }
        return false;
    }
}
