package mockitoTest;

/**
 * Created by yuanyuanyang on 18/4/2.
 */
public class Caculator implements ICaculator{
    private final IMathUtils iMathUtils;

    /**
     * 通过构造方法接受IMathUtils实例化对象
     * @param iMathUtils
     */
    public Caculator(IMathUtils iMathUtils){
        this.iMathUtils = iMathUtils;
    }

    @Override
    public double  divide(int a , int b){
        //检测被除数是否为0
        if(iMathUtils.checkZero(b)){
            throw new RuntimeException("dividend is zero");
        }
        return  (double)a/b;
    }
}