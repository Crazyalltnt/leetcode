import java.util.LinkedList;
import java.util.List;

/**
 * No.93 复原 IP 地址
 *
 * @author Neil
 * @version v1.0
 * @date 2021/8/14 10:22
 */
public class L0093RestoreIPAddresses {
    public static void main(String[] args) {

    }

    static final int SEG_COUNT = 4;
    int[] segments = new int[SEG_COUNT];
    List<String> ans = new LinkedList<>();
    /**
     * 复原 IP 地址
     * 时间复杂度 O()
     * 空间复杂度 O()
     *
     * @param s 字符串0
     * @return ip
     */
    public List<String> restoreIpAddresses(String s) {
        backtrack(s, 0, 0);
        return ans;
    }

    public void backtrack(String s, int segId, int segStart) {
        // 如果找到了 4 段 IP 地址并且遍历完了字符串，那么就是一种答案
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuilder ip = new StringBuilder();
                for (int i = 0; i < SEG_COUNT; i++) {
                    ip.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ip.append(".");
                    }
                }
                ans.add(ip.toString());
            }
            return;
        }

        // 如果还没有找到 4 段 IP 地址就已经遍历完了字符串，那么提前回溯
        if (segStart == s.length()) {
            return;
        }

        // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            backtrack(s, segId +1, segStart + 1);
        }

        // 一般情况，枚举每一种可能性并递归
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); segEnd++) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 255) {
                segments[segId] = addr;
                backtrack(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }
}
