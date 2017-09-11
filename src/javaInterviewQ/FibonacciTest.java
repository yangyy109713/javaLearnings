package javaInterviewQ;

/**
 * Created by yuanyuanyang1 on 8/1/2017.
 */
public class FibonacciTest {
    /*
     *斐波那契数列：1、1、2、3、5、8、13、21、34......
     */
    //实现方式一
    public void getFibonacci1(int month){
        int f1 = 1;
        int f2 = 1;
        int f;
        System.out.println("第1个月兔子对数：" + f1);
        System.out.println("第2个月兔子对数：" + f2);
        for(int i = 3 ; i <= month ; i++){
            f = f2;
            f2 = f1 +f2;
            f1 = f;
            System.out.println("第" + i + "个月兔子对数：" + f2);
        }
    }

    //实现方式二
    public int getFibonacci2(int month){
        int f = 1;
        if(month == 1){
            return f;
        }
        if(month == 2){
            return f;
        }
        else if(month > 2){
            int sum = getFibonacci2(month - 1) + getFibonacci2(month - 2);
            return sum;
        }
        return f;
    }

    public static void main(String[] args){
        //打印12个月中每个月兔子对数
        System.out.println("=====方式一=====");
        new FibonacciTest().getFibonacci1(12);

        System.out.println("=====方式二=====");
        for (int i = 1 ; i <= 12 ; i++){
            System.out.println("第" + i + "个月兔子对数：" + new FibonacciTest().getFibonacci2(i));
            continue;
        }
    }
}
