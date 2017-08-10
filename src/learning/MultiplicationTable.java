package learning;

/**
 * Created by yuanyuanyang1 on 8/10/2017.
 * 题目：输出9*9口诀。
 */
public class MultiplicationTable {
    //仅换行输出乘法口诀
    public static void printTable1(){
        for(int i = 1 ; i <= 9 ; i++){
            for(int j = i ; j <= 9 ;j++){
                System.out.println( i + "*" + j + "=" + (i * j));
            }
        }
    }

    //按乘法口诀表样式输出
    public static void printTable(){
        for(int i = 1 ; i < 10 ; i++){
            for(int j = 1 ; j <= i ; j++){
                System.out.print( j + "*" + i + "=" + (j * i) + " ");
                if(j * i < 10){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        printTable();
        //printTable1();
    }
}
