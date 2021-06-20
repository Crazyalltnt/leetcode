package bfsdfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * No.200 岛屿数量
 * https://leetcode-cn.com/problems/number-of-islands
 * <p>
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * 示例 1：
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * 输出：3
 * <p>
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 *
 * @author Neil
 * @version v1.0
 * @date 2021/6/20 11:02
 */
public class L0200NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'},
                         {'1', '1', '0', '1', '0'},
                         {'1', '1', '0', '0', '0'},
                         {'0', '0', '0', '0', '0'}};

        System.out.println(numIslands2(grid));
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
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int numOfIslands = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    numOfIslands++;
                    dfs(grid, r, c);
                }
            }

        }
        return numOfIslands;
    }

    public void dfs(char[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    /**
     * 岛屿数量 广度优先搜索
     * 时间复杂度 O(MN)
     * 空间复杂度 O(MN)
     *
     * @param grid 网格
     * @return 岛屿数量
     */
    public static int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int numOfIslands = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    numOfIslands++;
                    grid[r][c] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * cols + c);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / cols;
                        int col = id % cols;
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            neighbors.add((row - 1) * cols + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < rows && grid[row + 1][col] == '1') {
                            neighbors.add((row + 1) * cols + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            neighbors.add(row * cols + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < cols && grid[row][col + 1] == '1') {
                            neighbors.add(row * cols + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }
        return numOfIslands;
    }
}
