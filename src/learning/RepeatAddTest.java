package learning;

import java.util.Scanner;

/**
 * Created by yuanyuanyang1 on 8/4/2017.
 * 求s = a+aa+aaa+...+aaaaa...的值。
 * 数字以及共计算多少次由控制台输入（键盘输入）。
 */
public class RepeatAddTest {
    public static void main(String[] args){
        long a;
        long tmp = 0;
        long sum =0;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入数字：");
        a = sc.nextLong();
        System.out.print("，请输入相加多少次：");
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            tmp = tmp + a;
            sum = sum + tmp;
            a = a * 10;
        }
        System.out.println("计算结果：" + sum);
    }
}
