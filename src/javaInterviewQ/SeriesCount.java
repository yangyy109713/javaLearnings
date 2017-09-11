package javaInterviewQ;

/**
 * Created by yuanyuanyang1 on 8/10/2017.
 * 题目：有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和。
 */
public class SeriesCount {
    public static void main(String[] args){
        double sum = 0 ;
        int d = 1;
        int u = 2;
        for(int i = 1 ; i <= 20 ; i++){
            System.out.println("第" + i + "列的值是" + (double)u / d);
            sum += (double)u / d;
            int t = d;
            d = u;
            u += t;
        }
        System.out.println(sum);
    }
}
