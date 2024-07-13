package com.yungnickyoung.minecraft.betterjungletemples.services;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;

public interface IProcessorProvider {
    MapCodec<StructureProcessor> itemFrameProcessorCodec();
}
