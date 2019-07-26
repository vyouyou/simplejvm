package com.youyou.common.exception;

import lombok.Data;

/**
 * @Author qishiyu
 * @create 2019/7/25 15:48
 */
@Data
public class SmpException extends RuntimeException {

    private String code;

    public SmpException(String code, String message) {
        super(message);
    }
}
