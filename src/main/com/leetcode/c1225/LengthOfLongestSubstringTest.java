package com.leetcode.c1225;

import java.util.*;

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
 * <p>
 * 方法二：滑动窗口
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

    /***
     * 第二种算法
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        //定义 i，j两个坐标
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            //判断当前字符是否在之前的 数组中
            if (!set.contains(s.charAt(j))) {
                //没有找到相同的字符
                //将它添加到set集合中
                set.add(s.charAt(j));
                //j 向后走一步
                j++;
                //获取j-i中的最大值
                ans = Math.max(ans, j - i);
            } else {
                //找到相同的字串，并将其从set中移除
                set.remove(s.charAt(i));
                // i向后走一步
                i++;
            }
        }
        //返回数组长度
        return ans;
    }

    /**
     * 上述的方法最多需要执行 2n 个步骤。事实上，它可以被进一步优化为仅需要 n 个步骤。我们可以定义字符到索引的映射，而不是使用集合来判断一个字符是否存在。 当我们找到重复的字符时，我们可以立即跳过该窗口。
     *
     * 也就是说，如果 s[j]s[j] 在 [i, j)[i,j) 范围内有与 j'j
     * ′
     *   重复的字符，我们不需要逐渐增加 ii 。 我们可以直接跳过 [i，j'][i，j
     * ′
     *  ] 范围内的所有元素，并将 ii 变为 j' + 1j
     * ′
     *  +1。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetcod/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public  int lengthOfLongestSubstring03(String s) {
        int n = s.length(), ans = 0;
        //创建map窗口,i为左区间，j为右区间，右边界移动
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            // 如果窗口中包含当前字符，
            if (map.containsKey(s.charAt(j))) {
                //左边界移动到 相同字符的下一个位置和i当前位置中更靠右的位置，这样是为了防止i向左移动
                i = Math.max(map.get(s.charAt(j)), i);
            }
            //比对当前无重复字段长度和储存的长度，选最大值并替换
            //j-i+1是因为此时i,j索引仍处于不重复的位置，j还没有向后移动，取的[i,j]长度
            ans = Math.max(ans, j - i + 1);
            // 将当前字符为key，下一个索引为value放入map中
            // value为j+1是为了当出现重复字符时，i直接跳到上个相同字符的下一个位置，if中取值就不用+1了
            map.put(s.charAt(j), j+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        final String STRING = "tegwgqxxbdxhejxwsaqwpfiamrwqvruqxandqmcrrzyviytcylapsipezmxwfrpctcijqkahmbfwbazzmzogkgnlskkzdz";
        final String STRING3 = "abcdabc";
        final String STRING2 = "010101011110000101011010101";
        LengthOfLongestSubstringTest lengthOfLongestSubstringTest = new LengthOfLongestSubstringTest();
        int maxLength = lengthOfLongestSubstringTest.lengthOfLongestSubstring2(STRING3);
//        int maxLength2 = LengthOfLongestSubstringTest.lengthOfLongestSubstring(STRING2, "1");
        System.out.println("maxLength:" + maxLength);
//        System.out.println("maxLength2" + maxLength2);
    }
}
