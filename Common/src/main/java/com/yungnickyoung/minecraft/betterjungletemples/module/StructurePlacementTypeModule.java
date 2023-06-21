package com.yungnickyoung.minecraft.betterjungletemples.module;

import com.yungnickyoung.minecraft.betterjungletemples.BetterJungleTemplesCommon;
import com.yungnickyoung.minecraft.betterjungletemples.world.placement.BetterJungleTemplePlacement;
import com.yungnickyoung.minecraft.yungsapi.api.autoregister.AutoRegister;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacementType;

@AutoRegister(BetterJungleTemplesCommon.MOD_ID)
public class StructurePlacementTypeModule {
    @AutoRegister("jungle_temple")
    public static final StructurePlacementType<BetterJungleTemplePlacement> BETTER_JUNGLE_TEMPLE_PLACEMENT = () -> BetterJungleTemplePlacement.CODEC;
}
