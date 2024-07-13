package com.yungnickyoung.minecraft.betterjungletemples;

import com.yungnickyoung.minecraft.betterjungletemples.module.ConfigModuleNeoForge;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(BetterJungleTemplesCommon.MOD_ID)
public class BetterJungleTemplesNeoForge {
    public static IEventBus loadingContextEventBus;

    public BetterJungleTemplesNeoForge(IEventBus eventBus, ModContainer container) {
        BetterJungleTemplesNeoForge.loadingContextEventBus = eventBus;

        BetterJungleTemplesCommon.init();
        ConfigModuleNeoForge.init(container);
    }
}