package array;

import java.util.*;

/**
 * No.56 合并区间
 * https://leetcode-cn.com/problems/merge-intervals
 * <p>
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 示例 2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * 提示：
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 *
 * @author Neil
 * @version v1.0
 * @date 2021/6/25 17:04
 */
public class L0056MergeIntervals {
    public static void main(String[] args) {
        // int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        // int[][] intervals = {{1, 4}, {0, 4}};
        int[][] intervals = {{1, 4}, {0, 0}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    /**
     * 合并区间 排序左端点
     * 时间复杂度 O()
     * 空间复杂度 O()
     *
     * @param intervals 数组集合
     * @return 合并后的数组
     */
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        List<int[]> merged = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < start) {
                merged.add(new int[] {start, end});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], end);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
