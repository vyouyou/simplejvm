package loadertest;

import com.youyou.modules.loader.file.FileLoader;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author qishiyu
 * @create 2019/7/25 16:27
 */
public class FileLoaderTest {
    @Test
    public void testLoadFromFile() {
        FileLoader loader = new FileLoader("D:\\javaprj\\simplejvm\\target\\test-classes\\testclass\\");
        byte[] bytes = loader.loadFile("ExceptionEnum");
        Assert.assertNotNull(bytes);
        Assert.assertNotEquals(bytes.length,0);
    }

    @Test
    public void testLoadFromJar(){
        FileLoader loader = new FileLoader("D:\\javaprj\\simplejvm\\target\\test-classes\\testclass\\");
        byte[] bytes = loader.loadFile("lombok.Builder");
        Assert.assertNotNull(bytes);
        Assert.assertNotEquals(bytes.length,0);
    }
}
