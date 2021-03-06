package com.ustctuixue.arcaneart.ritual;

import net.minecraftforge.common.ForgeConfigSpec;


public class RitualConfig {
    public RitualConfig(ForgeConfigSpec.Builder builder)
    {
        load(builder);
    }

    public static ForgeConfigSpec.IntValue LONGEST_DISTANCE_FROM_TABLE_TO_DING;
    public static ForgeConfigSpec.IntValue SHORTEST_DISTANCE_FROM_TABLE_TO_DING;
    public static ForgeConfigSpec.IntValue LOWEST_HEIGHT_OF_DING;
    public static ForgeConfigSpec.IntValue HIGHEST_HEIGHT_OF_DING;
    public static ForgeConfigSpec.DoubleValue RITUAL_MANA_AMPLIFIER;

    static void load(ForgeConfigSpec.Builder builder) {
        builder.push("ritual_module");

        SHORTEST_DISTANCE_FROM_TABLE_TO_DING = builder
                .comment("Control the horizontal distance between the ritual table and the center Ding.")
                .defineInRange("shortestHorizontalDistanceFromTableToDing", 5, 3, 16);

        LONGEST_DISTANCE_FROM_TABLE_TO_DING = builder
                .comment("Control the horizontal distance between the ritual table and the center Ding.")
                .defineInRange("LongestHorizontalDistanceFromTableToDing", 7, 3, 16);

        LOWEST_HEIGHT_OF_DING = builder
                .comment("The lowest height of the plane of Dings' matrix relatively to the height of the ritual table. \n" +
                        "Negative value means the Dings be put lower than the ritual table, and positive value means higher.")
                .defineInRange("lowestHeightOfDing", -2, -20, 10);

        HIGHEST_HEIGHT_OF_DING = builder
                .comment("The highest height of the plane of Dings' matrix relatively to the height of the ritual table. \n" +
                        "Negative value means the Dings be put lower than the ritual table, and positive value means higher.")
                .defineInRange("highestHeightOfDing", 4, -10, 20);
        RITUAL_MANA_AMPLIFIER = builder
                .comment("The percentage of mana cost on ritual by ritual table.")
                .defineInRange("ritualManaAmplifier", 0.9, 0, 1);

        builder.pop();
    }
}
