package mockitoTest;

/**
 * Created by yuanyuanyang on 18/4/2.
 */
public class MathUtils implements IMathUtils{
    @Override
    public boolean checkZero(int num){
        return num == 0;
    }
}
