package learning;

import java.io.*;

/**
 * Created by yuanyuanyang1 on 8/24/2017.
 * 题目：有五个学生，每个学生有3门课的成绩，从键盘输入以上数据（包括学生号，姓名，三门课成绩），
 * 计算出平均成绩，把原有的数据和计算出的平均分数存放在磁盘文件 "stud1.txt"中。
 * //实现方式二
 */
public class Test51_1 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(new File("stud_1.txt")));
            double average = 0 , sum = 0 , score = 0;
            String scoreStr;
            for(int i = 0 ; i < 5 ; i ++){
                System.out.print("输入学生号00" + (i + 1) + "的学姓名：");
                String name = br.readLine();
                bw.write("学号00" + (i + 1) + ",姓名" + name + ":");
                bw.newLine();
                for(int j = 0 ; j < 3 ; j ++){
                    String lesson = j == 1 ? "英语" : (j == 0 ? "数学" : "语文");
                    System.out.print("输入" + name + "的" + lesson + "成绩：");
                    scoreStr = br.readLine();
                    try{
                        if(scoreStr == ""){
                            score = 0;
                        }else{
                            score = Integer.parseInt(scoreStr);
                        }
                    }catch (NumberFormatException ne){
                        System.out.println("输入的成绩有问题！请重新输入！！" + ne);
                        j --;
                    }
                    sum += score;
                    bw.write(lesson + ":" + score);
                    bw.newLine();
                }
                average = sum / 3;
                bw.write("平均成绩：" + average);
                bw.newLine();
                bw.newLine();
            }
            bw.flush();
            bw.close();
        }catch(IOException ie){
            ie.printStackTrace();
        }
    }
}
