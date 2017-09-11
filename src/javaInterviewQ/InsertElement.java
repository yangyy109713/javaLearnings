package javaInterviewQ;

import java.util.Scanner;

/**
 * Created by yuanyuanyang1 on 8/16/2017.
 * 题目：有一个已经排好序的数组。现输入一个数，要求按原来的规律将它插入数组中。
 */
public class InsertElement {
    //二分查找法，返回元素num所在位置的索引
    static int binarySearch(int[] a , int num){
        int low = 0;
        int high = a.length - 1;
        int mid = 0;
        while(low <= high){
            mid = (low + high) / 2;
            if(a[mid] > num){
                high = mid - 1;
            }else if(a[mid] < num){
                low = mid + 1;
            }else{
                low = high;
            }
        }
        if(a[mid] > num){
            return mid;
        }else if(a[mid] < num){
            return mid + 1;
        }else {
            return mid - 1;
        }
    }

    public static void main(String[] args){
        int[] a = {1 , 2 , 3 , 5 , 7 , 9 , 10};
        //System.out.println(binarySearch(a , 11));
        System.out.println("已按从小到大排序的数组：");
        for(int i = 0 ; i < a.length ; i ++){
            System.out.print(a[i] + " ");
        }
        System.out.println();

        int[] b = new int[a.length + 1];
        Scanner sc = new Scanner(System.in);
        System.out.print("输入一个数：");
        int in = sc.nextInt();

        if(in >= a[a.length - 1]){
            b[b.length - 1] = in;
            for(int i = 0 ; i < b.length - 1 ; i ++){
                b[i] = a[i];
            }
        }
        if(in <= a[0]){
            b[0] = in;
            for(int i = 1 ; i < b.length ; i ++){
                b[i] = a[i - 1];
            }
        }
        if (in < a[a.length - 1] && in > a[0]){
            int p = binarySearch(a , in);
            System.out.println("要插入数的索引：" + p);
            for(int i = 0 ; i < b.length ; i ++){
                if(i < p){
                    b[i] = a[i];
                }else if( i == p){
                    b[i] = in;
                }else{
                    b[i] = a[i - 1];
                }
            }
        }
        System.out.println("已插入一个数的数组：");
        for(int i = 0 ; i < b.length ; i ++){
            System.out.print(b[i] + " ");
        }
        System.out.println();
    }
}
