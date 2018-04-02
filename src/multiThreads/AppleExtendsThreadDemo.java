package multiThreads;

/**
 * 吃苹果比赛:有50个苹果，从1-50编号，a,b,c三个人吃苹果，且可以同时吃；
 * 1.使用多线程，同时启动三个线程
 * 2.吃到苹果的那个人，要展示苹果的编号（打印出来），然后再吃掉苹果（苹果总数减1）
 * 3.通过继承Thread或实现Runnable接口实现
 */

//继承方式实现
//运行后发现：A、B、C每个人都吃了50个苹果（原因：Person.num非static修饰，每创建一个Person对象，都会开辟一个新的堆空间；每个对象用的是属于自己堆空间中的num）
public class AppleExtendsThreadDemo {
    public static void main(String[] args){
        //创建三个线程吃苹果
        new Person("A").start();
        new Person("B").start();
        new Person("C").start();
    }
}

class Person extends Thread{
    private int num = 50;//苹果总数
    public Person(String name){
        super(name);
    }
    public void run(){
        for (int i = 0 ; i < 50 ; i++){
            if (num > 0){
                System.out.println(super.getName() + "吃了编号为" + num-- +"的苹果");
            }
        }
    }
}
