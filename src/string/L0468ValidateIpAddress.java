package string;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.regex.Pattern;

/**
 * No.468 验证IP地址
 * https://leetcode-cn.com/problems/validate-ip-address
 *
 * 编写一个函数来验证输入的字符串是否是有效的 IPv4 或 IPv6 地址。
 *
 * 如果是有效的 IPv4 地址，返回 "IPv4" ；
 * 如果是有效的 IPv6 地址，返回 "IPv6" ；
 * 如果不是上述类型的 IP 地址，返回 "Neither" 。
 * IPv4 地址由十进制数和点来表示，每个地址包含 4 个十进制数，其范围为 0 - 255， 用(".")分割。比如，172.16.254.1；
 *
 * 同时，IPv4 地址内的数不会以 0 开头。比如，地址 172.16.254.01 是不合法的。
 *
 * IPv6 地址由 8 组 16 进制的数字来表示，每组表示 16 比特。这些组数字通过 (":")分割。比如, 2001:0db8:85a3:0000:0000:8a2e:0370:7334 是一个有效的地址。
 * 而且，我们可以加入一些以 0 开头的数字，字母可以使用大写，也可以是小写。所以， 2001:db8:85a3:0:0:8A2E:0370:7334 也是一个有效的 IPv6 address地址 (即，忽略 0 开头，忽略大小写)。
 *
 * 然而，我们不能因为某个组的值为 0，而使用一个空的组，以至于出现 (::) 的情况。 比如， 2001:0db8:85a3::8A2E:0370:7334 是无效的 IPv6 地址。
 *
 * 同时，在 IPv6 地址中，多余的 0 也是不被允许的。比如， 02001:0db8:85a3:0000:0000:8a2e:0370:7334 是无效的。
 *
 *
 * 示例 1：
 * 输入：IP = "172.16.254.1"
 * 输出："IPv4"
 * 解释：有效的 IPv4 地址，返回 "IPv4"
 *
 * 示例 2：
 * 输入：IP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
 * 输出："IPv6"
 * 解释：有效的 IPv6 地址，返回 "IPv6"
 *
 * 示例 3：
 * 输入：IP = "256.256.256.256"
 * 输出："Neither"
 * 解释：既不是 IPv4 地址，又不是 IPv6 地址
 *
 * 示例 4：
 * 输入：IP = "2001:0db8:85a3:0:0:8A2E:0370:7334:"
 * 输出："Neither"
 *
 * 示例 5：
 * 输入：IP = "1e1.4.5.6"
 * 输出："Neither"
 *
 * 提示：
 * IP 仅由英文字母，数字，字符 '.' 和 ':' 组成。
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/4 20:09
 */
public class L0468ValidateIpAddress {
    public static void main(String[] args) {

    }

    /**
     * 验证IP地址 内置函数
     * 时间复杂度 O()
     * 空间复杂度 O()
     *
     * @param IP ip地址
     * @return 标识
     */
    public String validIPAddress(String IP) {
        try {
            return (InetAddress.getByName(IP) instanceof Inet6Address) ? "IPv6" : "IPv4";
        } catch (Exception ignored) {}
        return "Neither";
    }

    /**
     * 验证IP地址 正则表达式
     * 时间复杂度 O(1)
     * 空间复杂度 O(1)
     *
     * @param IP ip地址
     * @return 标识
     */
    public String validIPAddress2(String IP) {
        String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
        Pattern patternIPv4 = Pattern.compile("^(" + chunkIPv4 + "\\.){3}"  + chunkIPv4 + "$");

        String chunkIPv6 = "([0-9a-fA-F]){1,4}";
        Pattern patternIPv6 = Pattern.compile("^(" + chunkIPv6 + ":){7}" + chunkIPv6 + "$");

        if (IP.contains(".")) {
            return (patternIPv4.matcher(IP).matches()) ? "IPv4" : "Neither";
        } else if (IP.contains(":")) {
            return (patternIPv6.matcher(IP).matches()) ? "IPv6" : "Neither";
        }
        return "Neither";
    }

    /**
     * 验证IP地址 分治法
     * 时间复杂度 O(1)
     * 空间复杂度 O(1)
     *
     * @param IP ip地址
     * @return 标识
     */
    public String validIPAddress3(String IP) {
        if (!IP.endsWith(".") && IP.contains(".")) {
            return validateIPv4(IP);
        } else if (!IP.endsWith(":") && IP.contains(":")) {
            return validateIPv6(IP);
        }
        return "Neither";
    }

    public String validateIPv4(String IP) {
        String[] chunk = IP.split("\\.");
        if (chunk.length != 4) {
            return "Neither";
        }

        for (String s : chunk) {
            if (s.length() == 0 || s.length() > 3) {
                return "Neither";
            }
            if (s.charAt(0) == '0' && s.length() != 1) {
                return "Neither";
            }
            for (char ch : s.toCharArray()) {
                if (!Character.isDigit(ch)) {
                    return "Neither";
                }
            }
            if (Integer.parseInt(s) > 255) {
                return "Neither";
            }
        }
        return "IPv4";
    }

    public String validateIPv6(String IP) {
        String[] chunk = IP.split(":");
        if (chunk.length != 8) {
            return "Neither";
        }

        String hexDigits = "0123456789abcdefABCDEF";
        for (String s : chunk) {
            if (s.length() == 0 || s.length() > 4) {
                return "Neither";
            }
            for (char ch : s.toCharArray()) {
                if (hexDigits.indexOf(ch) == -1) {
                    return "Neither";
                }
            }
        }
        return "IPv6";
    }
}
