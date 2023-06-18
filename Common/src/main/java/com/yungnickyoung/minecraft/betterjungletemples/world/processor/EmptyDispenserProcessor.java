package com.yungnickyoung.minecraft.betterjungletemples.world.processor;

import com.mojang.serialization.Codec;
import com.yungnickyoung.minecraft.betterjungletemples.module.StructureProcessorTypeModule;
import com.yungnickyoung.minecraft.betterjungletemples.world.util.ArrowData;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
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
public class EmptyDispenserProcessor extends StructureProcessor {
    public static final EmptyDispenserProcessor INSTANCE = new EmptyDispenserProcessor();
    public static final Codec<EmptyDispenserProcessor> CODEC = Codec.unit(() -> INSTANCE);

    @Override
    public StructureTemplate.StructureBlockInfo processBlock(LevelReader levelReader,
                                                             BlockPos jigsawPiecePos,
                                                             BlockPos jigsawPieceBottomCenterPos,
                                                             StructureTemplate.StructureBlockInfo blockInfoLocal,
                                                             StructureTemplate.StructureBlockInfo blockInfoGlobal,
                                                             StructurePlaceSettings structurePlacementData) {
        if (blockInfoGlobal.state.is(Blocks.DISPENSER)) {
            ListTag items = blockInfoGlobal.nbt.getList("Items", ListTag.TAG_COMPOUND);
            if (items.size() == 0) {
                RandomSource randomSource = structurePlacementData.getRandom(blockInfoGlobal.pos);
                for (int slot = 0; slot < 9; slot++) {
                    // Get random arrow item to add
                    ArrowData arrowData = ArrowData.getArrow(randomSource, 0.2f, 0.1f);
                    if (arrowData == ArrowData.EMPTY) {
                        continue;
                    }

                    String arrowId = arrowData.getId();
                    CompoundTag arrowTag = arrowData.getTag();
                    int count = 1;

                    // Populate NBT for this slot in dispenser
                    CompoundTag slotTag = new CompoundTag();
                    slotTag.putByte("Slot", (byte) slot);
                    slotTag.putString("id", arrowId);
                    slotTag.putByte("Count", (byte) count);
                    if (arrowTag != null) {
                        slotTag.put("tag", arrowTag);
                    }

                    // Add item
                    items.add(slotTag);
                }
                blockInfoGlobal.nbt.put("Items", items);
            }
        }
        return blockInfoGlobal;
    }

    protected StructureProcessorType<?> getType() {
        return StructureProcessorTypeModule.EMPTY_DISPENSER_PROCESSOR;
    }
}
