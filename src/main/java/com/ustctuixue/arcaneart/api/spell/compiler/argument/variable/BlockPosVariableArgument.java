package com.ustctuixue.arcaneart.api.spell.compiler.argument.variable;

import com.mojang.brigadier.arguments.ArgumentType;
import com.ustctuixue.arcaneart.api.spell.compiler.VariableArgument;
import net.minecraft.command.arguments.BlockPosArgument;
import net.minecraft.command.arguments.ILocationArgument;

public class BlockPosVariableArgument extends VariableArgument<ILocationArgument>
{
    @Override
    protected Class<ILocationArgument> getType()
    {
        return ILocationArgument.class;
    }

    @Override
    protected ArgumentType<ILocationArgument> getArgumentType()
    {
        return BlockPosArgument.blockPos();
    }
}
