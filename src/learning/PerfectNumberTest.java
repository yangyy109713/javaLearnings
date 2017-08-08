package learning;

/**
 * Created by yuanyuanyang1 on 8/7/2017.
 * 统计并打印出1000以内的完数。
 * 完数：所有因子之和等于该数本身，如6=3+2+1
 */
public class PerfectNumberTest {
    public static void main(String[] args){
        int count =0;
        for(int i = 1 ; i < 1000 ; i ++){
            int p = 0;
            for(int j = 1 ; j <= i / 2 ; j++){
                if(i % j == 0){
                    p = p + j;
                }
            }
            if(i == p){
                count ++;
                System.out.println(i + "是完数");
            }
        }
        System.out.println("总共有：" + count + "个完数。");
    }
}
