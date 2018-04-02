package multiThreads;

/**
 * 线程-单例模式--懒加载模式
 * 存在线程不安全问题：可使用synchronized修饰，且尽量减少synchronized的作用域
 *
 */
public class ArrayUtilDemo1 {
    public ArrayUtilDemo1(){}
    private static ArrayUtilDemo1 instance = null;
    public static ArrayUtilDemo1 getInstance(){
        /*synchronized (ArrayUtilDemo1.class) {
            if (instance != null) {
                instance = new ArrayUtilDemo1();
            }
            return instance;
        }*/
        //双重检查机制：volatile，仅能用在JAVA5以上版本中，但volatile可能会屏蔽掉代码中一些必要优化代码，因此一般不建议使用
        //所以单例模式推荐使用饿汉式
        synchronized (ArrayUtilDemo1.class) {
            if (instance != null) {
                instance = new ArrayUtilDemo1();
            }
        }
        return instance;
    }
    public static void main(String[] args){

    }
}
