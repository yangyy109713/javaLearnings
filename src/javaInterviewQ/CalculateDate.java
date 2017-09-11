package javaInterviewQ;


import java.util.Scanner;

/**
 * Created by yuanyuanyang on 17/8/9.
 * 题目：输入某年某月某日，判断这一天是这一年的第几天？
 * 分别输入年 月 日
 */
public class CalculateDate {
    public static void main(String[] args){
        int year;
        int month;
        int day;
        int days=0;
        int perDay=0;
        int f = 1;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print("输入年：");
            year = sc.nextInt();
            System.out.print("输入月：");
            month = sc.nextInt();
            System.out.print("输入日：");
            day = sc.nextInt();
            if(month >= 1 && month <= 12 && day >= 1 && day <= 31 ){
                f = 0;
            }else
                System.out.print("输入错误，重新输入");
        }while(f == 1);

        for(int i = 0 ; i < month ; i++){
            switch(i){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    perDay = 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    perDay = 30;
                    break;
                case 2:
                    if((year % 400 == 0 )||(year % 4 == 0 && year % 100 != 0)){
                        perDay = 29;
                    }else {
                        perDay = 28;
                    }
                    break;
            }
            days += perDay;
        }
        System.out.println(year + "年" + month + "月" + day + "日，是当年的第" + (day + days) + "天");
    }
}
