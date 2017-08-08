package learning;

/**
 * Created by yuanyuanyang1 on 8/7/2017.
 * 题目：一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下。
 * 求它在第10次落地时，共经过多少米？第10次反弹多高？
 */
public class BallLength {
    public static void main(String[] args){
        float h = 100;
        float s = 100;//第一次落地后s=100设为默认值
        for(int i = 0 ; i < 10 ; i++){
            s = s + h;
            h = h / 2;
        }
        System.out.println("第10次落地时，共经过" + s + "米");
        System.out.println("第10反弹" + h / 2 + "米");
    }
}
