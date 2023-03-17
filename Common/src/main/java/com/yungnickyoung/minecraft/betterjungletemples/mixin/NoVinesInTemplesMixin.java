package com.yungnickyoung.minecraft.betterjungletemples.mixin;

import com.yungnickyoung.minecraft.betterjungletemples.mixin.accessor.WorldGenRegionAccessor;
import com.yungnickyoung.minecraft.betterjungletemples.module.TagModule;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.VinesFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.Structure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Disable vines from spawning within Better Jungle Temples. This is done to prevent floating vines.
 *
 * @author TelepathicGrunt
 */
@Mixin(VinesFeature.class)
public class NoVinesInTemplesMixin {
    @Inject(method = "place", at = @At(value = "HEAD"), cancellable = true)
    private void betterjungletemples_noVinesInTemples(FeaturePlaceContext<NoneFeatureConfiguration> context, CallbackInfoReturnable<Boolean> cir) {
        if (!(context.level() instanceof WorldGenRegion)) {
            return;
        }

        Registry<Structure> configuredStructureFeatureRegistry = context.level().registryAccess().registryOrThrow(Registry.STRUCTURE_REGISTRY);
        StructureManager structureManager = ((WorldGenRegionAccessor) context.level()).getStructureManager();

        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            mutable.set(context.origin()).move(direction);
            for (Holder<Structure> configuredStructureFeature : configuredStructureFeatureRegistry.getOrCreateTag(TagModule.BETTER_JUNGLE_TEMPLE)) {
                if (structureManager.getStructureAt(mutable, configuredStructureFeature.value()).isValid()) {
                    cir.setReturnValue(false);
                    return;
                }
            }
        }
    }
}
