package com.youyou.modules.instructions.base;

import com.youyou.modules.runtimedata.OperandStack;
import com.youyou.modules.runtimedata.frame.Frame;
import lombok.Data;

/**
 * @Author qishiyu
 * @create 2019/9/20 17:16
 */
public interface Instruction {
    /**
     * 获取操作数
     *
     * @param reader
     */
    void fetchOperands(ByteCodeReader reader);

    /**
     * 执行操作
     *
     * @param operandStack
     */
    void execute(OperandStack operandStack);
}
