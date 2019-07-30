package readertest;

import com.youyou.modules.loader.file.FileLoader;
import com.youyou.modules.reader.ClassFile;
import com.youyou.modules.reader.ClassReader;
import com.youyou.modules.reader.constant.ConstantPool;
import org.junit.Test;

/**
 * @Author qishiyu
 * @create 2019/7/30 16:50
 */
public class Readertest {
    /**
     * 常量池测试
     */
    @Test
    public void testConstantReader() {
        FileLoader loader = new FileLoader(this.getClass().getResource("/").getPath());
        byte[] bytes = loader.loadFile("ConstantPoolTest");
        ClassFile file = new ClassFile(new ClassReader(bytes));
    }
}
