package com.youyou.modules.loader.file;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.Files;
import com.youyou.common.constants.StringConstants;
import com.youyou.common.exception.ExceptionEnum;
import lombok.AllArgsConstructor;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Matcher;

/**
 * @Author qishiyu
 * @create 2019/7/25 15:04
 */
public class FileLoader {

    private File rootFile;

    private String rootPath;

    private List<JarFile> jarFileList = Lists.newArrayList();

    public FileLoader(String rootPath) {
        this.rootPath = rootPath;
        rootFile = new File(rootPath);
        findAllJar(rootFile);
    }

    private void findAllJar(File rootFile) {
        if (rootFile.exists() && rootFile.isDirectory()) {
            for (File file : rootFile.listFiles()) {
                if (file.getName().endsWith(StringConstants.JAR_SUFFIX)) {
                    try {
                        jarFileList.add(new JarFile(file));
                    } catch (IOException e) {
                        throw ExceptionEnum.CONSTRUCTOR_JARFILE_ERROR.getException();
                    }
                }
            }
        }
    }

    public byte[] loadFile(String className) {
        byte[] classByte = findFromFile(className);
        if (classByte != null) {
            return classByte;
        }
        return findFromJars(className);
    }

    private byte[] findFromJars(String className) {
        className = className.replaceAll("\\.", "/");
        className += StringConstants.CLASS_SUFFIX;
        byte[] bytes = null;
        for (JarFile jarFile : jarFileList) {
            if ((jarFile.getJarEntry(className)) != null) {
                try (InputStream inputStream = jarFile.getInputStream(jarFile.getJarEntry(className))) {
                    bytes = IOUtils.toByteArray(inputStream);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        return bytes;
    }

    private byte[] findFromFile(String className) {
        className = className.replaceAll("\\.", Matcher.quoteReplacement(StringConstants.FILE_SEPARATOR));
        className += StringConstants.CLASS_SUFFIX;
        File targetFile = new File(rootPath + className);
        if (targetFile.exists()) {
            try {
                return Files.toByteArray(targetFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
