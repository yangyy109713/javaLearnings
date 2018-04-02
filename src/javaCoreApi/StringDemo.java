package javaCoreApi;

import java.util.Arrays;

/**
 * Created by yuanyuanyang on 17/9/18.
 */
public class StringDemo {
    public static void main(String[] args){
        //buildString();
        //getStringInfo();
        //compare();
        //conversion();
        //notNull("");
        System.out.println(isBlank("ui"));
    }

    //判断字符串为空
    private static boolean isBlank(String s){
        //return s == null || "".equals(s.trim());
        //代码简化
        return !hasLength(s);
    }

    //判断字符串非空
    private static boolean hasLength(String s){
        //s.trim()：去除首位空格
        /*if(s != null && !"".equals(s.trim())){
            return true;
        }
        return false;*/
        //代码简化
        return s != null && !"".equals(s.trim());
    }

    /**
     * 判断字符串非空
     */
    private static void notNull(String s){
        String s1 = "";//为空
        String s2 = " ";//为空
        String s3 = null;//为空
        //判断字符串非空
        //s.trim()：去除首位空格
        if(hasLength(s)){
            System.out.println("not null");
        }else{
            System.out.println("null content");
        }
    }

    /**
     * 字符串大小写转换
     * String toLowerCase();//转换成小写
     * String toUpperCase();//转换成大写
     */
    private static void conversion(){
        System.out.println("ABD".toLowerCase());
        System.out.println("abc".toUpperCase());
    }

    /**
     * 字符串的比较
     * boolean equals(Object obj);//将此字符串与制定对象比较
     * boolean equalsIgnoreCase(String str);//将此字符串与另一个字符串比较
     * boolean contentEquals(CharSequence chs);//将此字符串与制定的CharSequence比较
     */
    private static void compare(){
        String str1 = new String("abcde");
        String str2 = new String("abcde");
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        System.out.println("ABCDE".equals(str1));
        System.out.println("ABCDE".equalsIgnoreCase(str1));

        CharSequence c = "abcde";
        System.out.println(str1.contentEquals(c));
    }

    /**
     * 获取字符串信息
     * int length();//获取字符串长度
     * char charAt(int index);//返回制定地址的char值
     * int indexOf(String str);//返回制定字符串在此字符串中第一次出现处的索引
     * int lastIndexOf(String str);//返回制定字符串在此字符串中最右边出现处的索引
     */

    private static void getStringInfo(){
        String str = "bcdefcdeabcdefiop";
        System.out.println(str.length());
        System.out.println(str.charAt(0));
        System.out.println(str.charAt(3));
        System.out.println(str.indexOf("cde"));
        System.out.println(str.lastIndexOf("cde"));
    }

    /*
    * String类的创建和转换
    * char[] toCharArray();//把String转换成char数组
    * String(char[] values);//使用char数组创建String对象
    * byte[] getBytes();//把String转换成byte数组
    * String(byte[] bytes);//使用byte数组创建String对象
     */
    private static void buildString(){
        char[] cs = {'a' , 'b' , 'c'};
        String s1 = new String(cs);
        System.out.println(s1);
        System.out.println(s1.toCharArray());

        System.out.println(Arrays.toString(("ABCD").getBytes()));
        System.out.println(new String(("ABCD").getBytes()));
    }
}
