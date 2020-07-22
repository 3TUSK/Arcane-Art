package com.ustctuixue.arcaneart.api.spell.interpreter.argument.clause;

import com.mojang.brigadier.arguments.ArgumentType;
import com.ustctuixue.arcaneart.api.spell.SpellKeyWord;
import com.ustctuixue.arcaneart.api.spell.SpellKeyWords;
import com.ustctuixue.arcaneart.api.spell.interpreter.argument.position.RelativeVec3dArgument;
import com.ustctuixue.arcaneart.api.spell.interpreter.argument.position.RelativeVec3dBuilder;

public class AtClause extends Clause<RelativeVec3dBuilder>
{
    @Override
    protected SpellKeyWord getInductor()
    {
        return SpellKeyWords.AT;
    }

    @Override
    protected ArgumentType<RelativeVec3dBuilder> getArgumentType()
    {
        return new RelativeVec3dArgument();
    }

    @Override
    protected RelativeVec3dBuilder defaultValue()
    {
        return new RelativeVec3dBuilder();
    }
}