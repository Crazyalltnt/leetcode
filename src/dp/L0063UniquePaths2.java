package dp;

/**
 * No.63 不同路径II
 * https://leetcode-cn.com/problems/unique-paths-ii
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 示例 1：
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 *
 * 示例 2：
 * 输入：obstacleGrid = [[0,1],[0,0]]
 * 输出：1
 *
 * @author Neil
 * @version v1.0
 * @date 2021/3/17 21:31
 */
public class L0063UniquePaths2 {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        // int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        // int[][] obstacleGrid = {{1, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        // int[][] obstacleGrid = {{1}};
        System.out.println(uniquePathsWithObstacles3(obstacleGrid));
    }

    /**
     * 获取路径数量 动态规划
     * 时间复杂度 O(MN)
     * 空间复杂度 O(MN)
     *
     * @param obstacleGrid 网格
     * @return 路径数量
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    if (obstacleGrid[i][j - 1] == 0) {
                        dp[i][j] = dp[i][j - 1];
                    } else {
                        dp[i][j] = 0;
                    }
                } else if (j == 0) {
                    if (obstacleGrid[i - 1][j] == 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = 0;
                    }
                } else {
                    if (obstacleGrid[i - 1][j] == 0 && obstacleGrid[i][j - 1] == 0) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    } else if (obstacleGrid[i - 1][j] == 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else if (obstacleGrid[i][j - 1] == 0) {
                        dp[i][j] = dp[i][j - 1];
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }
        }
        return obstacleGrid[m - 1][n - 1] == 0 ? dp[m - 1][n - 1] : 0;
    }

    /**
     * 获取路径数量 动态规划 条件判断优化
     * 时间复杂度 O(MN)
     * 空间复杂度 O(MN)
     *
     * @param obstacleGrid 网格
     * @return 路径数量
     */
    public static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0 && obstacleGrid[i][j - 1] == 0) {
                    dp[i][j] = dp[i][j - 1];
                } else if (j == 0 && obstacleGrid[i - 1][j] == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else if (i != 0 && j != 0) {
                    if (obstacleGrid[i - 1][j] == 0 && obstacleGrid[i][j - 1] == 0) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    } else if (obstacleGrid[i - 1][j] == 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else if (obstacleGrid[i][j - 1] == 0) {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        }
        return obstacleGrid[m - 1][n - 1] == 0 ? dp[m - 1][n - 1] : 0;
    }

    /**
     * 获取路径数量 动态规划 另一种迭代条件
     * 时间复杂度 O(MN)
     * 空间复杂度 O(MN)
     *
     * @param obstacleGrid 网格
     * @return 路径数量
     */
    public static int uniquePathsWithObstacles3(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 0) {
                dp[0][i] = dp[0][i - 1];
            }
        }

        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = dp[i - 1][0];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 获取路径数量 动态规划 另一种迭代条件 空间优化
     * 时间复杂度 O(MN)
     * 空间复杂度 O(N)
     *
     * @param obstacleGrid 网格
     * @return 路径数量
     */
    public static int uniquePathsWithObstacles4(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];

        dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                    continue;
                }
                if (j >= 1 && obstacleGrid[i][j - 1] == 0) {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }
}
