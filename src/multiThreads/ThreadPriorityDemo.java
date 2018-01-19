package multiThreads;

public class ThreadPriorityDemo {
    public static void main(String[] args){
        PriorityThread pt1 = new PriorityThread("高优先级");
        pt1.setPriority(Thread.MAX_PRIORITY);
        PriorityThread pt2 = new PriorityThread("低优先级");
        pt2.setPriority(Thread.MIN_PRIORITY);

        pt1.start();
        pt2.start();
    }
}

class PriorityThread extends Thread{
    public PriorityThread(String name){
        super(name);
    }
    public void run(){
        for(int i = 0 ; i < 50 ; i++){
            System.out.println(super.getName() + i);
        }
    }
}