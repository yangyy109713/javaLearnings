package learning;

/**
 * Created by yuanyuanyang1 on 8/2/2017.
 * 打印出所有的水仙花数
 * 水仙花数：指一个三位数，各个位上数字的立方和等于该数本身
 */
public class DaffodilTest {

    //实现方式一
    public static void getDaffodilNum(int beginIndex , int lastIndex){
        int count = 0;
        for(int i = beginIndex ; i <= lastIndex ; i++){
            if(beginIndex > 100 && lastIndex < 1000){
                int first = i / 100;
                int second = (i - first * 100) / 10;
                int third = (i - first * 100) % 10;
                if(i == (first * first * first + second * second * second + third * third *third)){
                    count ++ ;
                    System.out.println(i + " 是水仙花数!");
                }
            }

        }
        System.out.println("总共有" + count + "个水仙花数！");
    }
    //实现方式二
    public static void getDaffodil(){
        int count = 0;
        for(int i = 101 ; i < 1000 ; i++){
            int f = i / 100;
            int s = i % 100 / 10;
            int t = i % 10;
            if(i == (f * f * f + s * s * s + t * t *t)){
                count ++ ;
                System.out.println(i + " 是水仙花数!");
            }
        }
        System.out.println("总共有" + count + "个水仙花数！");
    }

    public static void main(String[] args){
        System.out.println("=====实现方式一=====");
        getDaffodilNum(101 , 999);
        System.out.println("=====实现方式二=====");
        getDaffodil();
    }
}
