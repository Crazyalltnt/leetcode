import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 剑指 Offer 38. 字符串的排列
 *
 * @author Neil
 * @version v1.0
 * @date 2021/11/13 13:19
 */
public class Permutation {
    public static void main(String[] args) {

    }

    ArrayList<String> ans = new ArrayList();
    char[] c;
    /**
     * 字符串的排列
     * 时间复杂度 O(N!N)
     * 空间复杂度 O(N^2)
     *
     * @param str 字符串
     * @return 排列
     */
    public ArrayList<String> Permutation(String str) {
        c = str.toCharArray();
        dfs(0);;
        return ans;
    }

    public void dfs(int x) {
        if (x == c.length - 1) {
            ans.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if (set.contains(c[i])) {
                continue;
            }
            set.add(c[i]);
            swap(i, x);
            dfs(x + 1);
            swap(i, x);
        }
    }

    public void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }


    /**
     * 字符串的排列
     * 时间复杂度 O(N!N)
     * 空间复杂度 O(1)
     *
     * @param str 字符串
     * @return 排列
     */
    public ArrayList<String> Permutation2(String str) {
        ArrayList<String> ans = new ArrayList<>();
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        do {
            ans.add(new String(arr));
        } while (nextPermutation(arr));
        return ans;
    }

    public boolean nextPermutation(char[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        if (i < 0) {
            return false;
        }
        int j = arr.length - 1;
        while (j >= 0 && arr[i] >= arr[j]) {
            j--;
        }
        swap(arr, i, j);
        reverse(arr, i + 1);
        return true;
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void reverse(char[] arr, int start) {
        int left = start, right = arr.length - 1;
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }
}
