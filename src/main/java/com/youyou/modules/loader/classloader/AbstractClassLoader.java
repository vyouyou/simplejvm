package com.youyou.modules.loader.classloader;

import com.youyou.modules.loader.IClassLoader;
import com.youyou.modules.loader.file.FileLoader;

/**
 * @Author qishiyu
 * @create 2019/7/25 15:20
 */
public abstract class AbstractClassLoader<T extends IClassLoader> implements IClassLoader {

    private T parentClassLoader;

    private FileLoader loader;

    public AbstractClassLoader(String targetPath, T parentLoader) {
        this.loader = new FileLoader(targetPath);
        this.parentClassLoader = parentLoader;
    }

    @Override
    public byte[] loadFile(String file) {
        byte[] targetFile = parentClassLoader.loadFile(file);
        return targetFile == null ? loader.loadFile(file) : targetFile;
    }
}
