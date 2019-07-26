package com.youyou.modules.loader;

import java.io.File;

/**
 * @Author qishiyu
 * @create 2019/7/25 15:12
 */
public interface IClassLoader {
    /**
     * 装载file
     *
     * @param file
     * @return
     */
    byte[] loadFile(String file);
}
