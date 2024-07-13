package com.yungnickyoung.minecraft.betterjungletemples.world.util;

import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.RandomSource;

public class ArrowData {
    public static final ArrowData EMPTY = new ArrowData("minecraft:air");

    private final String id;
    private final CompoundTag componentsTag;

    public ArrowData(String id, String potionId) {
        this.id = id;
        this.componentsTag = Util.make(new CompoundTag(), tag -> {
            tag.put("minecraft:potion_contents", Util.make(new CompoundTag(), potionTag -> {
                potionTag.putString("potion", potionId);
            }));
        });
    }

    public ArrowData(String id) {
        this.id = id;
        this.componentsTag = null;
    }

    public String getId() {
        return id;
    }

    public boolean isTipped() {
        return componentsTag != null;
    }

    public CompoundTag getComponentsTag() {
        return componentsTag;
    }

    public static ArrowData getArrow(RandomSource random, float chance, float tippedChance) {
        float f = random.nextFloat();
        if (f < chance) {
            return new ArrowData("minecraft:arrow");
        }
        if (f < chance + tippedChance) {
//            if (random.nextBoolean() && CompatModule.PICK_YOUR_POISON.enabled) {
//                return new ArrowData(CompatModule.PICK_YOUR_POISON.getDart(random));
//            } else {
            return new ArrowData("minecraft:tipped_arrow", "minecraft:poison");
//            }
        }
        return ArrowData.EMPTY;
    }
}
