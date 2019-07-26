package com.youyou.modules.bootstrap;

import com.youyou.common.constants.StringConstants;
import com.youyou.modules.config.BootStrapConfig;

/**
 * @Author qishiyu
 * @create 2019/7/15 8:48
 */
public class Boot {

    private BootStrapConfig bootStrapConfig;

    public Boot() {
        bootStrapConfig = BootStrapConfig.getConfig();
    }

    public void start(String[] args) {
        putBootOptions(args);
    }

    private void putBootOptions(String[] args) {
        for (String arg : args) {
            if (arg.startsWith(StringConstants.OPTION_PREFIX) && arg.indexOf("=") > 0) {
                String[] splitOptions = arg.split("=");
                bootStrapConfig.addConfig(splitOptions[0], splitOptions[1]);
            }
        }
    }

}
