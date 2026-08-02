package com.yungnickyoung.minecraft.betterjungletemples.world.processor;

import com.mojang.serialization.MapCodec;
import com.yungnickyoung.minecraft.betterjungletemples.module.StructureProcessorTypeModule;
import com.yungnickyoung.minecraft.yungsapi.world.processor.StructureEntityProcessor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.jetbrains.annotations.Nullable;

public class ItemFrameProcessor extends StructureEntityProcessor {
    public static final ItemFrameProcessor INSTANCE = new ItemFrameProcessor();
    public static final MapCodec<StructureProcessor> CODEC = MapCodec.unit(() -> INSTANCE);

    @Override
    public StructureTemplate.StructureEntityInfo processEntity(ServerLevelAccessor serverLevelAccessor,
                                                               BlockPos structurePiecePos,
                                                               BlockPos structurePieceBottomCenterPos,
                                                               StructureTemplate.StructureEntityInfo localEntityInfo,
                                                               StructureTemplate.StructureEntityInfo globalEntityInfo,
                                                               StructurePlaceSettings structurePlaceSettings) {
        if (globalEntityInfo.nbt.getString("id").equals("minecraft:item_frame") || globalEntityInfo.nbt.getString("id").equals("minecraft:glow_item_frame")) {
            // Required to suppress dumb log spam
            globalEntityInfo.nbt.store("block_pos", BlockPos.CODEC, globalEntityInfo.blockPos);
        }
        return globalEntityInfo;
    }

    @Nullable
    @Override
    public StructureTemplate.StructureBlockInfo processBlock(LevelReader levelReader,
                                                             BlockPos jigsawPiecePos,
                                                             BlockPos jigsawPieceBottomCenterPos,
                                                             BlockPos templateRelativePos,
                                                             StructureTemplate.StructureBlockInfo blockInfoGlobal,
                                                             StructurePlaceSettings structurePlacementData) {
        return blockInfoGlobal;
    }

    @Override public MapCodec<? extends StructureProcessor> codec() {
        return StructureProcessorTypeModule.ITEM_FRAME_PROCESSOR;
    }
}