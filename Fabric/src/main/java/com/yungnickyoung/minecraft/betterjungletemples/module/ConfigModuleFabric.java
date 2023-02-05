package com.yungnickyoung.minecraft.betterjungletemples.module;

import com.yungnickyoung.minecraft.betterjungletemples.BetterJungleTemplesCommon;
import com.yungnickyoung.minecraft.betterjungletemples.config.BJTConfigFabric;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.minecraft.world.InteractionResult;

public class ConfigModuleFabric {
    public static void init() {
        AutoConfig.register(BJTConfigFabric.class, Toml4jConfigSerializer::new);
        AutoConfig.getConfigHolder(BJTConfigFabric.class).registerSaveListener(ConfigModuleFabric::bakeConfig);
        AutoConfig.getConfigHolder(BJTConfigFabric.class).registerLoadListener(ConfigModuleFabric::bakeConfig);
        bakeConfig(AutoConfig.getConfigHolder(BJTConfigFabric.class).get());
    }

    private static InteractionResult bakeConfig(ConfigHolder<BJTConfigFabric> configHolder, BJTConfigFabric configFabric) {
        bakeConfig(configFabric);
        return InteractionResult.SUCCESS;
    }

    private static void bakeConfig(BJTConfigFabric configFabric) {
        BetterJungleTemplesCommon.CONFIG.general.disableVanillaJungleTemples = configFabric.general.disableVanillaJungleTemples;
    }
}
