package com.youyou.modules.loader.classloader;

import com.youyou.common.constants.StringConstants;

/**
 * @Author qishiyu
 * @create 2019/7/15 16:28
 */
public class ExtClassLoader extends AbstractClassLoader {

    public ExtClassLoader(BootStrapClassLoader parentLoader) {
        super(System.getProperty("java.home")
                + StringConstants.FILE_SEPARATOR + "lib"
                + StringConstants.FILE_SEPARATOR + "ext",
                parentLoader);
    }

}
