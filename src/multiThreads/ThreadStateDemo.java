package multiThreads;

class Other implements Runnable{
    public void run(){
        for(int i = 0 ; i < 5 ; i++){
            System.out.println("other-" + i);
        }
    }
}

public class ThreadStateDemo {
    public static void main(String[] args){
        Other o = new Other();
        Thread t = new Thread(o);
        for(int i = 0 ; i < 50 ; i++){
            System.out.println("main-" + i);
            if(i == 10){
                t.start();
            }
        }
        if(!t.isAlive()){//当线程t已经死亡时
            t.start();//再次启动线程
        }
    }
}
