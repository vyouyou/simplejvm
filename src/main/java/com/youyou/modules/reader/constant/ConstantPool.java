package com.youyou.modules.reader.constant;

import com.youyou.common.constants.ClassFileConstants;
import com.youyou.modules.reader.ClassReader;
import lombok.Getter;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author qishiyu
 * @create 2019/7/29 15:13
 */
public class ConstantPool {

    @Getter
    private List<ConstantInfo> constantInfos;

    private ClassReader reader;

    public ConstantPool(ClassReader reader) {
        this.reader = reader;
        int poolSize = reader.readShort();
        constantInfos = new ArrayList<>(poolSize - 1);
        for (int i = 1; i < poolSize; i++) {
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
        }
        if (info != null) {
            info.setTag(tag);
        }
    }
}
