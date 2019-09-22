package com.youyou.modules.instructions.constants;

import com.youyou.modules.instructions.base.ByteCodeReader;
import com.youyou.modules.instructions.base.NoOperandInstruction;
import com.youyou.modules.runtimedata.OperandStack;
import com.youyou.modules.runtimedata.frame.Frame;

/**
 * @Author qishiyu
 * @create 2019/9/21 10:16
 */
public class Constant {
    /**
     * push null
     */
    public static class AConstNull extends NoOperandInstruction {
        @Override
        public void execute(OperandStack stack) {
            stack.pushRef(null);
        }
    }

    //push double 类型

    public static class DConst0 extends NoOperandInstruction {
        @Override
        public void execute(OperandStack operandStack) {
            operandStack.pushValue(0.0d);
        }
    }

    public static class DConst1 extends NoOperandInstruction {
        @Override
        public void execute(OperandStack operandStack) {
            operandStack.pushValue(1.0d);
        }
    }

    //push float 类型

    public static class FConst0 extends NoOperandInstruction {
        @Override
        public void execute(OperandStack operandStack) {
            operandStack.pushValue(0.0f);
        }
    }

    public static class FConst1 extends NoOperandInstruction {
        @Override
        public void execute(OperandStack operandStack) {
            operandStack.pushValue(1.0f);
        }
    }

    public static class FConst2 extends NoOperandInstruction {
        @Override
        public void execute(OperandStack operandStack) {
            operandStack.pushValue(2.0f);
        }
    }

    // push int 类型

    public static class IConstM1 extends NoOperandInstruction {
        @Override
        public void execute(OperandStack operandStack) {
            operandStack.pushValue(-1);
        }
    }

    public static class IConst0 extends NoOperandInstruction {
        @Override
        public void execute(OperandStack operandStack) {
            operandStack.pushValue(0);
        }
    }

    public static class IConst1 extends NoOperandInstruction {
        @Override
        public void execute(OperandStack operandStack) {
            operandStack.pushValue(1);
        }
    }

    public static class IConst2 extends NoOperandInstruction {
        @Override
        public void execute(OperandStack operandStack) {
            operandStack.pushValue(2);
        }
    }

    public static class IConst3 extends NoOperandInstruction {
        @Override
        public void execute(OperandStack operandStack) {
            operandStack.pushValue(3);
        }
    }

    public static class IConst4 extends NoOperandInstruction {
        @Override
        public void execute(OperandStack operandStack) {
            operandStack.pushValue(4);
        }
    }

    public static class IConst5 extends NoOperandInstruction {
        @Override
        public void execute(OperandStack operandStack) {
            operandStack.pushValue(5);
        }
    }

    // push long 类型

    public static class LConst0 extends NoOperandInstruction {
        @Override
        public void execute(OperandStack operandStack) {
            operandStack.pushValue(0L);
        }
    }

    public static class LConst1 extends NoOperandInstruction {
        @Override
        public void execute(OperandStack operandStack) {
            operandStack.pushValue(1L);
        }
    }


}
