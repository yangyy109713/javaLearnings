package javaInterviewQ;

/**
 * Created by yuanyuanyang1 on 8/23/2017.
 * 题目：求0—7所能组成的奇数个数.
 */
/*
题目分析：组成奇数的数字只能从0，1，2，3，4，5，6，7中选；奇数指最后一位（个位）上是奇数的所有数；使用排列组合方式组所有奇数（以0结尾的肯定不是奇数）。
1位奇数：1，3，5，7；
2位奇数：11，13，15，17，21，23，25，27，... 71，73，75，77 奇数共4*7个
3位奇数：2位奇数分别加上0-7（总共8个数）排列组合 奇数共4*7*8个
4位奇数：3位奇数再分别加上0-7排列组合 奇数共4*7*8*8个
*/
public class Test43 {
    public static void main(String[] args){
        long count = 0;//XX位奇数个数
        long sum = 0;//奇数总数
        for(int i = 1 ; i < 9 ; i ++){
            if(i == 1){
                count = 4;
            }
            else if(i == 2){
                count *= 7;
            }else{
                count *= 8;
            }
            sum += count;
            System.out.println("组成" + i + "位奇数" + count + "个");
        }
        System.out.println("0-7组成的奇数总数：" + sum);
    }
}
