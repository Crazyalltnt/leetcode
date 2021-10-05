/**
 * No.79 单词搜索
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/5 15:56
 */
public class L0079WordSearch {
    public static void main(String[] args) {

    }

    /**
     * 单词搜索
     * 时间复杂度 O(MN * 3^L)
     * 空间复杂度 O(MN)
     *
     * @param board  数组
     * @param word 单词
     * @return 是否存在
     */
    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                boolean flag = check(board, visited, row, col, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] visited, int row, int col, String s, int k) {
        if (board[row][col] != s.charAt(k)) {
            return false;
        } else if (k == s.length() - 1) {
            return true;
        }

        visited[row][col] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] direction : directions) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            if (nextRow >= 0 && nextRow < board.length && nextCol >= 0 && nextCol < board[0].length && !visited[nextRow][nextCol]) {
                boolean flag = check(board, visited, nextRow, nextCol, s, k + 1);
                if (flag) {
                    result = true;
                    break;
                }
            }
        }
        visited[row][col] = false;
        return result;
    }
}
