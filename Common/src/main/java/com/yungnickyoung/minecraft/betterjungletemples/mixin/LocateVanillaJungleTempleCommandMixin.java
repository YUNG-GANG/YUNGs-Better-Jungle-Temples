package com.yungnickyoung.minecraft.betterjungletemples.mixin;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.yungnickyoung.minecraft.betterjungletemples.BetterJungleTemplesCommon;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.ResourceOrTagLocationArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.commands.LocateCommand;
import net.minecraft.world.level.levelgen.structure.Structure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

/**
 * Overrides behavior of /locate structure jungle_temple.
 */
@Mixin(LocateCommand.class)
public class LocateVanillaJungleTempleCommandMixin {
    private static final SimpleCommandExceptionType OLD_JUNGLE_TEMPLE_EXCEPTION =
            new SimpleCommandExceptionType(Component.translatable("Use /locate structure betterjungletemples:jungle_temple instead!"));

    @Inject(method = "locateStructure", at = @At(value = "HEAD"))
    private static void betterjungletemples_overrideLocateVanillaJungleTemple(CommandSourceStack cmdSource,
                                                                       ResourceOrTagLocationArgument.Result<Structure> result,
                                                                       CallbackInfoReturnable<Integer> ci) throws CommandSyntaxException {
        Optional<ResourceKey<Structure>> optional = result.unwrap().left();
        if (BetterJungleTemplesCommon.CONFIG.general.disableVanillaJungleTemples && optional.isPresent()
                && optional.get().location().equals(new ResourceLocation("jungle_pyramid"))) {
            throw OLD_JUNGLE_TEMPLE_EXCEPTION.create();
        }
    }
}
