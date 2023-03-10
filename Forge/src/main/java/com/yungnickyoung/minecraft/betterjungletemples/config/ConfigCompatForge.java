package com.yungnickyoung.minecraft.betterjungletemples.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigCompatForge {
    public final ForgeConfigSpec.ConfigValue<Boolean> pickYourPoisonEnabled;

    public ConfigCompatForge(final ForgeConfigSpec.Builder BUILDER) {
        BUILDER.push("General");

        pickYourPoisonEnabled = BUILDER
                .worldRestart()
                .comment("Whether PYP poison darts should spawn in Better Jungle Temples.")
                .define("Enable Pick Your Poison Compatibility", true);

        BUILDER.pop();
    }
}

