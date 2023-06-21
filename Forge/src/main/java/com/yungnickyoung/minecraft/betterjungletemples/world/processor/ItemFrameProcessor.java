package com.yungnickyoung.minecraft.betterjungletemples.world.processor;

import com.mojang.serialization.Codec;
import com.yungnickyoung.minecraft.betterjungletemples.module.StructureProcessorTypeModule;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.jetbrains.annotations.Nullable;

public class ItemFrameProcessor extends StructureProcessor {
    public static final ItemFrameProcessor INSTANCE = new ItemFrameProcessor();
    public static final Codec<StructureProcessor> CODEC = Codec.unit(() -> INSTANCE);

    @Override
    public StructureTemplate.StructureEntityInfo processEntity(LevelReader levelReader,
                                                               BlockPos structurePiecePos,
                                                               StructureTemplate.StructureEntityInfo localEntityInfo,
                                                               StructureTemplate.StructureEntityInfo globalEntityInfo,
                                                               StructurePlaceSettings structurePlaceSettings,
                                                               StructureTemplate template) {
        if (globalEntityInfo.nbt.getString("id").equals("minecraft:item_frame") || globalEntityInfo.nbt.getString("id").equals("minecraft:glow_item_frame")) {
            // Used to suppress dumb log spam
            globalEntityInfo.nbt.putInt("TileX", globalEntityInfo.blockPos.getX());
            globalEntityInfo.nbt.putInt("TileY", globalEntityInfo.blockPos.getY());
            globalEntityInfo.nbt.putInt("TileZ", globalEntityInfo.blockPos.getZ());
        }
        return globalEntityInfo;
    }

    @Nullable
    @Override
    public StructureTemplate.StructureBlockInfo processBlock(LevelReader levelReader,
                                                             BlockPos jigsawPiecePos,
                                                             BlockPos jigsawPieceBottomCenterPos,
                                                             StructureTemplate.StructureBlockInfo blockInfoLocal,
                                                             StructureTemplate.StructureBlockInfo blockInfoGlobal,
                                                             StructurePlaceSettings structurePlacementData) {
        return blockInfoGlobal;
    }

    protected StructureProcessorType<?> getType() {
        return StructureProcessorTypeModule.ITEM_FRAME_PROCESSOR;
    }
}