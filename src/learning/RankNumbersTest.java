package learning;

/**
 * Created by yuanyuanyang on 17/8/9.
 * 题目：输入三个整数x,y,z，请把这三个数由小到大输出。
 */
public class RankNumbersTest {
    public static void sort(int x , int y , int z){
        if(x >= y){
            int t = x;
            x = y;
            y = t;
        }
        if(x >= z){
            int t = x;
            x = z;
            z = t;
        }
        if(y >= z){
            int t = y;
            y = z;
            z = t;
        }
        System.out.println(x + "," + y + "," + z);
    }

    public static void main(String[] args){
        sort(7,6,5);
    }
}
