package com.leetcode.c1225;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 思路：时间O（N），空间O（N）
 * 遍历字符串中的每一个元素。借助一个辅助键值对来存储某个元素最后一次出现的下标。用一个整形变量存储当前无重复字符的子串开始的下标。
 */
public class LengthOfLongestSubstringTest {

    public static int lengthOfLongestSubstring(String s, String type) {
        int n = s.length();
        int maxLength = 0;
        // 双重循环暴力破解
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                System.out.print(i + "" + j + " ");
                //判断该字串是否唯一
                if (type != null) {
                    if (getZeroAndOne(s, i, j)) {
                        maxLength = Math.max(maxLength, j - i);
                    }
                } else {
                    if (allUnique(s, i, j)) {
                        maxLength = Math.max(maxLength, j - i);
                    }
                }

            }
            System.out.println();
        }
        return maxLength;
    }

    private static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int k = start; k < end; k++) {
            Character c = s.charAt(k);
            //判断该字串是否有重复数据
            if (set.contains(c)) {
                return false;
            }
            // 将字符添加到set集合里
            set.add(c);
        }
        return true;
    }

    private static boolean getZeroAndOne(String s, int start, int end) {
        for (int k = start; k < end - 1; k++) {
            Character c = s.charAt(k);
            //判断该字串是否有重复数据
            Character c2 = s.charAt(k + 1);
            //判断是否为01串
            if (c.equals(c2)) {
                return false;
            }
        }
        String substring = s.substring(start, end);
        System.out.println("substring :" + substring);
        return true;
    }

    public static void main(String[] args) {
        final String STRING = "tegwgqxxbdxhejxwsaqwpfiamrwqvruqxandqmcrrzyviytcylapsipezmxwfrpctcijqkahmbfwbazzmzogkgnlskkzdz";
        final String STRING2 = "010101011110000101011010101";

        int maxLength = LengthOfLongestSubstringTest.lengthOfLongestSubstring(STRING, null);
        int maxLength2 = LengthOfLongestSubstringTest.lengthOfLongestSubstring(STRING2, "1");
        System.out.println("maxLength:" + maxLength);
        System.out.println("maxLength2" + maxLength2);
    }
}
