package com.youyou.modules.runtimedata.frame;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author qishiyu
 * @create 2019/7/31 16:13
 */
@Setter
@Getter
public class Slot {
    /**
     * 存放字段
     */
    private byte[] num;
    /**
     * 存放引用
     */
    private Object ref;
}
