package com.yungnickyoung.minecraft.betterjungletemples.module;

import com.yungnickyoung.minecraft.betterjungletemples.BetterJungleTemplesCommon;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.structure.Structure;

public class TagModule {
    public static TagKey<Structure> BETTER_JUNGLE_TEMPLE = TagKey.create(Registry.STRUCTURE_REGISTRY,
            new ResourceLocation(BetterJungleTemplesCommon.MOD_ID, "better_jungle_temples"));
}
