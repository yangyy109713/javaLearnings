package learning;

import java.util.Scanner;

/**
 * Created by yuanyuanyang1 on 8/17/2017.
 * 题目：有一个已经排好序的数组。现输入一个数，要求按原来的规律将它插入数组中。
 */
public class InsertElement1 {
    public static void main(String[] args){
        int[] a = {1 , 2 , 6 , 14 , 25 , 36 , 37 , 55};
        int[] b = new int[a.length + 1];
        Scanner sc = new Scanner(System.in);
        System.out.print("输入一个数：");
        int num = sc.nextInt();
        if(num >= a[a.length - 1]){
            b[b.length - 1] = num;
            for(int i = 0 ; i < a.length ; i ++){
                b[i] = a[i];
            }
        } else if(num <= a[0]){
            b[0] = num;
            for(int i = 0 ; i < a.length ; i ++){
                b[i + 1] = a[i];
            }
        } else {
            for(int i = 0 ; i < a.length ; i ++){
                if(num >= a[i]){
                    b[i] = a[i];
                }else{
                    b[i] = num;
                    break;
                }
                for(int j = i + 1 ; j < b.length ; j ++){
                    b[j] = a[j - 1];
                }
            }
        }
        System.out.println("插入后的数组元素如下：");
        for(int i = 0 ; i < b.length ; i ++){
            System.out.print(b[i] + " ");
        }
    }
}
