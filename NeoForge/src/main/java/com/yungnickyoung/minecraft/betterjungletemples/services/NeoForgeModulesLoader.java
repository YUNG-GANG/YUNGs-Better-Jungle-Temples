package com.yungnickyoung.minecraft.betterjungletemples.services;

import com.yungnickyoung.minecraft.betterjungletemples.module.*;

public class NeoForgeModulesLoader implements IModulesLoader {
    @Override
    public void loadModules() {
        IModulesLoader.super.loadModules(); // Load common modules
        ConfigModuleNeoForge.init();
    }
}
