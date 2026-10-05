package com.yungnickyoung.minecraft.betterjungletemples.module;

import com.yungnickyoung.minecraft.betterjungletemples.BetterJungleTemplesCommon;
import com.yungnickyoung.minecraft.betterjungletemples.world.placement.BetterJungleTemplePlacement;
import com.yungnickyoung.minecraft.yungsapi.api.autoregister.AutoRegister;
import com.mojang.serialization.MapCodec;

@AutoRegister(BetterJungleTemplesCommon.MOD_ID)
public class StructurePlacementTypeModule {
    @AutoRegister("jungle_temple")
    public static final MapCodec<BetterJungleTemplePlacement> BETTER_JUNGLE_TEMPLE_PLACEMENT = BetterJungleTemplePlacement.CODEC;
}
