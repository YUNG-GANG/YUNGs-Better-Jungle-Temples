package com.yungnickyoung.minecraft.betterjungletemples.world.processor;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;





public class TorchProcessor implements StructureProcessor {
    public static final TorchProcessor INSTANCE = new TorchProcessor();
    public static final MapCodec<TorchProcessor> CODEC = MapCodec.unit(() -> INSTANCE);

    @Override
    public StructureTemplate.StructureBlockInfo processBlock(LevelReader levelReader,
                                                             BlockPos jigsawPiecePos,
                                                             BlockPos jigsawPieceBottomCenterPos,
                                                             BlockPos blockPos,
                                                             StructureTemplate.StructureBlockInfo blockInfoGlobal,
                                                             StructurePlaceSettings structurePlacementData) {
        if (blockInfoGlobal.state().is(Blocks.WALL_TORCH) || blockInfoGlobal.state().is(Blocks.TORCH)) {
            RandomSource randomSource = structurePlacementData.getRandom(blockInfoGlobal.pos());
            if (randomSource.nextFloat() < 0.9f) {
                blockInfoGlobal = new StructureTemplate.StructureBlockInfo(blockInfoGlobal.pos(), Blocks.AIR.defaultBlockState(), null);
            }
        }
        return blockInfoGlobal;
    }

    @Override
    public MapCodec<? extends StructureProcessor> codec() {
        return CODEC;
    }
}
