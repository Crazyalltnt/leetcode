import java.util.Arrays;

/**
 * 剑指 Offer 45. 把数组排成最小的数
 *
 * @author Neil
 * @version v1.0
 * @date 2022/2/4 15:13
 */
public class JZ45PrintMinNumber {
    public static void main(String[] args) {

    }

    /**
     * 把数组排成最小的数
     * 时间复杂度 O(NlogN)
     * 空间复杂度 O(N)
     *
     * @param numbers 数组
     * @return 最小数
     */
    public String PrintMinNumber(int [] numbers) {
        String[] strings = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strings[i] = String.valueOf(numbers[i]);
        }
        quickSort(strings, 0, strings.length - 1);
        StringBuilder res = new StringBuilder();
        for (String string : strings) {
            res.append(string);
        }
        return res.toString();
    }

    public void quickSort(String[] strings, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left, j = right;
        String tmp = strings[i];
        while (i < j) {
            while ((strings[j] + strings[left]).compareTo((strings[left] + strings[j])) >= 0 && i < j) {
                j--;
            }
            while ((strings[i] + strings[left]).compareTo((strings[left] + strings[i])) <= 0 && i < j) {
                i++;
            }
            tmp = strings[i];
            strings[i] = strings[j];
            strings[j] = tmp;
        }
        strings[i] = strings[left];
        strings[left] = tmp;
        quickSort(strings, left, i - 1);
        quickSort(strings, i + 1, right);
    }

    /**
     * 把数组排成最小的数
     * 时间复杂度 O(NlogN)
     * 空间复杂度 O(N)
     *
     * @param numbers 数组
     * @return 最小数
     */
    public String PrintMinNumber2(int [] numbers) {
        String[] strings = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strings[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strings, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for (String string : strings) {
            res.append(string);
        }
        return res.toString();
    }
}
