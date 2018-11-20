package com.fengying.util;

public class TextUtil {
    /**
     * 判断某一个字符串是否为空
     * @param c 输入字符串
     * @return 为空返回ture，不为空返回false
     */
    public static boolean isEmpty(CharSequence c){
        return c == null || c.length() == 0;
    }
}
