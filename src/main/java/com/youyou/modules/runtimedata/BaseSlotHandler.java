package com.youyou.modules.runtimedata;

import com.youyou.common.utils.BitConverter;
import com.youyou.modules.runtimedata.frame.Slot;

import java.util.Arrays;
import java.util.List;

/**
 * 将各种临时变量存储到slot中去
 *
 * @Author qishiyu
 * @create 2019/8/6 20:46
 */
public class BaseSlotHandler<T extends List<Slot>> {
    /**
     * slot 数组
     */
    protected T slotList;

    public void setValue(int index, Object value) {
        if (value instanceof Integer) {
            slotList.get(index).setNum(BitConverter.GetBytes((int) value));
        } else if (value instanceof Float) {
            slotList.get(index).setNum(BitConverter.GetBytes((float) value));
        } else if (value instanceof Long) {
            set64ByteData(index, BitConverter.GetBytes((long) value));
        } else if (value instanceof Double) {
            set64ByteData(index, BitConverter.GetBytes((double) value));
        } else {
            slotList.get(index).setRef(value);
        }
    }

    public int getInt(int index) {
        return BitConverter.toInt32(slotList.get(index).getNum());
    }

    public float getFloat(int index) {
        return BitConverter.toFloat(slotList.get(index).getNum());
    }

    public long getLong(int index) {
        return BitConverter.toInt64(get64ByteData(index));
    }

    public double getDouble(int index) {
        return BitConverter.toDouble(get64ByteData(index));
    }

    private void set64ByteData(int index, byte[] bytes) {
        slotList.get(index).setNum(Arrays.copyOfRange(bytes, 0, 4));
        slotList.get(index + 1).setNum(Arrays.copyOfRange(bytes, 4, 8));
    }

    private byte[] get64ByteData(int index) {
        return BitConverter.concat(slotList.get(index).getNum(), slotList.get(index + 1).getNum());
    }

    public Object getRef(int index) {
        return slotList.get(index).getRef();
    }

    public void setRef(int index, Object ref) {

    }
}
