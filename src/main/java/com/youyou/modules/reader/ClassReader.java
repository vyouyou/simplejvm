package com.youyou.modules.reader;

import com.youyou.common.utils.BitConverter;

import java.util.Arrays;

/**
 * @Author qishiyu
 * @create 2019/7/26 15:43
 */
public class ClassReader {

    private byte[] bytes;

    private Integer byteIndex = 0;

    public ClassReader(byte[] bytes) {
        this.bytes = bytes;
    }

    public byte readByte() {
        return bytes[byteIndex++];
    }

    public short readShort() {
        return BitConverter.toInt16(Arrays.copyOfRange(bytes, byteIndex, byteIndex = byteIndex + 2));
    }

    public int readInt() {
        return BitConverter.toInt32(Arrays.copyOfRange(bytes, byteIndex, byteIndex = byteIndex + 4));
    }

    public long readLong() {
        return BitConverter.toInt64(Arrays.copyOfRange(bytes, byteIndex, byteIndex = byteIndex + 8));
    }

    public float readFloat() {
        return BitConverter.toFloat(Arrays.copyOfRange(bytes, byteIndex, byteIndex = byteIndex + 4));
    }

    public double readDouble() {
        return BitConverter.toDouble(Arrays.copyOfRange(bytes, byteIndex, byteIndex = byteIndex + 8));
    }

    public byte[] readBytes(int n) {
        return Arrays.copyOfRange(bytes, byteIndex, byteIndex += n);
    }
}
