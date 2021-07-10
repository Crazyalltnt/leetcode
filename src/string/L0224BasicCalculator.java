package string;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * No.224 基本计算器
 * https://leetcode-cn.com/problems/basic-calculator
 *
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 示例 1：
 * 输入：s = "1 + 1"
 * 输出：2
 *
 * 示例 2：
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 *
 * 示例 3：
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 *
 * 提示：
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/10 21:14
 */
public class L0224BasicCalculator {
    public static void main(String[] args) {

    }

    /**
     * index全局变量,递归时方便使用
     */
    int index = 0;

    /**
     * 基本计算器 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(logN)
     *
     * @param s 字符串表达式
     * @return 计算值
     */
    public int calculate(String s){
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        char op = '+';
        int num = 0;
        while(index < s.length()){
            char c = s.charAt(index++);
            //如果是数字转换为int型
            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }
            //遇到括号,就递归解决
            if(c == '('){
                num = calculate(s);
            }
            //如果不是,就把符号后边的数字处理后加入栈中
            if((!Character.isDigit(c) && c != ' ') || index == s.length()){
                int tmp;
                switch(op){
                    case  '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                    case '/' :
                        stack.push(stack.pop() / num);
                        break;
                    default:
                        break;
                }
                //重新归0,操作符设置为c;
                num = 0;
                op = c;
            }
            //遇到右括号就停止计算
            if(c == ')'){
                break;
            }
        }

        //计算总数并返回
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }

    /**
     * 基本计算器
     * 时间复杂度 O()
     * 空间复杂度 O()
     *
     * @param s 字符串表达式
     * @return 计算值
     */
    public int calculate2(String s) {
        Deque<Integer> ops = new LinkedList<Integer>();
        ops.push(1);
        int sign = 1;

        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }
}
