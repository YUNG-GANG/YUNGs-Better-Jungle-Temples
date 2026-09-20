package com.yungnickyoung.minecraft.betterjungletemples.world.processor;

import com.mojang.serialization.MapCodec;
import com.yungnickyoung.minecraft.betterjungletemples.module.StructureProcessorTypeModule;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;





public class FireballDispenserProcessor implements StructureProcessor {
    public static final FireballDispenserProcessor INSTANCE = new FireballDispenserProcessor();
    public static final MapCodec<FireballDispenserProcessor> CODEC = MapCodec.unit(() -> INSTANCE);

    @Override
    public StructureTemplate.StructureBlockInfo processBlock(LevelReader levelReader,
                                                             BlockPos jigsawPiecePos,
                                                             BlockPos jigsawPieceBottomCenterPos,
                                                             BlockPos templateRelativePos,
                                                             StructureTemplate.StructureBlockInfo blockInfoGlobal,
                                                             StructurePlaceSettings structurePlacementData) {
        if (blockInfoGlobal.state().is(Blocks.CONCRETE.orange())) {
            BlockState blockState = Blocks.DISPENSER.defaultBlockState().setValue(DispenserBlock.FACING, Direction.UP);
            CompoundTag newNbt = new CompoundTag();
            ListTag items = new ListTag();
            RandomSource randomSource = structurePlacementData.getRandom(blockInfoGlobal.pos());

            for (int slot = 0; slot < 9; slot++) {
                if (randomSource.nextFloat() < 0.1f || slot == 4) {
                    CompoundTag slotTag = new CompoundTag();
                    slotTag.putByte("Slot", (byte) slot);
                    slotTag.putString("id", "minecraft:fire_charge");
                    slotTag.putByte("Count", (byte) 1);
                    items.add(slotTag);
                }
            }
            newNbt.put("Items", items);
            blockInfoGlobal = new StructureTemplate.StructureBlockInfo(blockInfoGlobal.pos(), blockState, newNbt);
        }
        return blockInfoGlobal;
    }

    public MapCodec<? extends StructureProcessor> codec() {
        return StructureProcessorTypeModule.FIREBALL_DISPENSER_PROCESSOR;
    }
}
