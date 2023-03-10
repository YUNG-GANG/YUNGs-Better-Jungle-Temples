package com.yungnickyoung.minecraft.betterjungletemples.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class BJTConfigForge {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ConfigGeneralForge general;
    public static final ConfigCompatForge compat;

    static {
        BUILDER.push("YUNG's Better Jungle Temples");

        general = new ConfigGeneralForge(BUILDER);
        compat = new ConfigCompatForge(BUILDER);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}