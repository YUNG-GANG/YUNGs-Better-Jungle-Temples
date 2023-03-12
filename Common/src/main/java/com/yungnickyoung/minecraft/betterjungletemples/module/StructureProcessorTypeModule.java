package com.yungnickyoung.minecraft.betterjungletemples.module;

import com.yungnickyoung.minecraft.betterjungletemples.BetterJungleTemplesCommon;
import com.yungnickyoung.minecraft.betterjungletemples.world.processor.BlockReplaceProcessor;
import com.yungnickyoung.minecraft.betterjungletemples.world.processor.EmptyDispenserProcessor;
import com.yungnickyoung.minecraft.betterjungletemples.world.processor.FireballDispenserProcessor;
import com.yungnickyoung.minecraft.betterjungletemples.world.processor.LiquidBlockProcessor;
import com.yungnickyoung.minecraft.betterjungletemples.world.processor.PillarProcessor;
import com.yungnickyoung.minecraft.betterjungletemples.world.processor.WaterlogProcessor;
import com.yungnickyoung.minecraft.yungsapi.api.autoregister.AutoRegister;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;

@AutoRegister(BetterJungleTemplesCommon.MOD_ID)
public class StructureProcessorTypeModule {
    @AutoRegister("pillar_processor")
    public static StructureProcessorType<PillarProcessor> PILLAR_PROCESSOR = () -> PillarProcessor.CODEC;

    @AutoRegister("block_replace_processor")
    public static StructureProcessorType<BlockReplaceProcessor> BLOCK_REPLACE_PROCESSOR = () -> BlockReplaceProcessor.CODEC;

    @AutoRegister("liquid_block_processor")
    public static StructureProcessorType<LiquidBlockProcessor> LIQUID_BLOCK_PROCESSOR = () -> LiquidBlockProcessor.CODEC;

    @AutoRegister("waterlog_processor")
    public static StructureProcessorType<WaterlogProcessor> WATERLOG_PROCESSOR = () -> WaterlogProcessor.CODEC;

    @AutoRegister("empty_dispenser_processor")
    public static StructureProcessorType<EmptyDispenserProcessor> EMPTY_DISPENSER_PROCESSOR = () -> EmptyDispenserProcessor.CODEC;

    @AutoRegister("fireball_dispenser_processor")
    public static StructureProcessorType<FireballDispenserProcessor> FIREBALL_DISPENSER_PROCESSOR = () -> FireballDispenserProcessor.CODEC;
}
