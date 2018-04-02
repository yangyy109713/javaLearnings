package multiThreads;

public class JoinThreadDemo {
    public static void main(String[] args) throws Exception{
        Join join = new Join();
        for (int i = 0 ;i < 50 ; i ++){
            System.out.println("main-" + i);
            if(i == 1){
                join.start();
            }
            if(i == 20){
                join.join();
            }
        }
    }
}

class Join extends Thread{
    public void run(){
        for(int i = 0 ; i < 50 ; i++){
            System.out.println("join-" + i);
        }
    }
}
