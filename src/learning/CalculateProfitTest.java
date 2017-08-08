package learning;

import java.util.Scanner;

/**
 * Created by yuanyuanyang1 on 8/8/2017.
 * 题目：企业发放的奖金根据利润提成。利润(I)低于或等于10万元时，奖金可提10%；利润高于10万元，低于20万元时，低于10万元的部分按10%提成，
 * 高于10万元的部分，可可提成7.5%；20万到40万之间时，高于20万元的部分，可提成5%；40万到60万之间时高于40万元的部分，可提成3%；
 * 60万到100万之间时，高于60万元的部分，可提成1.5%，高于100万元时，超过100万元的部分按1%提成，从键盘输入当月利润，求应发放奖金总数？
 */
public class CalculateProfitTest {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double p = 0;
        double p1 = 0;
        for(int i = 0 ; i < 6 ; i++){
            System.out.print("当月利润：");
            p = sc.nextInt();
            if(p > 0 && p <= 10){
                p1 = p * 0.1;
            }else if(p > 10 && p <= 20){
                p1 = 10 * 0.1 + (p - 10) * 0.075;
            }else if(p > 20 && p <= 40){
                p1 = 10 * 0.1 + 10 * 0.075 + (p - 20) * 0.05;
            }else if(p > 40 && p <= 60){
                p1 = 10 * 0.1 + 10 * 0.075 + 20 * 0.05 + (p - 40) * 0.03;
            }else if(p > 60 && p <= 100){
                p1 = 10 * 0.1 + 10 * 0.075 + 20 * 0.05 + 20 * 0.03 + (p - 60) * 0.015;
            }else if(p > 100){
                p1 = 10 * 0.1 + 10 * 0.075 + 20 * 0.05 + 20 * 0.03 + 40 * 0.015 + (p - 100) * 0.01;
            }
            System.out.println("应发放奖金：" + p1 + "万元");
        }
    }
}
