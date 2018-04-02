package multiThreads;

//创建进程操作

public class ProcessDemo {
   public static void main (String[] args) throws Exception{
       //方式一：使用Runtime的exec()方法
       Runtime r = Runtime.getRuntime();
       r.exec("D:\\Tools\\Xshell\\Xshell.exe");

       //方式二：使用ProcessBuilder的构造器
       ProcessBuilder pb = new ProcessBuilder("D:\\Tools\\CloudMusic\\cloudmusic.exe");
       pb.start();
   }
}
