package util;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;
/**
 * junit默认按确定性的顺序（不可预测）(MethodSorters.DEFAULT)
 * 若要改变执行顺序，在类名前添加注解@FixMethodOrder(MethodSorters.NAME_ASCENDING)（按照方法名的字母在字典中排序规则执行）
 * @FixMethodOrder(MethodSorters.JVM)（每次执行顺序可能都不一样）
 * Leaves the test methods in the order returned by the JVM. 
 * This order may vary from run to run.
 * @author yuanyuanyang1
 * 下面的3个测试方法，按照testA testB testC顺序执行DEFAULT
 */
//@FixMethodOrder(MethodSorters.DEFAULT) //按确定的顺序执行，但不可预测
@FixMethodOrder(MethodSorters.JVM)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JunitMethodOrderTest {
	@Test
	public void testA(){
		System.out.println("JunitMethodOrderTest-first");
	}
	
	@Test
	public void testB(){
		System.out.println("JunitMethodOrderTest-second");
	}
	
	@Test
	public void testC(){
		System.out.println("JunitMethodOrderTest-third");
	}
}
