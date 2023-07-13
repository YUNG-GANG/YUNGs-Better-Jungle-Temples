package com.yungnickyoung.minecraft.betterjungletemples.module;

import com.yungnickyoung.minecraft.betterjungletemples.BetterJungleTemplesCommon;
import com.yungnickyoung.minecraft.yungsapi.api.autoregister.AutoRegister;

@AutoRegister(BetterJungleTemplesCommon.MOD_ID)
public class CompatModule {
    @AutoRegister("_ignored")
    public static void init() {
        // No longer does anything since Pick Your Poison is not updated to this version of Minecraft.
    }
}
