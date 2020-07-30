package com.ustctuixue.arcaneart.ritual.ritualMagic;

import com.ustctuixue.arcaneart.ArcaneArt;
import com.ustctuixue.arcaneart.api.ritual.Ritual;
import net.minecraft.item.Items;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public class RitualModuleRegistries {
    public static final DeferredRegister<Ritual> RITUAL_DEFERRED_REGISTER
            = new DeferredRegister<>(Ritual.REGISTRY, ArcaneArt.MOD_ID);

    public static final RegistryObject<Ritual> RITUAL_RAIN
            = RITUAL_DEFERRED_REGISTER.register("ritual_rain",
                new Ritual.Builder()
                        .setExecRitual(new RitualRain())
                        .setIngredients(null, null, null, null, Items.LAPIS_LAZULI)
                        .supplier());
}
