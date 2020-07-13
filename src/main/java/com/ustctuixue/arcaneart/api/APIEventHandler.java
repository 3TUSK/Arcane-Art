package com.ustctuixue.arcaneart.api;

import com.ustctuixue.arcaneart.ArcaneArt;
import com.ustctuixue.arcaneart.api.mp.CapabilityMP;
import com.ustctuixue.arcaneart.api.mp.IManaBar;
import com.ustctuixue.arcaneart.api.mp.DefaultManaBar;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class APIEventHandler
{
    static final Logger LOGGER = LogManager.getLogger(ArcaneArt.MOD_NAME + " API");

    private static final Marker MAGIC_REGEN = MarkerManager.getMarker("Magic Regen");
    private static final Marker SETUP = MarkerManager.getMarker("SetUp");

    @SubscribeEvent
    public void setup(FMLCommonSetupEvent event)
    {
        CapabilityManager.INSTANCE.register(IManaBar.class, new CapabilityMP.Storage(), DefaultManaBar::new);
    }

    @SubscribeEvent
    public void attachAttribute(EntityEvent.EntityConstructing event)
    {
        Entity entity = event.getEntity();
        if (entity instanceof LivingEntity)
        {
            ((LivingEntity) entity).getAttributes().registerAttribute(CapabilityMP.MAX_MANA);
            ((LivingEntity) entity).getAttributes().registerAttribute(CapabilityMP.REGEN_RATE);
        }
    }

    @SubscribeEvent
    public void regenMP(TickEvent.PlayerTickEvent event)
    {
        event.player.getCapability(CapabilityMP.MANA_BAR_CAP).ifPresent((manaBar)->{
            if (manaBar.coolDown())
            {
                double regen = event.player.getAttribute(CapabilityMP.REGEN_RATE).getValue();
                double maxMP = event.player.getAttribute(CapabilityMP.MAX_MANA).getValue();
                regen = MathHelper.clamp(manaBar.getMana() + regen * maxMP, 0, maxMP);
                manaBar.setMana(regen);
                // LOGGER.info("Mana of " + event.player.getUniqueID().toString() + ":" + manaBar.getMana());
            }
        });
    }

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event)
    {
        if (event.getObject() instanceof LivingEntity)
        {
            event.addCapability(ArcaneArt.getResourceLocation("mp"), new CapabilityMP.Provider());
        }
    }
}
