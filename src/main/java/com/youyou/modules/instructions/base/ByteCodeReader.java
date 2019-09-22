package com.youyou.modules.instructions.base;

import com.youyou.common.utils.BitConverter;
import lombok.Data;

import java.util.Arrays;

/**
 * @Author qishiyu
 * @create 2019/9/20 17:19
 */
@Data
public class ByteCodeReader {
    private byte[] code;
    private int pc;

    public void reset(byte[] code, int pc) {
        this.code = code;
        this.pc = pc;
    }

    public byte readByte() {
        return code[pc++];
    }

    public short readShort() {
        return BitConverter.toInt16(Arrays.copyOfRange(code, pc++, pc + 2));
    }

    public int readInt() {
        return BitConverter.toInt16(Arrays.copyOfRange(code, pc++, pc + 4));
    }

    /**
     * 跳过除以4的剩余部分
     */
    public void skipPadding() {
        while (pc % 4 != 0) {
            pc++;
        }
    }
}
