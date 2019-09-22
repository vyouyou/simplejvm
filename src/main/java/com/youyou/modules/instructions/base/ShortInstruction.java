package com.youyou.modules.instructions.base;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author qishiyu
 * @create 2019/9/21 10:23
 */
public abstract class ShortInstruction implements Instruction {

    @Setter
    @Getter
    private short offset;

    @Override
    public void fetchOperands(ByteCodeReader reader) {
        
    }
}
