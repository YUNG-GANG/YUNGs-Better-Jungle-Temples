package com.yungnickyoung.minecraft.betterjungletemples;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(BetterJungleTemplesCommon.MOD_ID)
public class BetterJungleTemplesNeoForge {
    public static IEventBus loadingContextEventBus;

    public BetterJungleTemplesNeoForge(IEventBus eventBus) {
        BetterJungleTemplesNeoForge.loadingContextEventBus = eventBus;

        BetterJungleTemplesCommon.init();
    }
}