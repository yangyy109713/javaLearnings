package learning;

/**
 * Created by yuanyuanyang1 on 8/15/2017.
 * 题目：求100之内的素数。
 */
public class AllPrimes {
    //使用sqrt()方法实现2/3无法判断，需单独处理
    public static void getPrimes1(){
        boolean is = true;
        System.out.print(2 + " " + 3 + " ");
        for(int i = 3 ; i < 100 ; i += 2){
            for(int j = 2 ; j <= Math.sqrt(i) ; j ++){
                if(i % j == 0){
                    is = false;
                    break;
                }else{
                    is = true;
                }
            }
            if(is){
                System.out.print(i + " ");
            }
        }
    }

    //使用除1位数素数得2位数素数的方法，效率高通用性差
    public static void getPrimes2(){
        int[] a = {2 , 3 , 5 , 7};
        for(int i = 0 ; i < 4 ; i++){
            System.out.print(a[i] + " ");
        }
        boolean is = true;
        for(int j = 11 ; j < 100 ; j += 2){
            for(int k = 0 ; k < 4 ; k++){
                if(j % a[k] == 0){
                    is = false;
                    break;
                }else {
                    is = true;
                }
            }
            if(is){
                System.out.print(j + " ");
            }
        }
    }

    public static void main(String[] args){
        //getPrimes1();
        getPrimes2();
    }
}
