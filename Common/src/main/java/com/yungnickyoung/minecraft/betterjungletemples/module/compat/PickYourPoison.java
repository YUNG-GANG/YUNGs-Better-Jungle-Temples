package com.yungnickyoung.minecraft.betterjungletemples.module.compat;

import net.minecraft.util.RandomSource;

import java.util.List;

public class PickYourPoison {
    public boolean enabled = false;

    private final List<String> darts = List.of("comatose", "batrachotoxin", "numbness", "vulnerability",
            "torpor", "stimulation", "blindness");

    public String getDart(RandomSource random) {
        String dartName = darts.get(random.nextInt(darts.size()));
        return "pickyourpoison:" + dartName + "_poison_dart";
    }
}
