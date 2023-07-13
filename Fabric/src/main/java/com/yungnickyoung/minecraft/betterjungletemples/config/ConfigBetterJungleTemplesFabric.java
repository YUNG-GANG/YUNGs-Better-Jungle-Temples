package com.yungnickyoung.minecraft.betterjungletemples.config;

import me.shedaniel.autoconfig.annotation.ConfigEntry;

public class ConfigBetterJungleTemplesFabric {
    @ConfigEntry.Category("General")
    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Gui.Tooltip
    public ConfigGeneralFabric general = new ConfigGeneralFabric();
}
