package com.yungnickyoung.minecraft.betterjungletemples.world.processor;

import com.mojang.serialization.MapCodec;
import com.yungnickyoung.minecraft.betterjungletemples.module.StructureProcessorTypeModule;
import com.yungnickyoung.minecraft.yungsapi.api.world.randomize.BlockStateRandomizer;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CaveVinesBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class CaveVineDecorationProcessor extends StructureProcessor {
    public static final CaveVineDecorationProcessor INSTANCE = new CaveVineDecorationProcessor();
    public static final MapCodec<CaveVineDecorationProcessor> CODEC = MapCodec.unit(() -> INSTANCE);

    private final BlockStateRandomizer randomizer = new BlockStateRandomizer(Blocks.AIR.defaultBlockState())
            .addBlock(Blocks.COBBLESTONE_SLAB.defaultBlockState().setValue(SlabBlock.TYPE, SlabType.TOP), 0.05f)
            .addBlock(Blocks.MOSSY_COBBLESTONE_SLAB.defaultBlockState().setValue(SlabBlock.TYPE, SlabType.TOP), 0.05f)
            .addBlock(Blocks.CAVE_VINES.defaultBlockState(), 0.02f)
            .addBlock(Blocks.HANGING_ROOTS.defaultBlockState(), 0.02f);

    @Override
    public StructureTemplate.StructureBlockInfo processBlock(LevelReader levelReader,
                                                             BlockPos jigsawPiecePos,
                                                             BlockPos jigsawPieceBottomCenterPos,
                                                             StructureTemplate.StructureBlockInfo blockInfoLocal,
                                                             StructureTemplate.StructureBlockInfo blockInfoGlobal,
                                                             StructurePlaceSettings structurePlacementData) {
        if (blockInfoGlobal.state().is(Blocks.GREEN_STAINED_GLASS)) {
            RandomSource randomSource = structurePlacementData.getRandom(blockInfoGlobal.pos());
            BlockState blockState = randomizer.get(randomSource);

            if (blockState.is(Blocks.CAVE_VINES)) {
                int age = Mth.randomBetweenInclusive(randomSource, 0, 25);
                boolean berries = randomSource.nextFloat() < 0.25f;
                blockState = blockState
                        .setValue(CaveVinesBlock.AGE, age)
                        .setValue(CaveVinesBlock.BERRIES, berries);
            }

            blockInfoGlobal = new StructureTemplate.StructureBlockInfo(blockInfoGlobal.pos(), blockState, null);
        }
        return blockInfoGlobal;
    }

    protected StructureProcessorType<?> getType() {
        return StructureProcessorTypeModule.CAVE_VINE_DECORATION_PROCESSOR;
    }
}
