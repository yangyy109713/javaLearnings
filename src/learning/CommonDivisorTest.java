package learning;

import java.util.Scanner;

/**
 * Created by yuanyuanyang1 on 8/4/2017.
 * 求两个数m和n的最大公约数和最小公倍数。
 * 在循环中，只要除数不等于0，用较大数除以较小数，将小的作为下一轮循环的大数，取得的余数作为下一轮循环的较小的数，
 * 循环直到较小的数为0，返回较大的数，即为最大公约数。
 * 最小公倍数等于两数相乘除以最大公约数。
 */
public class CommonDivisorTest {
    public static int getDivisor(int x , int y){
        int t;
        if(x < y){
            t = x;
            x = y;
            y = t;
        }
        while(y != 0){
            if(x == y){
                return x;
            }else {
                int k = x % y;
                x = y;
                y = k;
            }
        }
        return x;
    }

    public static void main(String[] args){
        int m;
        int n;
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i < 2 ; i++){
            System.out.print("输入第一个数：");
            m = sc.nextInt();
            System.out.println(m);
            System.out.print("输入第二个数：");
            n = sc.nextInt();
            System.out.println(n);
            System.out.println("最大公约数是：" + getDivisor(m , n));
            System.out.println("最小公倍数是：" + (m * n) / getDivisor(m , n));
        }
    }
}
