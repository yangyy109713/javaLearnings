package javaInterviewQ;

import java.util.Scanner;

/**
 * Created by yuanyuanyang1 on 8/15/2017.
 * 题目：请输入星期几的第一个字母来判断一下是星期几，如果第一个字母一样，则继续判断第二个字母。
 */
public class JudgeWeekday {
    public static char getDay(){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        char c = line.charAt(0);//得到首字母
        if(c < 'A' || c > 'Z'){
            System.out.println("输入错误，请重新输入");
            c = getDay();
        }
        return c;
    }

    public static void main(String[] args){
        System.out.print("输入星期几的首字母：");
        char c = getDay();
        switch (c){
            case 'M' :
                System.out.println("M is Monday");
                break;
            case 'W' :
                System.out.println("W is Wednesday");
                break;
            case 'F' :
                System.out.println("F is Friday");
                break;
            case 'T' : {
                    System.out.print("输入星期几的第二个字母：");
                    c = getDay();
                    if (c == 'U') {
                        System.out.println("T is Tuesday");
                        break;
                    }
                    if (c == 'H') {
                        System.out.println("T is Thursday");
                        break;
                    } else {
                        System.out.println("输入错误");
                    }
                }
                break;
            case 'S' : {
                    System.out.print("输入星期几的第二个字母：");
                    c = getDay();
                    if (c == 'A') {
                        System.out.println("S is Saturday");
                        break;
                    }
                    if (c == 'U') {
                        System.out.println("S is Sunday");
                        break;
                    } else {
                        System.out.println("输入错误");
                    }
                }
                break;
            default:
                System.out.println("输入错误");
        }
    }
}
