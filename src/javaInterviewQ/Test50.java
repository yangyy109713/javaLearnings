package javaInterviewQ;

import java.io.*;
import java.util.Scanner;

/**
 * Created by yuanyuanyang1 on 8/23/2017.
 * 题目：有五个学生，每个学生有3门课的成绩，从键盘输入以上数据（包括学生号，姓名，三门课成绩），
 * 计算出平均成绩，把原有的数据和计算出的平均分数存放在磁盘文件 "stud.txt"中。
 */
public class Test50 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[][] stu = new String[5][6];
        for(int i = 0 ; i < 5 ; i ++){
            System.out.print("输入第" + (i + 1) + "个学生学号：");
            stu[i][0] = sc.nextLine();
            System.out.print("输入第" + (i + 1) + "个学生姓名：");
            stu[i][1] = sc.nextLine();
            for(int j = 0 ; j < 3 ; j ++){
                System.out.print("输入第" + (j + 1) + "门课成绩：");
                stu[i][j + 2] = sc.nextLine();
            }
        }
        //计算平均成绩
        float avg;
        for(int i = 0 ; i < 5 ; i ++){
            int sum = 0;
            for(int j = 2 ; j < 5 ; j ++){
                sum += Integer.parseInt(stu[i][j]);
            }
            avg = (float)sum / 3;
            stu[i][5] = String.valueOf(avg);
        }

        File file = new File("stu.txt");
        file.delete();
        BufferedWriter bw;
        try{
            if(!file.exists()){
                file.createNewFile();
            }
            bw = new BufferedWriter(new FileWriter(file));
            System.out.println("开始写入stu.txt文件中");
            for(int i = 0 ; i < 5 ; i ++){
                for(int j = 0 ; j < 6 ; j ++){
                    bw.write(stu[i][j] + " ");
                }
                bw.write("\r\n");
            }
            bw.close();
            System.out.println("写入stu.txt文件完成");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
