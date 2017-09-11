package javaInterviewQ;

/**
 * Created by yuanyuanyang1 on 8/11/2017.
 * 题目：有5个人坐在一起，问第五个人多少岁？他说比第4个人大2岁。问第4个人岁数，他说比第3个人大2岁。
 * 问第三个人，又说比第2人大两岁。问第2个人，说比第一个人大两岁。最后问第一个人，他说是10岁。请问第五个人多大？
 */
public class JudeAgeTest {
    public static void main(String[] args){
        int age = 10;//第一个人10岁
        //有题意可知，从第二个人开始，第n个人比第n-1个人大岁，共5个人
        for(int i = 2 ; i <= 5 ; i++){
            age += 2;
        }
        System.out.println("第五个人" + age + "岁。");
    }
}
