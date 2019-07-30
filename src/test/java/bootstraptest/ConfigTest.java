package bootstraptest;

import com.youyou.modules.config.BootStrapConfig;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author qishiyu
 * @create 2019/7/15 16:17
 */
public class ConfigTest {
    @Test
    public void testCPConfig() {
        BootStrapConfig config = BootStrapConfig.getConfig();
        config.addConfig("cp", "D:\\");
        Assert.assertEquals("D:\\", config.getClasspath());
    }
}
