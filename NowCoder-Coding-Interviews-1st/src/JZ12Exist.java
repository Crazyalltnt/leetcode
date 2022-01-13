/**
 * 剑指 Offer 12. 矩阵中的路径
 *
 * @author Neil
 * @version v1.0
 * @date 2022/1/13 17:09
 */
public class JZ12Exist {
    public static void main(String[] args) {

    }

    /**
     * 矩阵中的路径
     * 时间复杂度 O()
     * 空间复杂度 O()
     *
     * @param matrix 矩阵
     * @param word 字符串
     * @return 是否存在
     */
    public boolean hasPath(char[][] matrix, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (dfs(matrix, words, i, j, 0)) {
                    return true;
                }
            }

        }
        return false;
    }

    public boolean dfs(char[][] matrix, char[] word, int i, int j, int k) {
        if (i >= matrix.length || i < 0 || j >= matrix[0].length || j < 0 || matrix[i][j] != word[k]) {
            return false;
        }
        if (k == word.length - 1) {
            return true;
        }
        char tmp = matrix[i][j];
        matrix[i][j] = '.';
        boolean res = dfs(matrix, word, i + 1, j, k + 1) || dfs(matrix, word, i - 1, j, k + 1) || dfs(matrix, word, i, j - 1, k + 1) || dfs(matrix, word, i, j + 1, k + 1);
        matrix[i][j] = tmp;
        return res;
    }
}
