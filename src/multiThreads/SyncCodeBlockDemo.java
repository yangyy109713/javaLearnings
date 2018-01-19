package multiThreads;

/**
 * 吃苹果比赛:有50个苹果，从1-50编号，a,b,c三个人吃苹果，且可以同时吃；
 * 1.使用多线程，同时启动三个线程
 * 2.吃到苹果的那个人，要展示苹果的编号（打印出来），然后再吃掉苹果（苹果总数减1）
 * 3.通过继承Thread或实现Runnable接口实现
 * 4.线程安全问题：通过同步锁处理
 */

//实现接口方式
public class SyncCodeBlockDemo {
    public static void main(String[] args){
        //创建三个线程吃苹果
        Person3 p = new Person3();
        new Thread(p,"A").start();
        new Thread(p,"B").start();
        new Thread(p,"C").start();
    }
}

class Person3 implements Runnable{
    private int num = 50;//苹果总数
    public Person3(){}
    /*
    //并不是使用sleep才出现问题，只是让问题更明显
    同步代码块方法：保证多线程访问资源安全性问题
     */
    public void run(){
        for (int i = 0 ; i < 50 ; i++){
            synchronized (this){//this表示多线程共同享有的资源
                if (num > 0){
                    System.out.println(Thread.currentThread().getName() + "吃了编号为" + num +"的苹果");
                    try{
                        Thread.sleep(10);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    num--;//在等待一段时间后，再减1
                }
            }
        }
    }
}
