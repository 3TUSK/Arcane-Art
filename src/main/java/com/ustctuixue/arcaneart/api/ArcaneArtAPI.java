package com.ustctuixue.arcaneart.api;

import com.ustctuixue.arcaneart.api.events.*;
import com.ustctuixue.arcaneart.api.util.Module;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// import net.minecraftforge.fml.common.Mod;
//
// @Mod(ArcaneArtAPI.MOD_ID)
@Mod.EventBusSubscriber
public class ArcaneArtAPI extends Module
{
    public static final String MOD_ID = "arcane_api";
    public static final String MOD_NAME = "Arcane API";
    public static ResourceLocation getResourceLocation(String name)
    {
        return new ResourceLocation(MOD_ID, name);
    }

    public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);

    @Override
    protected Object[] getModLoadingEventHandler()
    {
        return new Object[]{
                new ModLoadingAPIEventHandler()
        };
    }

    @Override
    protected Object[] getCommonEventHandler()
    {
        return new Object[]{
                new InGameMPEventHandler(),
                new InGameAPIEventHandler(),
                new ServerLifecycleAPIEventHandler()
        };
    }

    @Override @OnlyIn(Dist.CLIENT)
    protected Object[] getClientEventHandler()
    {
        return new Object[]
                {
                        new InGameAPIClientEventHandler()
                };
    }
}
