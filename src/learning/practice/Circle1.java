package learning.practice;

import java.util.Scanner;

public class Circle1 {
	public static void main(String[] agrs) {
		System.out.print("请输入圆半径:");
		paint(new Scanner(System.in).nextInt());
	}

	public static void paint(int r) {
		// 设圆心在（r，r）处，控制台起始点为（0,0）,把由此建立的直角坐标系的第四象限看成第一象限
		int x = 0;// x坐标
		int y = 0;// y坐标
		int c = 0;// 左右两个*之间的空格数
		int z = 2;// 用于控制纵横比，设为2刚刚好

		for (int i = 0; i <= 2 * r; i += 2) {
			// 先获取每一行左边*号的坐标X
			x = getX(r, y);
			// 打印第一个*号之前的空格和*号
			System.out.print(getSpace(x) + "*");
			// 打印两个*号之间的空格
			c = 2 * (r - x);
			System.out.println(getSpace(c) + "*");
			y += 2;
		}

	}

	public static int getX(int r, int y) {
		// 由直角三角形勾股定理可以得到圆的边上的点的横坐标x
		return (int) Math.round((r - Math.sqrt(r * r - (r - y) * (r - y))));
	}

	public static String getSpace(int s) {
		String space = "";
		for (int j = 0; j < s; j++) {
			space += " ";
		}
		return space;
	}
}