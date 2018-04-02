package javaCoreApi;

/**
 * Created by yuanyuanyang on 17/9/21.
 * 分别使用String/StringBuffer和StringBuilder来拼接字符串30000次，并计算损耗。
 * String 3347ms
 * StringBuffer 5ms
 * StringBuilder 3ms
 */
public class CharSequenceDemo {
    public static void main(String[] args){
        stringConsume();
        stringBufferConsume();
        stringBuildConsume();
    }

    private static void stringConsume(){
        long begin = System.currentTimeMillis();
        String s = "";
        for(int i = 0 ; i < 30000 ; i ++){
            s += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

    private static void stringBufferConsume(){
        long begin = System.currentTimeMillis();
        StringBuffer s = new StringBuffer("");
        for(int i = 0 ; i < 30000 ; i ++){
            s.append(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

    private static void stringBuildConsume(){
        long begin = System.currentTimeMillis();
        StringBuilder s = new StringBuilder("");
        for(int i = 0 ; i < 30000 ; i ++){
            s.append(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }
}
