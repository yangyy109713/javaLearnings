package multiThreads;

/**
 * 线程-单例模式--饿汉式
 * 不会出现线程安全问题
 */
public class ArrayUtilDemo {
    public ArrayUtilDemo(){}
    private static final ArrayUtilDemo instance = new ArrayUtilDemo();
    public static ArrayUtilDemo getInstance(){
        return instance;
    }
    public static void main(String[] args){

    }
}
