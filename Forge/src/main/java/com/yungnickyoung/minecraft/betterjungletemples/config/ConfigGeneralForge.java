package com.yungnickyoung.minecraft.betterjungletemples.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigGeneralForge {
    public final ForgeConfigSpec.ConfigValue<Boolean> disableVanillaJungleTemples;

    public ConfigGeneralForge(final ForgeConfigSpec.Builder BUILDER) {
        BUILDER.push("General");

        disableVanillaJungleTemples = BUILDER
                .worldRestart()
                .define("Disable Vanilla Jungle Temples", true);

        BUILDER.pop();
    }
}

