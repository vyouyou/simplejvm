package com.youyou.common.exception;

/**
 * @Author qishiyu
 * @create 2019/7/15 15:23
 */
public enum ExceptionEnum {
    FILEPATH_NOT_EXISTS("100", "文件不存在"),
    CONSTRUCTOR_JARFILE_ERROR("200", "创建jar文件失败"),
    MAKE_CLASS_FILE_ERROR("300", "创建class文件错误"),
    NOT_CLASS_FILE("301", "不是class文件"),
    CLASS_VERSION_NOT_SUPPORT("302", "版本不支持"),

    END_ERROR("99999", "");

    private String code;

    private String message;

    ExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public SmpException getException() {
        return new SmpException(code, message);
    }
}
