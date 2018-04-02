package systemDemo;

import java.util.Arrays;

/**
 * Created by yuanyuanyang on 17/9/15.
 * java核心类：System
 */
public class SystemDemo {
    public static void main(String[] args){
        int[] a1 = {0 , 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8};
        int[] a2 = new int[10];
        System.out.println(Arrays.toString(a2));
        System.arraycopy(a1 , 3 , a2 , 4 , 5);
        System.out.println(Arrays.toString(a2));

        long time = System.currentTimeMillis();//1970 1 1 开始计算
        System.out.println(time);//毫秒

        //static void exit(int n);//退出程序（JVM），n = 0 正常结束
        System.exit(0);
        System.out.println(123);
    }
}
