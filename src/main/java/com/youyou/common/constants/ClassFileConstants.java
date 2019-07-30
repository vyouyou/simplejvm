package com.youyou.common.constants;

/**
 * @Author qishiyu
 * @create 2019/7/29 19:07
 */
public interface ClassFileConstants {
    short
            /**
             * utf-8
             */
            UTF_INFO = 1,
    /**
     * int
     */
    INTEGER_INFO = 3,
    /**
     * float
     */
    FLOAT_INFO = 4,
    /**
     * long
     */
    LONG_INFO = 5,
    /**
     * double
     */
    DOUBLE_INFO = 6,
    /**
     * class 信息
     */
    CLASS_INFO = 7,
    /**
     * 字符串常量
     */
    STRING_INFO = 8,
    /**
     * 字符符号引用
     */
    FIELD_REF_INFO = 9,
    /**
     * 类中方法引用
     */
    METHOD_REF_INFO = 10,
    /**
     * 接口方法引用
     */
    INTERFACE_METHOD_REF_INFO = 11,
    /**
     * 字段或者方法
     */
    NAME_AND_TYPE_INFO = 12,
    /**
     * 方法句柄
     */
    METHOD_HANDLE_INFO = 15,
    /**
     * 标识方法类型
     */
    METHOD_TYPE_INFO = 16,
    /**
     * 动态方法调用点
     */
    INVOKE_DYNAMIC_INFO = 18;

}
