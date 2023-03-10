package com.yungnickyoung.minecraft.betterjungletemples.module;

import com.yungnickyoung.minecraft.betterjungletemples.BetterJungleTemplesCommon;
import com.yungnickyoung.minecraft.betterjungletemples.module.compat.PickYourPoison;
import com.yungnickyoung.minecraft.betterjungletemples.services.Services;
import com.yungnickyoung.minecraft.yungsapi.api.autoregister.AutoRegister;

@AutoRegister(BetterJungleTemplesCommon.MOD_ID)
public class CompatModule {
    public static PickYourPoison PICK_YOUR_POISON = new PickYourPoison();

    @AutoRegister("_ignored")
    public static void init() {
        if (BetterJungleTemplesCommon.CONFIG.compat.pickYourPoisonEnabled && Services.PLATFORM.isModLoaded("pickyourpoison")) {
            PICK_YOUR_POISON.enabled = true;
        }
    }
}
