package com.yungnickyoung.minecraft.betterjungletemples.module;

public class ConfigModule {
    public General general = new General();
    public Compat compat = new Compat();

    public static class General {
        public boolean disableVanillaJungleTemples = true;
    }

    public static class Compat {
        public boolean pickYourPoisonEnabled = true;
    }
}
