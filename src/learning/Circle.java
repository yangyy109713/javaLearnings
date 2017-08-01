package learning;
import java.lang.Math;

public class Circle {

	public static void main(String []args){
		Circle c = new Circle();
		//c.Circle1(6);
		c.Circle2(6);
	}
	
	/**
	 * 根据给定半径，在窗口中打印出近似圆（方法一）
	 * 思路参考网友的答案
	 * @author yuanyuanyang1 
	 * @param r
	 */
	public void Circle1(int r){
		//定义y为圆的纵坐标，y=y+2设置纵坐标的步长，可以调整圆的“胖瘦”
		for(int y = 0 ; y <= 2*r ; y = y+2){
			//根据半径r和纵坐标y，计算横坐标x
			long x = Math.round(r - Math.sqrt(2*r*y - y*y));//为什么这么计算？2017-05-31
			for(int i = 0 ; i <= 2*r ; i ++){//根据纵坐标，打印对应的坐标点(x,y)上的内容
				//i == x表示纵坐标对应的第一个横坐标，i == 2*r - x表示纵坐标对应的第二个横坐标
				if(i == x || i == 2*r - x){
					System.out.print("*");
				}
				else{
					System.out.print(" ");
				}
			}
			//一行结束换行打印
			System.out.print("\n");//Java中以转义字符\n表示换行
		}
	}
	
	/**
	 * 根据给定半径，在窗口中打印出近似圆（方法二）
	 * @author yuanyuanyang1 
	 * @param r
	 */
	public void Circle2(int r){
		//假设圆心在坐标（r,r）
		int y = 2*r ;//纵坐标y的开始
		int x = 0;
		int c = 0;//中间空格数量
		int z = 2;//每行递减量，即圆的胖瘦
		for(int i = 2*r ; i >= 0 ; i = i-2){
			x = (int)Math.round(r - Math.sqrt(r*r - (y-r)*(y-r)));
			for(int j = 0 ; j < x ; j++){
				System.out.print(" ");
			}
			System.out.print("*");
			c = (r - x)*2;
			for(int j = 0 ; j < c ; j++){
				System.out.print(" ");
			}
			System.out.println("*");
			y -= z;
		}
	}
	
	//根据元的半径和纵坐标，解标准方程，假设圆心在坐标（r,r）
	public int getX(int r , int y){
		double tmp = Math.sqrt(r*r - (y-r)*(y-r));
		return (int)Math.round(r - tmp);
	}
	
	//得到多个空格串
	public String printSpace(int n){
		String s = "";
		for (int j = 0; j < n; j++) {
			s += " ";
		}
		return s;
	}
}
