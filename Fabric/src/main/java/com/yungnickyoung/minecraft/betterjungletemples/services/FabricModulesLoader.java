package com.yungnickyoung.minecraft.betterjungletemples.services;

import com.yungnickyoung.minecraft.betterjungletemples.module.*;

public class FabricModulesLoader implements IModulesLoader {
    @Override
    public void loadModules() {
        IModulesLoader.super.loadModules(); // Load common modules
        ConfigModuleFabric.init();
    }
}
