package com.youyou.modules.runtimedata;

import com.youyou.modules.runtimedata.frame.Frame;
import lombok.Getter;
import lombok.Setter;

import java.util.Stack;

/**
 * @Author qishiyu
 * @create 2019/7/31 15:53
 */

public class SmpThread {
    /**
     * 计数器
     */
    @Setter
    @Getter
    private int pc = 0;

    private Stack<Frame> stack;

    public SmpThread() {
        stack = new Stack<Frame>();
    }

    public void pushFrame(Frame frame) {
        stack.push(frame);
    }

    public Frame popFrame(){
        return stack.pop();
    }

    public Frame currentFrame(){
        return stack.firstElement();
    }
}
