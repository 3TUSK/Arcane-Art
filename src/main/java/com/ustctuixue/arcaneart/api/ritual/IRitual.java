package com.ustctuixue.arcaneart.api.ritual;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.util.LazyOptional;

public interface IRitual
{
    default boolean validateTimeOfDay(long timeOfDay)
    {
        return true;
    }

    default boolean validateBiome(Biome biome)
    {
        return true;
    }

    default boolean validateOther(World world, BlockPos pos)
    {
        return true;
    }

    default boolean validateRitualCondition(World world, BlockPos pos)
    {
        boolean flagTime = validateTimeOfDay(world.getDayTime());
        boolean flagBiome = validateBiome(world.getBiome(pos));
        boolean flagOther = validateOther(world, pos);
        return flagTime && flagBiome && flagOther;
    }

    /**
     * ʩ��Ч��
     * @param world ��ʽ���ļ�̳��λ��
     * @param pos ��ʽ���ļ�̳��λ��
     * @param caster ��ѡ��ʩ����
     */
    void execute(World world, BlockPos pos, LazyOptional<PlayerEntity> caster);

    /**
     * ��鲢��������
     * @param world ��ʽ���ļ�̳��λ��
     * @param pos ��ʽ���ļ�̳��λ��
     * @param simulate �Ƿ�ģ�⣬true ʱ��Ӧ��������
     * @return �����Ƿ�ɹ�
     */
    boolean consumeSacrifice(World world, BlockPos pos, boolean simulate);
}
