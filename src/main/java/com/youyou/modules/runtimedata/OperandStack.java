package com.youyou.modules.runtimedata;

import com.google.common.collect.Lists;
import com.youyou.modules.runtimedata.frame.Slot;

import java.util.List;
import java.util.Stack;

/**
 * 操作数栈 存放数据栈以及对于数据的操作
 *
 * @Author qishiyu
 * @create 2019/8/2 17:06
 */
public class OperandStack extends BaseSlotHandler<Stack<Slot>> {

    private int index;

    public OperandStack() {
        index = 0;
        super.slotList = new Stack<>();
    }

    public void pushInt(int value) {
    }

    public int popInt() {
        int value = getInt(index);
        pop();
        index--;
        return value;
    }

    public void pushFloat(float value) {
    }

    public float popFloat() {
        float value = getFloat(index);
        pop();
        index--;
        return value;
    }

    public void pushLong(long value) {
    }

    private void push() {
        slotList.push(new Slot());
    }

    private void pop() {
        slotList.pop();
    }

}
