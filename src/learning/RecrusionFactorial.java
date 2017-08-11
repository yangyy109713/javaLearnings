package learning;

/**
 * Created by yuanyuanyang1 on 8/11/2017.
 * 题目：利用递归方法求5!
 */
public class RecrusionFactorial {
    public static long getRucrution(int n){
        if(n != 1){
            return n * getRucrution(n - 1);
        }else {
            return 1;
        }
    }
    public static void main(String[] args){
        System.out.println("5!等于" + getRucrution(5));
    }
}
