package multiThreads;

public class ImplRunnableDemo {
    //first day
    public static void main(String[] args){
        for(int i = 0 ;i < 50 ; i++){
            System.out.println("play game" + i);
            if (i == 5){
                Runnable r = new MusicThread1();
                Thread t = new Thread(r);
                t.start();
            }
        }
    }
}

class MusicThread1 implements java.lang.Runnable{
    public void run(){
        for(int i = 0 ; i < 50 ; i++){
            System.out.println("play music" + i);
        }
    }
}