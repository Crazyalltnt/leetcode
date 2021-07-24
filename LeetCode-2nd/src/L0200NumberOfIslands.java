import java.util.LinkedList;
import java.util.Queue;

/**
 * No.200 岛屿数量
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/24 8:54
 */
public class L0200NumberOfIslands {
    public static void main(String[] args) {

    }

    /**
     * 岛屿数量 深度优先搜索
     * 时间复杂度 O(MN)
     * 空间复杂度 O(MN)
     *
     * @param grid 网格
     * @return 岛屿数量
     */
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int numberOfIslands = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    numberOfIslands++;
                    dfs(grid, row, col);
                }
            }
        }
        return numberOfIslands;
    }

    public void dfs(char[][] grid, int row, int col) {
        int rows = grid.length, cols = grid[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }

    /**
     * 岛屿数量 广度优先搜索
     * 时间复杂度 O(MN)
     * 空间复杂度 O(min(M,N))
     *
     * @param grid 网格
     * @return 岛屿数量
     */
    public int numIslands2(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int numberOfIslands = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    numberOfIslands++;
                    grid[row][col] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(row * cols + col);
                    while (!neighbors.isEmpty()) {
                        int index = neighbors.poll();
                        int r = index / cols;
                        int c = index % cols;
                        if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                            grid[r - 1][c] = '0';
                            neighbors.offer((r - 1) * cols + c);
                        }
                        if (r + 1 < rows && grid[r + 1][c] == '1') {
                            grid[r + 1][c] = '0';
                            neighbors.offer((r + 1) * cols + c);
                        }
                        if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                            grid[r][c - 1] = '0';
                            neighbors.offer(r * cols + c - 1);
                        }
                        if (c + 1 < cols && grid[r][c + 1] == '1') {
                            grid[r][c + 1] = '0';
                            neighbors.offer(r * cols + c + 1);
                        }
                    }
                }
            }
        }
        return numberOfIslands;
    }

    /**
     * 岛屿数量 并查集
     * 时间复杂度 O()
     * 空间复杂度 O()
     *
     * @param grid 网格
     * @return 岛屿数量
     */
    public int numIslands3(char[][] grid) {
        // TODO
        return 0;
    }
}
