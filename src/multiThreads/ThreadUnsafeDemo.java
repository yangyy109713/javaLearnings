package multiThreads;

/**
 * 吃苹果比赛:有50个苹果，从1-50编号，a,b,c三个人吃苹果，且可以同时吃；
 * 1.使用多线程，同时启动三个线程
 * 2.吃到苹果的那个人，要展示苹果的编号（打印出来），然后再吃掉苹果（苹果总数减1）
 * 3.通过继承Thread或实现Runnable接口实现
 */

//实现接口方式
public class ThreadUnsafeDemo {
    public static void main(String[] args){
        //创建三个线程吃苹果
        Person2 p = new Person2();
        new Thread(p,"A").start();
        new Thread(p,"B").start();
        new Thread(p,"C").start();
    }
}

class Person2 implements Runnable{
    private int num = 50;//苹果总数
    public Person2(){}

    /*
    //并不是使用sleep才出现问题，只是让问题更明显
     */
    public void run(){
        for (int i = 0 ; i < 50 ; i++){
            if (num > 0){
                try{
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName() + "吃了编号为" + num-- +"的苹果");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
