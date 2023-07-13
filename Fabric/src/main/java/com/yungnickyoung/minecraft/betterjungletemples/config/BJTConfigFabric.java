package com.yungnickyoung.minecraft.betterjungletemples.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name="betterjungletemples-fabric-1_20")
public class BJTConfigFabric implements ConfigData {
    @ConfigEntry.Category("Better Jungle Temples")
    @ConfigEntry.Gui.TransitiveObject
    public ConfigBetterJungleTemplesFabric betterJungleTemples = new ConfigBetterJungleTemplesFabric();
}
