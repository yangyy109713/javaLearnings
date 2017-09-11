package interfaceCoding;

/**
 * Created by yuanyuanyang1 on 9/11/2017.
 */
public class InterfaceDemo {
    public static void main(String[] args){
        IUSB iu = new Printer();
        iu.work();
    }
}

interface IUSB{
    void work();
}

class Device{

}

class Printer extends Device implements IUSB{
    public void work(){
        System.out.println("printer is printing...");
    }
}

class Usb extends Device implements IUSB{
    public void work(){
        System.out.println("Usb is working...");
    }
}

class KeyBoard extends Device implements IUSB{
    public void work(){
        System.out.println("keyBoard down and up...");
    }
}