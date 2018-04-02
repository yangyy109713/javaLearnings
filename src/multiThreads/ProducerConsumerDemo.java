package multiThreads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class ProducerConsumerDemo {
    public static void main(String[] args){
        /**
         * synchronized机制和同步资源对象wait，notify实现
         */
        ShareResource sr = new ShareResource();
        //new Thread(new Producer(sr)).start();
        //new Thread(new Consumer(sr)).start();

        /**
         * Lock机制和Condition接口对象实现
         */
        LockResouceDemo lrd = new LockResouceDemo();
        new Thread(new Producer1(lrd)).start();
        new Thread(new Consumer1(lrd)).start();

        /**
         * 会出现的问题：1.性别紊乱；2.春哥-男和凤姐-女没有交替出现
         * 同步锁池：同步锁必须选择多个线程共同的对象
         * 锁池：生产者生产数据时，先拥有同步锁，其他线程（消费者）在锁池中等待锁；同一个对象（共享资源）只有一把锁
         * 当线程执行完同步代码块/方法时，释放同步锁，其他线程抢锁的使用权
         */
    }
}

/**
 * 生产者生产数据，消费者消费数据
 * 如果共享资源中无数据，则生产（消费者等待），否则消费（生产者等待）
 * 共享资源假设有姓名和性别
 */
class ShareResource{
    private String name;
    private String gender;//正式实现功能时，使用int表示性别（0-男，1-女）
    private static boolean isEmpty = true;//表示共享资源为空
    //生产者生产数据
    synchronized public void push(String name ,String gender){//synchronized解决性别紊乱情况
        try {
            //while比if更安全，循环体执行完成后，会再次判断循环条件是否满足
            while(!isEmpty){//共享资源非空时，生产者等待
                //"".wait();
                this.wait();//使用同步对象来调用wait(),表示当前线程释放同步锁，进入等待池，只能被其他线程唤醒
        }
            this.name = name;
            Thread.sleep(10);//让性别紊乱问题更明显
            this.gender = gender;
            isEmpty = false;//设置共享资源中数据不为空
            //this.notify();//唤醒一个消费者
            this.notifyAll();//唤醒所有等待的消费者
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //消费者取数据
    synchronized public void popup(){
        try{
            while(isEmpty){//共享资源为空时，消费者等待
                this.wait();//使用同步对象来调用wait(),表示当前线程释放同步锁，进入等待池，只能被其他线程唤醒
            }
            Thread.sleep(10);//让性别紊乱问题更明显
            System.out.println(this.name + "-" + this.gender);//以打印模拟取数据
            isEmpty = true;
            //this.notify();//唤醒一个生产者
            this.notifyAll();//唤醒所有生产者
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class Producer implements Runnable{
    private ShareResource sr = null;//共享资源对象
    public Producer(ShareResource sr){
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

class Consumer implements Runnable{
    private ShareResource sr = null;//共享资源对象
    public Consumer(ShareResource sr){
        this.sr = sr;
    }
    public void run(){
        for (int i = 0 ; i < 50 ; i ++){
            sr.popup();
        }
    }
}