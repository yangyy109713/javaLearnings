package learning;

import java.util.Scanner;

/**
 * Created by yuanyuanyang1 on 8/23/2017.
 * 题目：一个偶数总能表示为两个素数之和。
 * 由于用除sqrt(n)的方法求出的素数不包括2和3，因此在判断是否是素数程序中人为添加2和3。
 * 最小的可表示为两个素数之和的偶数是6=3+3。
 */
public class Test44 {
    //判断是不是素数的方法
    static boolean fun(int a){
        boolean flag = true;
        if(a == 3 || a == 2){
            return flag;
        }
        for(int i = 2 ; i <= Math.sqrt(a) ; i ++){
            if(a % i == 0){
                flag = false;
                break;//能被2~Math.sqrt(a)中任意一个数整除，则不是素数
            }else{
                flag = true;
            }
        }
        return flag;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a ;
        do{
            System.out.print("输入一个大于等于6的偶数：");
            a = sc.nextInt();
        }while(a < 6 || (a % 2 != 0));//如果不是偶数或数字小于6，则重新输入
        for(int i = 2 ; i <= a / 2 ; i ++){
            if(fun(i) && fun(a - i)){
                int j = a - i;
                System.out.println(a + " = " + i +" + " + j);//打印所有可能的素数对
            }
        }
    }
}
