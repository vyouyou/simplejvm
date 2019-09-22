package com.youyou.modules.instructions.base;

/**
 * @Author qishiyu
 * @create 2019/9/21 10:18
 */
public abstract class NoOperandInstruction implements Instruction {

    private short offset;

    @Override
    public void fetchOperands(ByteCodeReader reader) {
        offset = reader.readByte();
    }
}
