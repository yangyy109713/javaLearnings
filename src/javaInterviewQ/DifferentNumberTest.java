package javaInterviewQ;

/**
 * Created by yuanyuanyang1 on 8/7/2017.
 * 题目：有1、2、3、4四个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
 * 分析：总共是4个数字，组成3位数，每位上数字都不一样
 */
public class DifferentNumberTest {
    public static void main(String[] args){
        int count = 0;
        for(int i = 1 ; i <= 4 ; i++){
            for(int j = 1 ; j <= 4 ; j++){
                for(int k = 1 ; k <= 4 ; k++){
                    if(i != j && j != k && i != k){
                        System.out.println((i * 100 + j * 10 + k) + "是无重复数字");
                        count ++;
                    }
                }
            }
        }
        System.out.println("共" + count +"个无重复数字三位数");
    }
}
