package javaInterviewQ;

/**
 * Created by yuanyuanyang1 on 8/22/2017.
 * 题目：海滩上有一堆桃子，五只猴子来分。第一只猴子把这堆桃子平均分为五份，多了一个，这只猴子把多的一个扔入海中，拿走了一份。
 * 第二只猴子把剩下的桃子又平均分成五份，又多了一个，它同样把多的一个扔入海中，拿走了一份，
 * 第三、第四、第五只猴子都是这样做的，问海滩上原来最少有多少个桃子？
 */
public class Test41 {
    public static void main(String[] args){
        int count;
        int total = 0;
        for(int i = 4 ; i < 10000 ; i += 4){
            count = 0;
            int m = i;
            for(int k = 0 ; k < 5 ; k ++){
                total = i / 4 * 5 + 1;
                i = total;
                if(total % 4 == 0){
                    count ++ ;
                }else {
                    break;
                }
            }
            i = m;
            if(count == 4){
                System.out.println("原来有" + total + "个桃子。");
                break;
            }
        }
    }
}
