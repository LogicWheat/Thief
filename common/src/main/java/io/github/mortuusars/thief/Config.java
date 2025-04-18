package io.github.mortuusars.thief;

import net.neoforged.neoforge.common.ModConfigSpec;

/**
 * Using ForgeConfigApiPort on fabric allows using forge config in both environments and without extra dependencies on forge.
 */
public class Config {
    public static class Server {
        public static final ModConfigSpec SPEC;

        static {
            ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

            SPEC = builder.build();
        }
    }

    public static class Client {
        public static final ModConfigSpec SPEC;

        static {
            ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

            SPEC = builder.build();
        }
    }
}