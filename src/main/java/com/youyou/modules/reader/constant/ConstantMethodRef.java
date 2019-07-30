package com.youyou.modules.reader.constant;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author qishiyu
 * @create 2019/7/29 17:13
 */
@Setter
@Getter
public class ConstantMethodRef extends ConstantInfo{
    private short classIndex;

    private short nameAndTypeIndex;
}
