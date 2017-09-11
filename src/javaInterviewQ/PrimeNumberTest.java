package javaInterviewQ;

/**
 * Created by yuanyuanyang1 on 8/1/2017.
 */
/*
输出101-200之间所有素数的总数，并输出每个素数
素数：又叫质数，只能被1和它本身整除
 */
public class PrimeNumberTest {
    public static void main(String[] args){
        new PrimeNumberTest().getPrimeNum(101 , 200);
    }

    public int getPrimeNum(int beginIndex , int lastIndex){
        int sum = 0;
        for(int i = beginIndex ; i <= lastIndex ; i++){
            boolean isPrime = false;
            //判断素数的方法：用一个数分别去除2到sqrt(这个数)，如果能被整除，则此数不是素数，反之是素数
            for(int j = 2 ; j <= Math.sqrt(i) ; j++){
                if(i % j == 0){
                    isPrime = false;
                    break;
                }else{
                    isPrime = true;
                }
            }
            if(isPrime){
                sum += i;
                System.out.println(i);
            }
        }
        System.out.println("所有素数之和是：" + sum);
        return sum;
    }

}
