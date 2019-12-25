package com.diyicibishi;

/**
 * 字符串 ‘111100011010101’
 * 寻找最长的反复子串，以及它的长度
 * //todo 待解决
 */
public class Test02 {
    //初始化数据
    String string = "0010100";

    public String getString(String string) {
        int length = string.length();
        int maxLength = 0;
        int maxIndex =0;

        for (int i = 0; i <length ; i++) {
            if (i<length && string.charAt(i) != string.charAt(i + 1) ) {
                maxLength++;
                maxIndex= i;
                System.out.println(maxIndex);
            }else {

            }
        }
        return string;
    }

    public static void main(String[] args) {
        Test02 test02 = new Test02();
        String string = "0010100";
        test02.getString(string);
    }
}
