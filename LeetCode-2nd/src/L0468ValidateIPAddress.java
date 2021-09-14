import java.util.regex.Pattern;

/**
 * No.468 验证IP地址
 *
 * @author Neil
 * @version v1.0
 * @date 2021/9/14 21:48
 */
public class L0468ValidateIPAddress {
    public static void main(String[] args) {

    }

    String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
    Pattern pattenIPv4 =
        Pattern.compile("^(" + chunkIPv4 + "\\.){3}" + chunkIPv4 + "$");

    String chunkIPv6 = "([0-9a-fA-F]{1,4})";
    Pattern pattenIPv6 =
        Pattern.compile("^(" + chunkIPv6 + ":){7}" + chunkIPv6 + "$");
    /**
     * 验证IP地址 正则表达式
     * 时间复杂度 O(1)
     * 空间复杂度 O(1)
     *
     * @param IP ip字符串
     * @return 校验结果
     */
    public String validIPAddress(String IP) {
        if (IP.contains(".")) {
            return (pattenIPv4.matcher(IP).matches()) ? "IPv4" : "Neither";
        }
        else if (IP.contains(":")) {
            return (pattenIPv6.matcher(IP).matches()) ? "IPv6" : "Neither";
        }
        return "Neither";
    }

    /**
     * 验证IP地址 分治
     * 时间复杂度 O(1)
     * 空间复杂度 O(1)
     *
     * @param IP ip字符串
     * @return 校验结果
     */
    public String validIPAddress2(String IP) {
        if (IP.chars().filter(ch -> ch == '.').count() == 3) {
            return validateIPv4(IP);
        } else if (IP.chars().filter(ch -> ch == ':').count() == 7) {
            return validateIPv6(IP);
        } else {
            return "Neither";
        }
    }

    public String validateIPv4(String IP) {
        String[] nums = IP.split("\\.", -1);
        for (String x : nums) {
            if (x.length() == 0 || x.length() > 3) {
                return "Neither";
            }
            if (x.charAt(0) == '0' && x.length() != 1) {
                return "Neither";
            }
            for (char ch : x.toCharArray()) {
                if (!Character.isDigit(ch)) {
                    return "Neither";
                }
            }
            if (Integer.parseInt(x) > 255) {
                return "Neither";
            }
        }
        return "IPv4";
    }

    public String validateIPv6(String IP) {
        String[] nums = IP.split(":", -1);
        String hexDigits = "0123456789abcdefABCEDF";
        for (String x : nums) {
            if (x.length() == 0 || x.length() > 4) {
                return "Neither";
            }
            for (char ch : x.toCharArray()) {
                if (hexDigits.indexOf(ch) == -1) {
                    return "Neither";
                }
            }
        }
        return "IPv6";
    }
}
