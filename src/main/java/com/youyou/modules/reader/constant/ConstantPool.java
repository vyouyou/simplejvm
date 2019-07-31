package com.youyou.modules.reader.constant;

import com.youyou.common.constants.ClassFileConstants;
import com.youyou.modules.reader.ClassReader;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author qishiyu
 * @create 2019/7/29 15:13
 */
@Slf4j
public class ConstantPool {

    @Getter
    private List<ConstantInfo> constantInfos;

    private ClassReader reader;

    public ConstantPool(ClassReader reader) {
        this.reader = reader;
        int poolSize = reader.readShort() - 1;
        constantInfos = new ArrayList<>(poolSize);
        while (constantInfos.size() < poolSize) {
            readConstantInfo();
        }
    }

    private void readConstantInfo() {
        byte tag = reader.readByte();
        ConstantInfo info = null;
        switch (tag) {
            case ClassFileConstants.UTF_INFO:
                info = new ConstantUtf8();
                short messageLength = reader.readShort();
                ((ConstantUtf8) info).setLength(messageLength);
                byte[] messageBytes = reader.readBytes(messageLength);
                try {
                    ((ConstantUtf8) info).setMessage(new String(messageBytes, "utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;
            case ClassFileConstants.FIELD_REF_INFO:
            case ClassFileConstants.METHOD_REF_INFO:
            case ClassFileConstants.INTERFACE_METHOD_REF_INFO:
            case ClassFileConstants.NAME_AND_TYPE_INFO:
            case ClassFileConstants.INVOKE_DYNAMIC_INFO:
                info = new ConstantDoubleIndex();
                ((ConstantDoubleIndex) info).setIndex1(reader.readShort());
                ((ConstantDoubleIndex) info).setIndex2(reader.readShort());
                break;
            case ClassFileConstants.INTEGER_INFO:
                info = new ConstantInteger();
                ((ConstantInteger) info).setValue(reader.readInt());
                break;
            case ClassFileConstants.FLOAT_INFO:
                info = new ConstantFloat();
                ((ConstantFloat) info).setValue(reader.readFloat());
                break;
            // http://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.4.5
            // All 8-byte constants take up two entries in the constant_pool table of the class file.
            // If a CONSTANT_Long_info or CONSTANT_Double_info structure is the item in the constant_pool
            // table at index n, then the next usable item in the pool is located at index n+2.
            // The constant_pool index n+1 must be valid but is considered unusable.
            case ClassFileConstants.LONG_INFO:
                info = new ConstantLong();
                ((ConstantLong) info).setValue(reader.readLong());
                break;
            //指向 utf8常量
            case ClassFileConstants.CLASS_INFO:
            case ClassFileConstants.STRING_INFO:
            case ClassFileConstants.METHOD_HANDLE_INFO:
            case ClassFileConstants.METHOD_TYPE_INFO:
                info = new ConstantSingleIndex();
                ((ConstantSingleIndex) info).setIndex(reader.readShort());
                break;
            case ClassFileConstants.DOUBLE_INFO:
                info = new ConstantDouble();
                ((ConstantDouble) info).setValue(reader.readDouble());
                break;
            default:
                log.info("get unknown tag {}", tag);
        }
        if (info == null) {
            return;
        }
        info.setTag(tag);
        constantInfos.add(info);
        if (tag == ClassFileConstants.DOUBLE_INFO || tag == ClassFileConstants.LONG_INFO) {
            constantInfos.add(new ConstantInfo());
        }
    }
}
