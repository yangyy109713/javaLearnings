package javaInterviewQ;

import java.util.Scanner;

/**
 * Created by yuanyuanyang1 on 8/16/2017.
 * 题目：求一个3*3矩阵对角线元素之和
 * 矩阵有2条对角线，元素的坐标分别满足i==j和i+j=arr.length-1
 */
public class MatrixTest {
    public static int countMatrix(int[][] arr){
        int sum = 0;
        for(int i = 0 ; i < arr.length ; i ++){
            for(int j = 0 ; j < arr[i].length ; j ++){
                if(i ==j || (i + j) == arr.length - 1){
                    sum += arr[i][j];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("输入9个数：");
        int[][] arr = new int[3][3];
        for(int i = 0 ; i < 3 ; i ++){
            for(int j = 0 ; j < 3 ; j ++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("3*3矩阵元素是：");
        for(int i = 0 ; i < 3 ; i ++){
            for(int j = 0 ; j < 3 ; j ++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("该矩阵两对角线之和是：" + countMatrix(arr));
    }
}
