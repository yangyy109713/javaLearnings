package mockitoTest;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


/**
 * Created by yuanyuanyang on 18/4/2.
 */
public class CaculatorTest {

    //非moockito测试
    //@Test
    public void testDivide(){
        Caculator c = new Caculator(new IMathUtils() {
            @Override
            public boolean checkZero(int num) {
                return false;
            }
        });
        double result = c.divide(1 , 2);
        assertEquals(result , 0.5 , 0.01);//3个参数分别表示计算结果，预期结果，允许的误差
    }

    //mockito
    @Test
    public void testMockito(){
        //模拟ICaculator接口
        ICaculator iCaculator = mock(ICaculator.class);

        //测试桩
        when(iCaculator.divide(1 , 2)).thenReturn(0.5);
        double result = iCaculator.divide(1 , 2);
        assertEquals(result , 0.5 , 0.01);
    }

    //隔离依赖
    @Test(expected = RuntimeException.class)
    public void testDivide2(){
        //模拟IMathUtils接口
        IMathUtils iMathUtils = mock(IMathUtils.class);

        //测试桩
        when(iMathUtils.checkZero(0)).thenReturn(true);
        when(iMathUtils.checkZero(1)).thenReturn(false);

        Caculator c = new Caculator(iMathUtils);
        double result = c.divide(5 , 0);
    }


}
