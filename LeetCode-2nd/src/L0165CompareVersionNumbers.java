import javafx.util.Pair;

/**
 * No.165 比较版本号
 *
 * @author Neil
 * @version v1.0
 * @date 2021/8/14 13:57
 */
public class L0165CompareVersionNumbers {
    public static void main(String[] args) {

    }

    /**
     * 比较版本号 拆分数组
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param version1 版本号1
     * @param version2 版本号2
     * @return 比较值
     */
    public int compareVersion(String version1, String version2) {
        String[] version1Array = version1.split("\\.");
        String[] version2Array = version2.split("\\.");
        int len1 = version1Array.length;
        int len2 = version2Array.length;
        for (int i = 0; i < Math.max(len1, len2); i++) {
            int revision1 = i < len1 ? Integer.parseInt(version1Array[i]) : 0;
            int revision2 = i < len2 ? Integer.parseInt(version2Array[i]) : 0;
            if (revision1 > revision2) {
                return 1;
            } else if (revision1 < revision2) {
                return -1;
            }
        }
        return 0;
    }

    /**
     * 比较版本号 双指针
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param version1 版本号1
     * @param version2 版本号2
     * @return 比较值
     */
    public int compareVersion2(String version1, String version2) {
        int len1 = version1.length(), len2 = version2.length();
        int p1 = 0, p2 = 0;
        int revision1, revision2;
        Pair<Integer, Integer> pair;
        while (p1 < len1 || p2 < len2) {
            pair = getNextChunk(version1, len1, p1);
            revision1 = pair.getKey();
            p1 = pair.getValue();

            pair = getNextChunk(version2, len2, p2);
            revision2 = pair.getKey();
            p2 = pair.getValue();

            if (revision1 != revision2) {
                return revision1 > revision2 ? 1 : -1;
            }
        }
        return 0;
    }

    public Pair<Integer, Integer> getNextChunk(String s, int n, int p) {
        if (p >= n) {
            return new Pair<>(0, p);
        }

        int end = p;
        while (end < n && s.charAt(end) != '.') {
            end++;
        }
        int revision = Integer.parseInt(s.substring(p, end));
        p = end + 1;
        return new Pair<>(revision, p);
    }

    /**
     * 比较版本号 双指针 简化
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param version1 版本号1
     * @param version2 版本号2
     * @return 比较值
     */
    public int compareVersion3(String version1, String version2) {
        int len1 = version1.length(), len2 = version2.length();
        int p1 = 0, p2 = 0;
        while (p1 < len1 || p2 < len2) {
            if (p1 < len1 && version1.charAt(p1) == '.') {
                p1++;
            }
            if (p2 < len2 && version2.charAt(p2) == '.') {
                p2++;
            }

            int revision1 = 0, revision2 = 0;
            while (p1 < len1 && version1.charAt(p1) != '.') {
                revision1 = revision1 * 10 + version1.charAt(p1) - '0';
                p1++;
            }
            while (p2 < len2 && version2.charAt(p2) != '.') {
                revision2 = revision2 * 10 + version2.charAt(p2) - '0';
                p2++;
            }
            if (revision1 != revision2) {
                return revision1 > revision2 ? 1 : -1;
            }
        }
        return 0;
    }
}
