package runtimedatatest;

import com.youyou.modules.runtimedata.frame.LocalVars;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author qishiyu
 * @create 2019/8/6 16:30
 */
public class LocalVarsTest {
    private LocalVars localVars;

    @Before
    public void beforeTest() {
        localVars = new LocalVars(30);
    }

    @Test
    public void testInt() {
        int a = 11;
        localVars.setInt(0, a);
        Assert.assertEquals(a, localVars.getInt(0));
    }

    @Test
    public void testFloat() {
        float a = 1.0f;
        localVars.setFloat(0, a);
        Assert.assertEquals(a, localVars.getFloat(0), 0);
    }

    @Test
    public void testDouble() {
        double a = 1.0;
        localVars.setDouble(0, a);
        Assert.assertEquals(a, localVars.getDouble(0), 0);
    }

    @Test
    public void testLong() {
        long a = 1L;
        localVars.setLong(0, a);
        Assert.assertEquals(a, localVars.getLong(0), 0);
    }
}
