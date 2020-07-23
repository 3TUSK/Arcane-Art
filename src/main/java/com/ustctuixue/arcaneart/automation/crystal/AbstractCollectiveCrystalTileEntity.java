package com.ustctuixue.arcaneart.automation.crystal;

import com.ustctuixue.arcaneart.api.mp.tile.CapabilityMPStorage;
import com.ustctuixue.arcaneart.api.mp.tile.MPStorage;
import com.ustctuixue.arcaneart.automation.AutomationConfig;
import com.ustctuixue.arcaneart.automation.AutomationRegistry;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class AbstractCollectiveCrystalTileEntity extends TileEntity implements ITickableTileEntity {

    public AbstractCollectiveCrystalTileEntity(TileEntityType<? extends AbstractCollectiveCrystalTileEntity> entityType) {
        super(entityType);
    }



    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return cap == CapabilityMPStorage.MP_STORAGE_CAP ? LazyOptional.of(()->{
            return this.getOrCreateMPStorage();
        }).cast() : LazyOptional.empty();
    }

    public MPStorage CrystalMPStorage;

    private MPStorage getOrCreateMPStorage(){
        if (CrystalMPStorage == null){
            MPStorage mps = new MPStorage();
            mps.setMaxMP(AutomationConfig.Crystal.CRYSTAL_MAX_MP.get());
            mps.setOutputRateLimit(AutomationConfig.Crystal.CRYSTAL_MAX_OUTPUT.get());
            mps.setInputRateLimit(0.0D);
            this.CrystalMPStorage = mps;
        }
        return this.CrystalMPStorage;
    }

    @Override
    public void tick() {
        if (!world.isRemote) {
            //这里是服务器逻辑
            LazyOptional<MPStorage> MPStorageCapLazyOptional = this.getCapability(CapabilityMPStorage.MP_STORAGE_CAP);
            MPStorageCapLazyOptional.ifPresent((s) -> {
                double regenRatio = crystalRegenRatio();
                if (regenRatio == 0)
                    return;
                double MP = s.getMana();
                double maxMP = s.getMaxMP();
                MP += regenRatio;
                if (MP >= maxMP)
                    MP = maxMP;
                s.setMana(MP);
                //按回复速率产生MP
            });
        }
    }

    public double crystalRegenRatio(){
        return 0.0D;
    }
}
