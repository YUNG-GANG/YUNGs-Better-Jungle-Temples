package com.yungnickyoung.minecraft.betterjungletemples.services;

import com.mojang.serialization.MapCodec;
import com.yungnickyoung.minecraft.betterjungletemples.world.processor.ItemFrameProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;

public class ForgeProcessorProvider implements IProcessorProvider {
    @Override
    public MapCodec<StructureProcessor> itemFrameProcessorCodec() {
        return ItemFrameProcessor.CODEC;
    }
}
