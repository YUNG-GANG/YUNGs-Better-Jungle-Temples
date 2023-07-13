package com.yungnickyoung.minecraft.betterjungletemples.world.processor;

import com.mojang.serialization.Codec;
import com.yungnickyoung.minecraft.betterjungletemples.module.StructureProcessorTypeModule;
import com.yungnickyoung.minecraft.yungsapi.api.world.randomize.BlockStateRandomizer;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BlastFurnaceBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class BlastFurnaceProcessor extends StructureProcessor {
    public static final BlastFurnaceProcessor INSTANCE = new BlastFurnaceProcessor();
    public static final Codec<BlastFurnaceProcessor> CODEC = Codec.unit(() -> INSTANCE);

    private static final BlockStateRandomizer SELECTOR = new BlockStateRandomizer(Blocks.DISPENSER.defaultBlockState())
            .addBlock(Blocks.DROPPER.defaultBlockState(), 0.4f)
            .addBlock(Blocks.OBSERVER.defaultBlockState(), 0.2f);

    @Override
    public StructureTemplate.StructureBlockInfo processBlock(LevelReader levelReader,
                                                             BlockPos jigsawPiecePos,
                                                             BlockPos jigsawPieceBottomCenterPos,
                                                             StructureTemplate.StructureBlockInfo blockInfoLocal,
                                                             StructureTemplate.StructureBlockInfo blockInfoGlobal,
                                                             StructurePlaceSettings structurePlacementData) {
        if (blockInfoGlobal.state.is(Blocks.BLAST_FURNACE)) {
            RandomSource randomSource = structurePlacementData.getRandom(blockInfoGlobal.pos);
            BlockState blockState = SELECTOR.get(randomSource);
            blockState = blockState.setValue(DirectionalBlock.FACING, blockInfoGlobal.state.getValue(BlastFurnaceBlock.FACING));
            blockInfoGlobal = new StructureTemplate.StructureBlockInfo(blockInfoGlobal.pos, blockState, null);
        }
        return blockInfoGlobal;
    }

    protected StructureProcessorType<?> getType() {
        return StructureProcessorTypeModule.BLAST_FURNACE_PROCESSOR;
    }
}
