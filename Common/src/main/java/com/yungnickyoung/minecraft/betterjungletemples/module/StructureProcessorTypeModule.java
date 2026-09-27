package com.yungnickyoung.minecraft.betterjungletemples.module;

import com.mojang.serialization.MapCodec;
import com.yungnickyoung.minecraft.betterjungletemples.BetterJungleTemplesCommon;
import com.yungnickyoung.minecraft.betterjungletemples.services.Services;
import com.yungnickyoung.minecraft.betterjungletemples.world.processor.BlastFurnaceProcessor;
import com.yungnickyoung.minecraft.betterjungletemples.world.processor.BlockReplaceProcessor;
import com.yungnickyoung.minecraft.betterjungletemples.world.processor.CaveVineDecorationProcessor;
import com.yungnickyoung.minecraft.betterjungletemples.world.processor.EmptyDispenserProcessor;
import com.yungnickyoung.minecraft.betterjungletemples.world.processor.FireballDispenserProcessor;
import com.yungnickyoung.minecraft.betterjungletemples.world.processor.PillarProcessor;
import com.yungnickyoung.minecraft.betterjungletemples.world.processor.TorchProcessor;
import com.yungnickyoung.minecraft.yungsapi.api.autoregister.AutoRegister;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;

@AutoRegister(BetterJungleTemplesCommon.MOD_ID)
public class StructureProcessorTypeModule {
    @AutoRegister("pillar_processor")
    public static MapCodec<? extends StructureProcessor> PILLAR_PROCESSOR = PillarProcessor.CODEC;

    @AutoRegister("block_replace_processor")
    public static MapCodec<? extends StructureProcessor> BLOCK_REPLACE_PROCESSOR = BlockReplaceProcessor.CODEC;

    @AutoRegister("empty_dispenser_processor")
    public static MapCodec<? extends StructureProcessor> EMPTY_DISPENSER_PROCESSOR = EmptyDispenserProcessor.CODEC;

    @AutoRegister("fireball_dispenser_processor")
    public static MapCodec<? extends StructureProcessor> FIREBALL_DISPENSER_PROCESSOR = FireballDispenserProcessor.CODEC;

    @AutoRegister("cave_vine_decoration_processor")
    public static MapCodec<? extends StructureProcessor> CAVE_VINE_DECORATION_PROCESSOR = CaveVineDecorationProcessor.CODEC;

    @AutoRegister("torch_processor")
    public static MapCodec<? extends StructureProcessor> TORCH_PROCESSOR = TorchProcessor.CODEC;

    @AutoRegister("blast_furnace_processor")
    public static MapCodec<? extends StructureProcessor> BLAST_FURNACE_PROCESSOR = BlastFurnaceProcessor.CODEC;

    @AutoRegister("item_frame_processor")
    public static MapCodec<? extends StructureProcessor> ITEM_FRAME_PROCESSOR = Services.PROCESSORS.itemFrameProcessorCodec();
}
