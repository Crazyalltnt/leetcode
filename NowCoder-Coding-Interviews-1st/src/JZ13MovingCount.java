import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 13. 机器人的运动范围
 *
 * @author Neil
 * @version v1.0
 * @date 2022/1/14 16:51
 */
public class JZ13MovingCount {
    public static void main(String[] args) {

    }

    int m, n, k;
    boolean[][] visited;
    /**
     * 机器人的运动范围 深度优先遍历
     * 时间复杂度 O(MN)
     * 空间复杂度 O(MN)
     *
     * @param threshold 阈值
     * @param rows 行
     * @param cols 列
     * @return 可达数
     */
    public int movingCount(int threshold, int rows, int cols) {
        this.m = rows;
        this.n = cols;
        this.k = threshold;
        this.visited = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }

    public int dfs(int i, int j, int si, int sj) {
        if (i >= m || j >= n || k < si + sj || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj) + dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
    }

    /**
     * 机器人的运动范围 广度优先遍历
     * 时间复杂度 O(MN)
     * 空间复杂度 O(MN)
     *
     * @param threshold 阈值
     * @param rows 行
     * @param cols 列
     * @return 可达数
     */
    public int movingCount2(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 0});
        while (!queue.isEmpty()) {
            int[] x = queue.poll();
            int i = x[0];
            int j = x[1];
            int si = x[2];
            int sj = x[3];
            if (i >= rows || j >= cols || threshold < si + sj || visited[i][j]) {
                continue;
            }
            visited[i][j] = true;
            res++;
            queue.add(new int[] {i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj});
            queue.add(new int[] {i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8});
        }
        return res;
    }
}
