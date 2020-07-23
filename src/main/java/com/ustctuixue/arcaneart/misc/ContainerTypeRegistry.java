package com.ustctuixue.arcaneart.misc;


import com.ustctuixue.arcaneart.gui.MagicMenu.MagicContainer;
import com.ustctuixue.arcaneart.misc.tileentity.BookShelfContainer;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.network.PacketBuffer;

public class ContainerTypeRegistry {
    public static final DeferredRegister<ContainerType<?>> CONTAINERS = new DeferredRegister<>(ForgeRegistries.CONTAINERS, "arcaneart");
    public static RegistryObject<ContainerType<MagicContainer>> magicContainer = CONTAINERS.register("magic_container", () -> {
        return IForgeContainerType.create((int windowId, PlayerInventory inv, PacketBuffer data) -> {
            return new MagicContainer(windowId,inv,inv.player);
        });
    });
    public static RegistryObject<ContainerType<BookShelfContainer>> bookShelfContainer = CONTAINERS.register("bookshelf_container", () -> {
        return IForgeContainerType.create((int windowId, PlayerInventory inv, PacketBuffer data) -> {
            return new BookShelfContainer(windowId,inv,data.readBlockPos(), Minecraft.getInstance().world.getWorld());
        });
    });
}
