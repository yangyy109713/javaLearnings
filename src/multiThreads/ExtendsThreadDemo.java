package multiThreads;

public class ExtendsThreadDemo {
    public static void main(String[] args){
        for(int i = 0 ;i < 50 ; i++){
            if (i == 1){
                MusicThread a = new MusicThread();
                //a.run();//普通方法，只有一个线程main在执行：顺序执行
                a.start();
            }
            System.out.println("play game" + i);
        }
    }
}

class MusicThread extends Thread{
    private String name;
    public MusicThread(){}
    public MusicThread(String name){
        super(name);
    }
    public void run(){
        for(int i = 0 ; i < 50 ; i++){
            System.out.println("play music" + i);
        }
    }
}