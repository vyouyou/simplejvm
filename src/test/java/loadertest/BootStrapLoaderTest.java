package loadertest;

import com.youyou.modules.loader.classloader.BootStrapClassLoader;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author qishiyu
 * @create 2019/7/26 11:56
 */
public class BootStrapLoaderTest {
    @Test
    public void testInitBootStrapLoader() {
        BootStrapClassLoader bootStrapClassLoader = new BootStrapClassLoader();
        byte[] bytes = bootStrapClassLoader.loadFile("java.lang.Boolean");
        Assert.assertNotNull(bytes);
        Assert.assertNotEquals(bytes.length, 0);
    }
}
