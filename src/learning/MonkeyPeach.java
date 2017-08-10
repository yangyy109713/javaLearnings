package learning;

/**
 * Created by yuanyuanyang1 on 8/10/2017.
 * 题目：猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个。
 * 第二天早上又将剩下的桃子吃掉一半，又多吃了一个。以后每天早上都吃了前一天剩下的一半零一个。
 * 到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘了多少。
 */
public class MonkeyPeach {
    public static int getTotal(int x){
        return 2 * (x + 1);
    }

    public static void main(String[] args){
        int a = 1;
        for(int i = 10 ; i > 0 ; i--){
            //System.out.println("第" + i + "天剩余" + a + "个桃子");
            a = getTotal(a);
        }
        System.out.println("第一天摘了" + a + "个桃子");
    }
}
