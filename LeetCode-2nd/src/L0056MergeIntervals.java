import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * No.56 合并区间
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/31 22:00
 */
public class L0056MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    /**
     * 合并区间
     * 时间复杂度 O(NlogN)
     * 空间复杂度 O(logN)
     *
     * @param intervals 数组
     * @return 合并区间
     */
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        List<int[]> list = new LinkedList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end && intervals[i][1] > end) {
                end = intervals[i][1];
            } else if (intervals[i][0] > end) {
                list.add(new int[] {start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        list.add(new int[] {start, end});
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
