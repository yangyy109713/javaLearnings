package multiThreads;

//同步锁Lock解决线程安全问题
//Synchronized的功能Lock都有，且更强大
//Lock的子类：ReentrantLock

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo{
    public static void main(String[] args){
        //创建三个线程吃苹果
        Personl pl = new Personl();
        new Thread(pl,"a").start();
        new Thread(pl,"b").start();
        new Thread(pl,"c").start();
    }
}

class Personl implements Runnable{
    private int num = 50;//苹果总数
    private final Lock lock = new ReentrantLock();//创建一个锁对象
    public void run(){
        for (int i = 0 ; i < 50 ; i++){
            eat();
        }
    }
    private void eat(){
        lock.lock();//进入方法，立马加锁
        if (num > 0){
            try{
                System.out.println(Thread.currentThread().getName() + "吃了编号为" + num +"的苹果");
                Thread.sleep(10);
                num--;
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();//释放锁
            }
        }
    }

}