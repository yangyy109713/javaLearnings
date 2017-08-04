package learning;

import java.util.Scanner;

/**
 * Created by yuanyuanyang1 on 8/3/2017.
 * 使用运算符的嵌套判断成绩grade：
 * grade大于等于90用A表示，在60-89之间用B表示，小于60用C表示。
 * 结果是一个字符，可以直接用char类型表示。
 */
public class OperatorNestTest {
    public static char getResult(int n){
        char result ;
        result = n >= 90 ? 'A'
                : n >= 60 ? 'B'
                : 'C';
        return result;
    }
    public static void main(String[] args){
        for(int i = 0 ; i < 3 ; i++){
            System.out.print("输入一个成绩（正整数）：");
            Scanner sc = new Scanner(System.in);
            int grade = sc.nextInt();
            System.out.println(grade + "分，等级是：" + getResult(grade));
        }
    }
}
