package bfsdfs;

import java.util.Deque;
import java.util.LinkedList;

/**
 * No.695 岛屿的最大面积
 * https://leetcode-cn.com/problems/max-area-of-island
 *
 * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。
 * 你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 *
 * 示例 1:
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
 *
 * 示例 2:
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 *
 * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/8 11:43
 */
public class L0695MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxAreaOfIsland(grid));
    }

    static int maxArea = 0;
    static int curArea = 0;
    /**
     * 岛屿的最大面积
     * 时间复杂度 O()
     * 空间复杂度 O()
     *
     * @param grid 矩阵
     * @return 面积
     */
    public static int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                }
                maxArea = Math.max(maxArea, curArea);
                curArea = 0;
            }

        }
        return maxArea;
    }

    public static void dfs(int[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 0) {
            return;
        }

        grid[r][c] = 0;
        curArea++;
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    /**
     * 岛屿的最大面积
     * 时间复杂度 O()
     * 空间复杂度 O()
     *
     * @param grid 矩阵
     * @return 面积
     */
    public static int maxAreaOfIsland2(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    curArea++;
                    grid[i][j] = 0;
                    Deque<Integer> neighbors = new LinkedList<>();
                    neighbors.add(i * cols + j);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.pop();
                        int row = id / cols;
                        int col = id % cols;
                        if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                            neighbors.add((row - 1) * cols + col);
                            grid[row - 1][col] = 0;
                            curArea++;
                        }
                        if (row + 1 < rows && grid[row + 1][col] == 1) {
                            neighbors.add((row + 1) * cols + col);
                            grid[row + 1][col] = 0;
                            curArea++;
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                            neighbors.add(row * cols + col - 1);
                            grid[row][col - 1] = 0;
                            curArea++;
                        }
                        if (col + 1 < cols && grid[row][col + 1] == 1) {
                            neighbors.add(row * cols + col + 1);
                            grid[row][col + 1] = 0;
                            curArea++;
                        }
                    }
                    maxArea = Math.max(maxArea, curArea);
                    curArea = 0;
                }
            }

        }
        return maxArea;
    }
}
