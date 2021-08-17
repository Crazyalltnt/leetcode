/**
 * No.240 搜索二维矩阵 II
 *
 * @author Neil
 * @version v1.0
 * @date 2021/8/17 13:54
 */
public class L0240SearchA2DMatrixII {
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
        int n = matrix[0].length;
        for (int[] ints : matrix) {
            for (int j = 0; j < n; j++) {
                if (ints[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 搜索二维矩阵 II 二分
     * 时间复杂度 O(log(N!))
     * 空间复杂度 O(1)
     *
     * @param matrix 二维矩阵
     * @param target 目标值
     * @return 索引
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
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
        int right = vertical ? matrix[0].length - 1: matrix.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (vertical) {
                if (matrix[diagonal][mid] > target) {
                    right = mid - 1;
                } else if (matrix[diagonal][mid] < target) {
                    left = mid + 1;
                } else {
                    return true;
                }
            } else {
                if (matrix[mid][diagonal] > target) {
                    right = mid - 1;
                } else if (matrix[mid][diagonal] < target) {
                    left = mid + 1;
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
