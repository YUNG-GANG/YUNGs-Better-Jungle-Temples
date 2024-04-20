package com.yungnickyoung.minecraft.betterjungletemples.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ConfigGeneralNeoForge {
    public final ModConfigSpec.ConfigValue<Boolean> disableVanillaJungleTemples;

    public ConfigGeneralNeoForge(final ModConfigSpec.Builder BUILDER) {
        BUILDER.push("General");

        disableVanillaJungleTemples = BUILDER
                .worldRestart()
                .define("Disable Vanilla Jungle Temples", true);

        BUILDER.pop();
    }
}

