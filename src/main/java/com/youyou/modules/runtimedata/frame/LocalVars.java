package com.youyou.modules.runtimedata.frame;

import com.youyou.common.utils.BitConverter;
import com.youyou.modules.runtimedata.BaseSlotHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author qishiyu
 * @create 2019/7/31 16:12
 */
public class LocalVars extends BaseSlotHandler {

    public LocalVars(int size) {
        super.slotList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            slotList.add(new Slot());
        }
    }
}
