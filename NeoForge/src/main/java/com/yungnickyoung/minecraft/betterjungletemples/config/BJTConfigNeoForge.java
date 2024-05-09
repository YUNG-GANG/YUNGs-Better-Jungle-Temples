package com.yungnickyoung.minecraft.betterjungletemples.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class BJTConfigNeoForge {
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;

    public static final ConfigGeneralNeoForge general;

    static {
        BUILDER.push("YUNG's Better Jungle Temples");

        general = new ConfigGeneralNeoForge(BUILDER);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}