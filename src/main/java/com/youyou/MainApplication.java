package com.youyou;

import com.youyou.modules.bootstrap.Boot;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author qishiyu
 * @create 2019/7/15 8:37
 */
@Slf4j
public class MainApplication {

    public static void main(String[] args) {
        new Boot().start(args);
    }
}
