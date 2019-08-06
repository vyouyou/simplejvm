package common;

import com.youyou.common.utils.BitConverter;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author qishiyu
 * @create 2019/8/6 14:35
 */
public class BitConvertTest {
    @Test
    public void intToBitAndRecover() {
        int a = 111;
        Assert.assertEquals(a, BitConverter.ToInt32(BitConverter.GetBytes(a)));
    }

    @Test
    public void longToBitAndRecover() {
        long a = 111L;
        Assert.assertEquals(a, BitConverter.ToInt64(BitConverter.GetBytes(a)));
    }

    @Test
    public void floatToBitAndRecover() {
        float a = 3.751f;
        Assert.assertEquals(a, BitConverter.ToFloat(BitConverter.GetBytes(a)), 0);
    }

    @Test
    public void doubleToBitAndRecover() {
        double a = 2.3567D;
        Assert.assertEquals(a, BitConverter.ToDouble(BitConverter.GetBytes(a)), 0);
    }

}
