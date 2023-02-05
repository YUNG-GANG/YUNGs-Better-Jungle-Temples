package com.yungnickyoung.minecraft.betterjungletemples;

import com.yungnickyoung.minecraft.betterjungletemples.module.ConfigModule;
import com.yungnickyoung.minecraft.betterjungletemples.services.Services;
import com.yungnickyoung.minecraft.yungsapi.api.YungAutoRegister;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BetterJungleTemplesCommon {
    public static final String MOD_ID = "betterjungletemples";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static final ConfigModule CONFIG = new ConfigModule();

    public static void init() {
        YungAutoRegister.scanPackageForAnnotations("com.yungnickyoung.minecraft.betterjungletemples.module");
        Services.MODULES.loadModules();
    }
}
