package com.yungnickyoung.minecraft.betterjungletemples.world.processor;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.yungnickyoung.minecraft.betterjungletemples.module.StructureProcessorTypeModule;
import com.yungnickyoung.minecraft.yungsapi.world.BlockStateRandomizer;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class BlockReplaceProcessor extends StructureProcessor {
    public static final Codec<BlockReplaceProcessor> CODEC = RecordCodecBuilder.create(instance -> instance
            .group(
                    BlockState.CODEC.fieldOf("target_block").forGetter(config -> config.targetBlock),
                    BlockStateRandomizer.CODEC.fieldOf("output").forGetter(config -> config.output),
                    Codec.BOOL.optionalFieldOf("randomize_facing", false).forGetter(config -> config.randomizeFacing),
                    Codec.BOOL.optionalFieldOf("randomize_half", false).forGetter(config -> config.randomizeHalf),
                    Codec.BOOL.optionalFieldOf("copy_input_properties", false).forGetter(config -> config.copyInputProperties))
            .apply(instance, instance.stable(BlockReplaceProcessor::new)));

    public final BlockState targetBlock;
    public final BlockStateRandomizer output;
    public final boolean randomizeFacing;
    public final boolean randomizeHalf;
    public final boolean copyInputProperties;

    private BlockReplaceProcessor(BlockState targetBlock,
                                  BlockStateRandomizer output,
                                  boolean randomizeFacing,
                                  boolean randomizeHalf,
                                  boolean copyInputProperties) {
        this.targetBlock = targetBlock;
        this.output = output;
        this.randomizeFacing = randomizeFacing;
        this.randomizeHalf = randomizeHalf;
        this.copyInputProperties = copyInputProperties;
    }

    @Override
    public StructureTemplate.StructureBlockInfo processBlock(LevelReader levelReader,
                                                             BlockPos jigsawPiecePos,
                                                             BlockPos jigsawPieceBottomCenterPos,
                                                             StructureTemplate.StructureBlockInfo blockInfoLocal,
                                                             StructureTemplate.StructureBlockInfo blockInfoGlobal,
                                                             StructurePlaceSettings structurePlacementData) {
        if (blockInfoGlobal.state.is(this.targetBlock.getBlock())) {
            RandomSource random = structurePlacementData.getRandom(blockInfoGlobal.pos);
            BlockState outputState = output.get(random);

            if (this.copyInputProperties) {
                if (blockInfoGlobal.state.hasProperty(StairBlock.FACING) && outputState.hasProperty(StairBlock.FACING)) {
                    outputState.setValue(StairBlock.FACING, blockInfoGlobal.state.getValue(StairBlock.FACING));
                }
                if (blockInfoGlobal.state.hasProperty(StairBlock.HALF) && outputState.hasProperty(StairBlock.HALF)) {
                    outputState.setValue(StairBlock.HALF, blockInfoGlobal.state.getValue(StairBlock.HALF));
                }
                if (blockInfoGlobal.state.hasProperty(StairBlock.SHAPE) && outputState.hasProperty(StairBlock.SHAPE)) {
                    outputState.setValue(StairBlock.SHAPE, blockInfoGlobal.state.getValue(StairBlock.SHAPE));
                }
                if (blockInfoGlobal.state.hasProperty(SlabBlock.TYPE) && outputState.hasProperty(SlabBlock.TYPE)) {
                    outputState.setValue(SlabBlock.TYPE, blockInfoGlobal.state.getValue(SlabBlock.TYPE));
                }
            }

            // Randomize output
            if (this.randomizeFacing) {
                if (outputState.hasProperty(BlockStateProperties.HORIZONTAL_FACING)) {
                    outputState = outputState.setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.Plane.HORIZONTAL.getRandomDirection(random));
                }
                if (outputState.hasProperty(BlockStateProperties.FACING)) {
                    outputState = outputState.setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.getRandom(random));
                }
            }
            if (this.randomizeHalf) {
                if (outputState.hasProperty(BlockStateProperties.HALF)) {
                    outputState = outputState.setValue(BlockStateProperties.HALF, random.nextBoolean() ? Half.TOP : Half.BOTTOM);
                }
                if (outputState.hasProperty(BlockStateProperties.DOUBLE_BLOCK_HALF)) {
                    outputState = outputState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, random.nextBoolean() ? DoubleBlockHalf.UPPER : DoubleBlockHalf.LOWER);
                }
                if (outputState.hasProperty(BlockStateProperties.SLAB_TYPE)) {
                    outputState = outputState.setValue(BlockStateProperties.SLAB_TYPE, random.nextBoolean() ? SlabType.TOP : SlabType.BOTTOM);
                }
            }
            blockInfoGlobal = new StructureTemplate.StructureBlockInfo(blockInfoGlobal.pos, outputState, blockInfoGlobal.nbt);
        }
        return blockInfoGlobal;
    }

    protected StructureProcessorType<?> getType() {
        return StructureProcessorTypeModule.BLOCK_REPLACE_PROCESSOR;
    }
}
