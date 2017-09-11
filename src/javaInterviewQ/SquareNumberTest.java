package javaInterviewQ;

/**
 * Created by yuanyuanyang1 on 8/8/2017.
 * 题目：一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少？
 * 完全平方数：完全平方即用一个整数乘以自己例如1*1，2*2，3*3等，依此类推。
 * 若一个数能表示成某个整数的平方的形式，则称这个数为完全平方数。完全平方数是非负数，而一个完全平方数的项有两个。
 */
public class SquareNumberTest {
    //打印出所有100000以内满足条件的数
    public static void getNum(){
        for (int i = 1 ; i < 100000 ; i++){
            if(Math.sqrt(i + 100) % 1 == 0){
                if(Math.sqrt(i + 268) % 1 == 0){
                    System.out.println( i + "加上100后是一个完全平方数，再加上168又是一个完全平方数");
                }
            }
        }
    }

    //打印出所有1000以内的完全平方数
    public static void getNums(){
        for (int i = 0 ; i < 1000 ; i++){
            if(Math.sqrt(i) % 1 == 0){
                System.out.println(i + "是完全平方数,完全平方=" + (int)Math.sqrt(i) + "*" + (int)Math.sqrt(i));
            }
        }
    }
    public static void main(String[] args){
        getNum();
        getNums();
    }
}
