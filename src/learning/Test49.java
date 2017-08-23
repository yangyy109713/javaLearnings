package learning;

import java.util.Scanner;

/**
 * Created by yuanyuanyang1 on 8/23/2017.
 * 题目：计算字符串中子串出现的次数
 */
public class Test49 {
    public static void main(String[] args){
        String s = "adeiijjffjfjabdkkjabdjkabdpopadcpead";//原字符串
        System.out.println("原字符串：" + s);
        String s1 = "ab";//子串
        int count = 0;
        while(true){
            int i = s.indexOf(s1);//indexOf(String str)  Returns the index within this string of the first occurrence of the specified substring.
            if(i != -1){
                //substring(int beginIndex, int endIndex) Returns a string that is a substring of this string.
                s = s.substring(i + s1.length() , s.length());
                count ++;//找到一次
            }else {
                break;//查找结束
            }
        }
        System.out.println("子串" + s1 + "出现了" + count + "次");
    }
}
