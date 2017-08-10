package learning;

/**
 * Created by yuanyuanyang1 on 8/10/2017.
 * 题目：两个乒乓球队进行比赛，各出三人。甲队为a,b,c三人，乙队为x,y,z三人。已抽签决定比赛名单。
 * 有人向队员打听比赛的名单。a说他不和x比，c说他不和x,z比，请编程序找出三队赛手的名单。
 */
public class GetCompetitorList {
    public static void main(String[] args){
        String[] as = {"a" , "b" , "c"};
        String[] bs = {"x" , "y" , "z"};
        for(int i = 0 ; i < as.length ; i++){
            for(int j = 0 ; j < bs.length ; j++){
                if(as[i] == "a" && bs[j] == "x"){
                    continue;//跳到下一个循环
                }else if(as[i] == "a" && bs[j] == "y"){
                    continue;//a不能对y，因为c只能对y
                }else if((as[i] == "c" && bs[j] == "x")||(as[i] == "c" && bs[j] == "z")){
                    continue;
                }else if((as[i] == "b" && bs[j] == "y")||(as[i] == "b" && bs[j] == "z")){
                    continue;
                }else{
                    System.out.println(as[i] + " VS " + bs[j]);
                }
            }
        }
    }
}
