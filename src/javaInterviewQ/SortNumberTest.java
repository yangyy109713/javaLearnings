package javaInterviewQ;

/**
 * Created by yuanyuanyang1 on 8/15/2017.
 * 题目：对10个数进行排序。
 */
public class SortNumberTest {
    /*
    冒泡排序:从小到大排序
    从第1个数开始，和第2个数比较，大于（小于）则交换；
    然后第一个数再和第3个数比较，大于（小于）则交换；
    直到最后一个数，第一轮得到最大数（最小数）。
    接着进行第二轮比较，因为最大数已经得到，只需比较前n-1个。
     */
    public static void bubbleSort(int[] arr){
        for(int k = 1 ; k <= arr.length - 1 ; k ++){
            for(int i = 0 ; i < arr.length - k ; i ++){
                if(arr[i] > arr[i + 1]){
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
            }
        }
    }

    public static void bubbleSort1(int[] arr){
        for(int i = 0 ; i < arr.length ; i++){
            boolean f = false;
            for(int j = i + 1 ; j < arr.length ; j++){
                if(arr[i] > arr[j]){
                    f = true;
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
            if(!f){
                break;//上一轮比较不存在交换，退出排序
            }
        }
    }
    /*
    选择排序:从小到大排序
    选择第1个数，和第2个数比较，大于则用一个变量记录较大数的位置（数组索引）；
    然后待比较的第1个数变成该索引位置的数，继续和下一个数比较，大于则记录下一个数的位置;
    一趟比较完成，比较变量k和第1个数的索引是否相同，不同则交换，得到数组中最小数。
     接着从第2个数进行下一趟比较。
     */
    public static void selectSort(int[] arr){
        for(int i = 0 ; i < arr.length ; i ++){
            int t = i;
            for(int j = i + 1 ; j < arr.length ; j ++){
                if(arr[t] > arr[j]){
                    t = j;
                }
            }
            if(i != t){
                int tmp = arr[i];
                arr[i] = arr[t];
                arr[t] = tmp;
            }
        }
    }

    public static void main(String[] args){
        int[] a = {1 , 4 , 9 , 2 , 5 , 8 , 3 , 6 , 7 , 0};
        bubbleSort(a);
        //selectSort(a);
        //打印出已排序后的数
        for(int i = 0 ; i < a.length ; i ++){
            System.out.print(a[i] + " ");
        }
    }
}
