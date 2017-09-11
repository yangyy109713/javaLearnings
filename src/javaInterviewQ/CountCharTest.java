package javaInterviewQ;

import java.util.Scanner;

/**
 * Created by yuanyuanyang1 on 8/4/2017.
 * 输入一串字符串，分别统计数字、英文字母、空格和其他字符的个数。
 */
public class CountCharTest {
    public static void getChars(String s){
        int numCount = 0;
        int characterCount = 0;
        int blankCount = 0;
        int otherCount = 0;
        //将字符串转换成字符数组
        char[] c = s.toCharArray();
        for(int i = 0 ; i < c.length ; i++){
            if(c[i] >= '0' && c[i] <= '9'){
                numCount ++;
            }
            else if((c[i] >= 'a' && c[i] <= 'z') || (c[i] >= 'A' && c[i] <= 'Z')){
                characterCount ++;
            }
            else if(c[i] == ' '){
                blankCount ++;
            }
            else {
                otherCount ++;
            }
        }
        System.out.println("数字个数：" + numCount);
        System.out.println("英文字母个数：" + characterCount);
        System.out.println("空格个数：" + blankCount);
        System.out.println("其他字符个数：" + otherCount);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一行字符串：");
        String s = sc.nextLine();
        getChars(s);
    }
}
