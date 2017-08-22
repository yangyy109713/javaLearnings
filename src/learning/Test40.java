package learning;

/**
 * Created by yuanyuanyang1 on 8/22/2017.
 * 题目：字符串排序。
 */
public class Test40 {
    static int compare(String s1 , String s2){
        int c = 0;
        for(int i = 0 ; i < s1.length() && i < s2.length() ; i ++){
            if(s1.charAt(i) < s2.charAt(i)){//比较字符大小
                c = -1 ;//前面的小于后面的
                break;//退出循环
            }else if(s1.charAt(i) > s2.charAt(i)){
                c = 1;//前面的大于后面的
                break;
            }else {
                if(s1.length() < s2.length()){//前面部分字符大小相等，比较字符串长度
                    c = -1;//前面的小于后面的
                }else {
                    c = 1;//前面的大于后面的
                }
            }
        }
        return c;
    }

    public static void main(String[] args){
        String[] s = {"you" , "good" , "are" , "test" , "aer"};
        for(int i = 0 ; i < s.length ; i ++){
            for(int j = i + 1 ; j < s.length ; j ++){
                if(compare(s[i] , s[j]) == 1){
                    String t = s[i];
                    s[i] = s[j];
                    s[j] = t;
                }
            }
        }
        for(int i = 0 ; i < s.length ; i ++){
            System.out.println(s[i]);
        }
    }
}
