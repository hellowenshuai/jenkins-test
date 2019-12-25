package com.diyicibishi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * java 找出所有最长连续重复子串及其个数
 */

//定义结果集
class Pair {
    int n;
    String s;

    Pair(int n, String s) {
        this.n = n;
        this.s = s;
    }
}

public class Test03 {
    public static List<Pair> fun(String str) {
        // 所有字串集合
        List<String> subs = new ArrayList<String>();
        // 返回的结果集合
        List<Pair> res = new ArrayList<Pair>();
        // 获取字符串的长度
        int len = str.length();
        // 将所有字串都放在subs集合里
        for (int i = 0; i < len; i++) {
            String temp = str.substring(i, str.length());
            subs.add(temp);
        }
        //定义最大个数
        int maxCount = 1;
        //定义字串
        String sub = "";
        //定义字串的长度
        int subLen = 1;
        //定义个数
        int count = 1;

        //i为子串的长度
        for (int i = 1; i < len; i++) {
            //表示字串的前一个
            for (int j = 0; j < len - 1; j++) {

                count = 1;
                for (int k = j + 1; k <= j + i && subs.get(k).length() >= i; k++) {
                    String sub1 = subs.get(k).substring(0, i);
                    String sub2 = subs.get(j).substring(0, i);
                    if (sub1.equals(sub2)) {
                        count = count + 1;
                        break;
                    }
                }
                if (count >= 2) {
                    if (i > subLen) {
                        res.clear();
                    }

                    sub = subs.get(j).substring(0, i);
                    maxCount = count;
                    res.add(new Pair(maxCount, sub));
                    subLen = i;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Pair> res = new ArrayList<Pair>();
        while (sc.hasNext()) {
            String s = sc.nextLine();
            res = fun(s);
            for (Pair result : res) {
                System.out.println(result.s + " " + result.n);
            }
        }

    }
}
