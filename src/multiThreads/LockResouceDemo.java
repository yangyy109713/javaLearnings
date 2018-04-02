package multiThreads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 从java5开始，可以使用Lock取代synchronized代码块和方法
 * 使用Condition接口对象取代wait和notify/notifyAll
 */
public class LockResouceDemo {
    private String name;
    private String gender;//正式实现功能时，使用int表示性别（0-男，1-女）
    private static boolean isEmpty = true;//表示共享资源为空
    private final Lock lock = new ReentrantLock();
    private Condition con = lock.newCondition();

    //生产者生产数据
    public void push(String name ,String gender){//synchronized解决性别紊乱情况
        lock.lock();//同步机制，添加同步锁
        try {
            while(!isEmpty){
                con.await();//表示当前线程释放同步锁，进入等待池，只能被其他线程唤醒
            }
            this.name = name;
            Thread.sleep(10);//让性别紊乱问题更明显
            this.gender = gender;
            isEmpty = false;//设置共享资源中数据不为空
            con.signalAll();//唤醒消费者线程
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();//释放同步锁
        }
    }
    //消费者取数据
    public void popup(){
        lock.lock();//同步机制，添加同步锁
        try{
            while(isEmpty){
                con.await();//表示当前线程释放同步锁，进入等待池，只能被其他线程唤醒
            }
            Thread.sleep(10);//让性别紊乱问题更明显
            System.out.println(this.name + "-" + this.gender);//以打印模拟取数据
            isEmpty = true;
            con.signalAll();//唤醒生产者
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();//释放同步锁
        }
    }
}

class Producer1 implements Runnable{
    private LockResouceDemo sr = null;//共享资源对象
    public Producer1(LockResouceDemo sr){
        this.sr = sr;
    }
    public void run(){
        for (int i = 0 ; i < 50 ; i ++){
            if(i % 2 == 0){
                sr.push("春哥","男");
            }else{
                sr.push("凤姐","女");
            }
        }
    }
}

class Consumer1 implements Runnable{
    private LockResouceDemo sr = null;//共享资源对象
    public Consumer1(LockResouceDemo sr){
        this.sr = sr;
    }
    public void run(){
        for (int i = 0 ; i < 50 ; i ++){
            sr.popup();
        }
    }
}