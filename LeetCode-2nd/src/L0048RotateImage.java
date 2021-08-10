/**
 * No.48 旋转图像
 *
 * @author Neil
 * @version v1.0
 * @date 2021/8/10 16:21
 */
public class L0048RotateImage {
    public static void main(String[] args) {

    }

    /**
     * 旋转图像 模拟 原地旋转
     * 时间复杂度 O(N^2)
     * 空间复杂度 O(1)
     *
     * @param matrix 图像矩阵
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }

    /**
     * 旋转图像 翻转图像
     * 时间复杂度 O(N^2)
     * 空间复杂度 O(1)
     *
     * @param matrix 图像矩阵
     */
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
