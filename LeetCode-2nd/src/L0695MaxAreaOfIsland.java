import java.util.LinkedList;
import java.util.Queue;

/**
 * No.695 岛屿的最大面积
 *
 * @author Neil
 * @version v1.0
 * @date 2021/9/19 13:22
 */
public class L0695MaxAreaOfIsland {
    public static void main(String[] args) {

    }

    int maxArea = 0;
    int area = 0;
    /**
     * 岛屿的最大面积 深度优先 递归
     * 时间复杂度 O(MN)
     * 空间复杂度 O(MN)
     *
     * @param grid 岛屿数组
     * @return 最大面积
     */
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                }
                maxArea = Math.max(maxArea, area);
                area = 0;
            }
        }
        return maxArea;
    }

    public void dfs(int[][] grid, int row, int col) {
        int rows = grid.length, cols = grid[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0) {
            return;
        }
        grid[row][col] = 0;
        area++;

        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }

    /**
     * 岛屿的最大面积 广度优先搜索
     * 时间复杂度 O(MN)
     * 空间复杂度 O(MN)
     *
     * @param grid 岛屿数组
     * @return 最大面积
     */
    public int maxAreaOfIsland2(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int maxArea = 0, area = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    area++;
                    grid[i][j] = 0;
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.offer(i * cols + j);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.poll();
                        int row = id / cols;
                        int col = id % cols;
                        if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                            neighbors.offer((row - 1) * cols + col);
                            area++;
                            grid[row - 1][col] = 0;
                        }
                        if (row + 1 < rows && grid[row + 1][col] == 1) {
                            neighbors.offer((row + 1) * cols + col);
                            area++;
                            grid[row + 1][col] = 0;
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                            neighbors.offer(row * cols + col - 1);
                            area++;
                            grid[row][col - 1] = 0;
                        }
                        if (col + 1 < cols && grid[row][col + 1] == 1) {
                            neighbors.offer(row * cols + col + 1);
                            area++;
                            grid[row][col + 1] = 0;
                        }
                    }
                    maxArea = Math.max(maxArea, area);
                    area = 0;
                }
            }
        }
        return maxArea;
    }
}
