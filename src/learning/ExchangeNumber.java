package learning;

import java.util.Scanner;

/**
 * Created by yuanyuanyang1 on 8/17/2017.
 * 题目：输入数组，最大的与第一个元素交换，最小的与最后一个元素交换，输出数组。
 */
public class ExchangeNumber {
    public static void main(String[] args){
        System.out.print("输入一个数组：");
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[6];
        for(int i = 0 ; i < arr.length ; i ++){
            arr[i] = sc.nextInt();
        }
        int max = arr[0];
        int min = arr[0];
        int ix = 0;
        int in = 0;
        for(int i = 0 ; i < arr.length ; i ++){
            if(max < arr[i]){
                max = arr[i];
                ix = i;
            }
            if(min > arr[i]){
                min = arr[i];
                in = i;
            }
        }
        if(ix != 0){
            int temp = arr[0];
            arr[0] = max;
            arr[ix] = temp;//最大的和第一个交换
        }
        if(in != arr.length - 1){
            int temp = arr[arr.length - 1];
            arr[arr.length - 1] = min ;
            arr[in] = temp;//最小的和最后一个交换
        }

        System.out.print("交换后的数组：");
        for(int i = 0 ; i < arr.length ; i ++){
            System.out.print(arr[i] + " ");
        }
    }
}
