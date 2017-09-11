package javaInterviewQ;

/**
 * Created by yuanyuanyang1 on 8/10/2017.
 * 题目：打印出如下图案（菱形）
    *
   ***
  *****
 *******
  *****
   ***
    *
 */
public class PrintShapeTest {
    public static void main(String[] args){
        int h = 7;
        int w = 7;
        for(int i = 0 ; i < (h + 1) / 2 ; i++){
            for(int j = 0 ; j < w / 2 - i ; j++){
                System.out.print(" ");
            }
            for(int k = 1 ; k < (i + 1) * 2 ; k++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = 1 ; i <= h / 2 ; i++){
            for(int j = 1 ; j <= i ; j++){
                System.out.print(" ");
            }
            for(int k = 1 ; k <= w - 2 * i ; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
