package learning;

import java.util.Scanner;

/**
 * Created by yuanyuanyang1 on 8/18/2017.
 * 题目：有n个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数），凡报到3的人退出圈子，问最后留下的是原来第几号的那位。
 */
public class Test37 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("输入围成一圈的人数：");
        int n = sc.nextInt();
        boolean[] b = new boolean[n];//存储所有人的状态
        for(int i = 0 ; i < n ; i ++){
            b[i] = true;
        }
        int leftCount = n;//初始人数
        int cn = 0 ;//统计报数
        int index = 0;//索引
        while(leftCount > 1){
            if(b[index] == true){
                cn ++ ;
                if(cn == 3){
                    cn = 0;//再从1开始报数
                    b[index] = false;//凡报到3退出圈子
                    leftCount --;//留下的人减一
                }
            }
            index ++;
            if(index == n){
                index = 0;//数到最后从头开始
            }
        }
        for(int i = 0 ; i < n ; i ++){
            if(b[i] == true){
                System.out.println("最后留下的是原来第" + (i + 1) + "号的那位。");
            }else{
                System.out.println(b[i] + " ");
            }
        }
    }
}
