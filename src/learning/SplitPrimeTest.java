package learning;

import java.util.Scanner;

/**
 * Created by yuanyuanyang1 on 8/3/2017.
 * 分解质因数，如90=2*3*3*5
 * 步骤：对n进行分解，首先要找到最小质因数k（最小质因数是2），然后判断：
 * 1）如果质因数k=n，则分解结束，打印出质因数。
 * 2）如果质因数k!=n，但n能被k整除，打印出k值，然后n=n/k，重复步骤1）。
 * 3）如果n不能被k整除，则k=k+1，重复执行步骤1）。
 * 质数定义：又称素数，在大于1的自然数中，除1和它本身外不再有其他的因数。
 */
public class SplitPrimeTest {
    public static void main(String[] args){
        //控制台输入数字
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i < 10 ; i++){
            System.out.println("请输入一个正整数：");
            int n = sc.nextInt();
            int k = 2;
            //质因数一定小于这个数本身
            System.out.print(n + " = ");
            while(k <= n) {
                if (k == n) {
                    System.out.println(k);//分解结束换行
                    break;//分解质因数结束
                } else if (n % k == 0) {
                    n = n / k;
                    System.out.print(k + "*");
                } else {
                    k++;
                }
            }
        }
    }
}
