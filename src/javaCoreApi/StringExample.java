package javaCoreApi;

/**
 * Created by yuanyuanyang on 17/9/19.
 */
public class StringExample {
    public static void main(String[] args){
        //test1();
        test2();
    }

    //获取以hello开头的文件的后缀名
    private static void test1(){
        String f = "abc.java;hello.will.java;hello.class;hello.txt";//不能用.分割，因为.是正则表达式的特殊字符
        String[] ss = f.split(";");//使用分号分割字符串，得到一个字符串数组
        for (String s : ss) {
            //System.out.println(s);
            if(s.startsWith("hello")){
                //获取文件后缀名：最后一个.之后的字符串
                int i = s.lastIndexOf(".");
                System.out.println(s.substring(i));//截取字符串：从i位置开始，截取到最后
            }
        }
    }

    //把单词首字母大写
    private static void test2(){
        String s = "yangyy";
        //先获取第一个字母，转换成大写
        String s1 = s.substring(0,1);
        //截取第一个字母之后的字符串
        String s2 = s.substring(1);
        //System.out.println(s1);
        //组成转换后的字符串
        System.out.println(s1.toUpperCase() + s2);
    }
}
