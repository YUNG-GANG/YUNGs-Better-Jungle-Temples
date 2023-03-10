package com.yungnickyoung.minecraft.betterjungletemples.world.util;

import com.yungnickyoung.minecraft.betterjungletemples.module.CompatModule;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.RandomSource;

public class ArrowData {
    public static final ArrowData EMPTY = new ArrowData("minecraft:air");

    private String id;
    private CompoundTag tag;

    public ArrowData(String id, CompoundTag tag) {
        this.id = id;
        this.tag = tag;
    }

    public ArrowData(String id) {
        this.id = id;
        this.tag = null;
    }

    public String getId() {
        return id;
    }

    public boolean hasTag() {
        return tag != null;
    }

    public CompoundTag getTag() {
        return tag;
    }

    public static ArrowData getArrow(RandomSource random) {
        float f = random.nextFloat();
        if (f < 0.3f) {
            return new ArrowData("minecraft:arrow");
        }
        if (f < 0.4f) {
            if (random.nextBoolean() && CompatModule.PICK_YOUR_POISON.enabled) {
                return new ArrowData(CompatModule.PICK_YOUR_POISON.getDart(random));
            } else {
                return new ArrowData("minecraft:tipped_arrow", Util.make(new CompoundTag(), tag -> tag.putString("Potion", "minecraft:poison")));
            }
        }
        return ArrowData.EMPTY;
    }
}
