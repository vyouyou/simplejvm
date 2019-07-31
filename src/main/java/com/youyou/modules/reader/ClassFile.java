package com.youyou.modules.reader;

import com.youyou.common.exception.ExceptionEnum;
import com.youyou.modules.reader.constant.ConstantPool;
import lombok.Getter;

/**
 * @Author qishiyu
 * @create 2019/7/27 14:33
 */
public class ClassFile {

    private static final Integer MAGIC_NUMBER = 0xCAFEBABE;

    private static final short JDK_VERSION_8 = 52;

    @Getter
    private ConstantPool constantPool;

    private ClassReader reader;

    public ClassFile(ClassReader reader) {
        this.reader = reader;
        startCompile();
    }

    private void startCompile() {
        checkIsJavaFile();
        checkVersion();
        constantPool = new ConstantPool(reader);
    }

    /**
     * 是否class文件
     */
    private void checkIsJavaFile() {
        if (!MAGIC_NUMBER.equals(reader.readInt())) {
            throw ExceptionEnum.NOT_CLASS_FILE.getException();
        }
    }

    /**
     * 是否正确版本
     */
    private void checkVersion() {
        short minorVersion = reader.readShort();
        short majorVersion = reader.readShort();
        if (majorVersion != JDK_VERSION_8 || minorVersion != 0) {
            throw ExceptionEnum.CLASS_VERSION_NOT_SUPPORT.getException();
        }
    }

}
