package com.youyou.modules.instructions.constants;

import com.youyou.modules.instructions.base.ByteCodeReader;
import com.youyou.modules.instructions.base.Instruction;
import com.youyou.modules.runtimedata.OperandStack;
import lombok.Data;

/**
 * @Author qishiyu
 * @create 2019/9/21 11:18
 */
public class IPush {
    /**
     * push byte
     */
    @Data
    public static class BiPush implements Instruction {
        private byte val;

        @Override
        public void fetchOperands(ByteCodeReader reader) {
            val = reader.readByte();
        }

        @Override
        public void execute(OperandStack operandStack) {
            operandStack.pushValue((int) val);
        }
    }

    /**
     * push short
     */
    @Data
    public static class SiPush implements Instruction {

        private short val;

        @Override
        public void fetchOperands(ByteCodeReader reader) {
            val = reader.readShort();
        }

        @Override
        public void execute(OperandStack operandStack) {
            operandStack.pushValue((int) val);
        }
    }
}
