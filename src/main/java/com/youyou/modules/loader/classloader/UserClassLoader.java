package com.youyou.modules.loader.classloader;

/**
 * @Author qishiyu
 * @create 2019/7/15 19:13
 */
public class UserClassLoader extends AbstractClassLoader<ExtClassLoader> {

    public UserClassLoader(String targetPath, ExtClassLoader parentLoader) {
        super(targetPath,parentLoader);
    }

}
