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

    public void pushValue(int value) {
        push(value);
    }

    public int popInt() {
        int value = getInt(index);
        pop();
        index--;
        return value;
    }

    public void pushValue(float value) {
        push(value);
    }

    public float popFloat() {
        float value = getFloat(index);
        pop();
        index--;
        return value;
    }

    public void pushValue(long value) {
        push(value);
    }

    public void pushValue(double value) {
        push(value);
    }

    public void pushRef(Object object) {
        setValue(index++, object);
    }

    private void pop() {
        slotList.pop();
    }

    private void push(Object object) {
        slotList.add(new Slot());
        int tempIndex = index + 1;
        if (object instanceof Long || object instanceof Double) {
            slotList.add(new Slot());
            tempIndex++;
        }
        setValue(index, object);
        index = tempIndex;
    }

}
