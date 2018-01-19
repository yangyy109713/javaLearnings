package multiThreads;

/**
 * 吃苹果比赛:有50个苹果，从1-50编号，a,b,c三个人吃苹果，且可以同时吃；
 * 1.使用多线程，同时启动三个线程
 * 2.吃到苹果的那个人，要展示苹果的编号（打印出来），然后再吃掉苹果（苹果总数减1）
 * 3.通过继承Thread或实现Runnable接口实现
 * 4.线程安全问题：通过同步锁处理
 */

//实现接口方式
public class SyncMethodDemo {
    public static void main(String[] args){
        //创建三个线程吃苹果
        Person4 p = new Person4();
        new Thread(p,"A").start();
        new Thread(p,"B").start();
        new Thread(p,"C").start();
    }
}

class Person4 implements Runnable{
    private int num = 50;//苹果总数
    public Person4(){}

    /*
    //并不是使用sleep才出现问题，只是让问题更明显
    //同步方法：谁调用当前方法，同步锁就是谁（非static方法）；static方法：使用当前方法所在类的字节码
    //不能使用synchronized修饰run方法，否则一个线程会占用所有资源
    //建议：尽量减小synchronized的作用范围
     */
    synchronized private void eat(){
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
     public void run(){
        for (int i = 0 ; i < 50 ; i++){
            eat();
            StringBuffer sb;//内部的方法都使用synchronized修饰，安全、性能较低
            StringBuilder sb1;//无synchronized，性能高（推荐使用，如有线程安全问题，在调用时使用synchronized修饰）
        }
    }
}
