package javaInterviewQ;

/**
 * Created by yuanyuanyang1 on 8/11/2017.
 * 题目：求1+2!+3!+...+20!的和。
 */
public class FactorialTest {
    public static long getFactorial(int n){
        if(n != 1){
            return n * getFactorial(n - 1);
        }else {
            return 1;
        }
    }

    public static long getFactorial1(int n){
        long fac = 1;
        long sum = 0;
        for(int i = 1 ; i <= n ; i++){
            fac *= i;
            sum += fac;
        }
        return sum;
    }
    public static void main(String[] args){
        //方法一
        long sum = 0;
        for(int i = 1 ; i <= 20 ; i++){
            //System.out.println(i + "! = " + getFactorial(i));//for test
            sum += getFactorial(i);
        }
        System.out.println("（方法一）1+2!+3!+...+20!的和是：" + sum);

        //方法二
        System.out.println("（方法二）1+2!+3!+...+20!的和是：" + getFactorial1(20));
    }
}
