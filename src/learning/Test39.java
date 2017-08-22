package learning;

import java.util.Scanner;

/**
 * Created by yuanyuanyang1 on 8/18/2017.
 * 题目：编写一个函数，输入n为偶数时，调用函数求1/2+1/4+...+1/n,当输入n为奇数时，调用函数1/1+1/3+...+1/n(利用指针函数).
 */
public class Test39 {
    static double sum(int n){
        double sum = 0;
            if(n % 2 == 0){
                for(int i = 2 ; i <= n ; i += 2){
                    sum += (double)1 / i;
                }
            }
            if(n % 2 == 1){
                for(int i = 1 ; i <= n ; i += 2){
                    sum += (double)1 / i;
                }
            }
        return sum;
    }

    static double sum1(int n){
        double sum = 0;
        if(n < 0){
            return sum;
        }else{
            do{
                sum += (double)1 / n;
                n -= 2;
            }while(n > 0);
        }
        return sum;
    }

    public static void main(String[] args){
        System.out.print("输入一个整数：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println();
        System.out.println("方法一，和是：" + sum(n));
        System.out.println("方法二，和是：" + sum1(n));
    }
}
