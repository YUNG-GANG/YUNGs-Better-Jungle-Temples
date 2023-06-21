package com.yungnickyoung.minecraft.betterjungletemples.services;

import com.mojang.serialization.Codec;
import com.yungnickyoung.minecraft.betterjungletemples.world.processor.ItemFrameProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;

public class FabricProcessorProvider implements IProcessorProvider {
    @Override
    public Codec<StructureProcessor> itemFrameProcessorCodec() {
        return ItemFrameProcessor.CODEC;
    }
}
