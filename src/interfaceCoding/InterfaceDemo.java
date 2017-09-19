package interfaceCoding;

/**
 * Created by yuanyuanyang1 on 9/11/2017.
 * 使用USB设备来工作－－面向接口编程学习
 * 多态的好处：把实现类对象赋给接口类型变量，屏蔽了不同实现类之间的差异，从而可以做到通用编程。
 */
public class InterfaceDemo {
    public static void main(String[] args){
        Mouse m = new Mouse();
        MotherBoard.pluginIn(m);

        Printer p = new Printer();
        MotherBoard.pluginIn(p);

        MotherBoard.pluginIn(new Mouse());
        MotherBoard.pluginIn(new Mouse());
        MotherBoard.pluginIn(new Mouse());
        MotherBoard.pluginIn(new Mouse());
        MotherBoard.pluginIn(new Mouse());
        MotherBoard.pluginIn(new Mouse());

        MotherBoard.work();
    }
}

interface  IUSB {
    void swapData();
}

class Mouse implements IUSB {
    public void swapData(){
        System.out.println("鼠标ing...");
    }
}

class Printer implements IUSB {
    public void swapData(){
        System.out.println("打印机ing");
    }
}

class Usb {

}

//主板，又叫母板  鼠标接入主板才能工作
class MotherBoard{
    /*
    如果再有打印机或USB等设备需要接入，需要再定义方法，传入打印机或USB等对象
    public static void pluginIn(Mouse m){
        m.swapData();
    }
     */

    private static IUSB[] iusbs = new IUSB[6];//最多6个接口
    private static int i = 0;//插入到第几个位置

    //面向接口编程
    public static void pluginIn(IUSB iusb){
        if(i == iusbs.length){
            System.out.println("插满了ing...");
            return;
        }
        iusbs[i] = iusb;
        i ++;
    }

    public static void work(){
        for(IUSB i : iusbs){
            if(i != null){
                i.swapData();
            }
        }
    }
}