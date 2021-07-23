import java.util.LinkedList;
import java.util.List;

/**
 * No.54 螺旋矩阵
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/23 20:15
 */
public class L0054SpiralMatrix {
    public static void main(String[] args) {

    }

    /**
     * 螺旋矩阵 模拟
     * 时间复杂度 O(MN)
     * 空间复杂度 O(MN)
     *
     * @param matrix 矩阵
     * @return 元素列表
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }

        int rows = matrix.length, cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int row = 0, col = 0;
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < rows * cols; i++) {
            ans.add(matrix[row][col]);
            visited[row][col] = true;
            int nextRow = row + direction[directionIndex][0];
            int nextCol = col + direction[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || visited[nextRow][nextCol]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += direction[directionIndex][0];
            col += direction[directionIndex][1];
        }
        return ans;
    }

    /**
     * 螺旋矩阵 按层模拟
     * 时间复杂度 O(MN)
     * 空间复杂度 O(1)
     *
     * @param matrix 矩阵
     * @return 元素列表
     */
    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> ans = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }

        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = cols - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int col = left; col <= right; col++) {
                ans.add(matrix[top][col]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                ans.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int col = right - 1; col > left; col--) {
                    ans.add(matrix[bottom][col]);
                }
                for (int row = bottom; row > top; row--) {
                    ans.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return ans;
    }
}
