package com.yungnickyoung.minecraft.betterjungletemples;

import net.fabricmc.api.ModInitializer;

public class BetterJungleTemplesFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        BetterJungleTemplesCommon.init();
    }
}
