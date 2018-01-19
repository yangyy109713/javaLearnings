package multiThreads;

public class AnonymousThreadDemo {
    public static void main(String[] args){
        for(int i = 0 ;i < 50 ; i++){
        System.out.println("play game" + i);
            if (i == 3){
                //匿名内部类方式实现：底层仍然是继承Thread类
                // 建议使用接口
                new Thread(){
                    public void run(){
                        for (int i = 0 ; i < 50 ;i ++){
                            System.out.println("play media" + i);
                        }
                    }
                }.start();
            }
        }
    }

    public static void test1(){
        for(int i = 0 ;i < 50 ; i++){
            System.out.println("play game" + i);
            if (i == 1){
                //方式二
                new Thread(new Runnable() {
                    public void run() {
                        for (int i = 0 ; i < 50 ;i ++){
                            System.out.println("play media" + i);
                        }
                    }
                }).start();
            }
        }
    }
}

