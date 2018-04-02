package multiThreads;

public class DaemonThreadDemo {
    public static void main(String[] args){
        System.out.println(Thread.currentThread().isDaemon());//判断当前线程是否是后台线程
        for (int i = 0 ; i < 100 ; i++){
            System.out.println("main - " + i);
            if(i == 5){
                DaemonThread t = new DaemonThread();
                t.setDaemon(true);//将子线程设置为后台线程
                t.start();//启动线程
            }
        }
    }
}
class DaemonThread extends Thread{
    public void run(){
        for(int i = 0 ; i < 500 ; i++){
            System.out.println("Daemon-" + i);
        }
    }
}