package com.youyou.modules.loader.classloader;

import com.youyou.common.constants.StringConstants;
import com.youyou.modules.loader.IClassLoader;
import com.youyou.modules.loader.file.FileLoader;

/**
 * @Author qishiyu
 * @create 2019/7/15 16:27
 */
public class BootStrapClassLoader implements IClassLoader {

    private FileLoader loader;

    public BootStrapClassLoader() {
        String path = System.getProperty("java.home") + StringConstants.FILE_SEPARATOR + "lib";
        loader = new FileLoader(path);
    }

    @Override
    public byte[] loadFile(String file) {
        return loader.loadFile(file);
    }
}
