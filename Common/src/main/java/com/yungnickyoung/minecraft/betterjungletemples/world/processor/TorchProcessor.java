package com.yungnickyoung.minecraft.betterjungletemples.world.processor;

import com.mojang.serialization.Codec;
import com.yungnickyoung.minecraft.betterjungletemples.module.StructureProcessorTypeModule;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class TorchProcessor extends StructureProcessor {
    public static final TorchProcessor INSTANCE = new TorchProcessor();
    public static final Codec<TorchProcessor> CODEC = Codec.unit(() -> INSTANCE);

    @Override
    public StructureTemplate.StructureBlockInfo processBlock(LevelReader levelReader,
                                                             BlockPos jigsawPiecePos,
                                                             BlockPos jigsawPieceBottomCenterPos,
                                                             StructureTemplate.StructureBlockInfo blockInfoLocal,
                                                             StructureTemplate.StructureBlockInfo blockInfoGlobal,
                                                             StructurePlaceSettings structurePlacementData) {
        if (blockInfoGlobal.state.is(Blocks.WALL_TORCH) || blockInfoGlobal.state.is(Blocks.TORCH)) {
            RandomSource randomSource = structurePlacementData.getRandom(blockInfoGlobal.pos);
            if (randomSource.nextFloat() < 0.9f) {
                blockInfoGlobal = new StructureTemplate.StructureBlockInfo(blockInfoGlobal.pos, Blocks.AIR.defaultBlockState(), null);
            }
        }
        return blockInfoGlobal;
    }

    protected StructureProcessorType<?> getType() {
        return StructureProcessorTypeModule.TORCH_PROCESSOR;
    }
}
