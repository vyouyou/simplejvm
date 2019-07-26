package com.youyou.modules.config;

import com.google.common.collect.Maps;
import com.youyou.common.constants.StringConstants;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @Author qishiyu
 * @create 2019/7/15 15:29
 */
public class BootStrapConfig {

    @Getter
    private String classpath;

    @Getter
    private static final BootStrapConfig config = new BootStrapConfig();

    private final Map<String, Object> configMap = Maps.newConcurrentMap();

    private BootStrapConfig() {

    }

    public void addConfig(String key, Object value) {
        /**
         * 判断config
         */
        switch (key) {
            case StringConstants.CLASSPATH:
            case StringConstants.CP:
                setClasspath(value);
                break;
            default:
        }
    }

    private void setClasspath(Object classpath) {
        this.classpath = (String) classpath;
    }

}
