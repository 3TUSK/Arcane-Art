package com.ustctuixue.arcaneart.api.mp;


import lombok.Getter;
import lombok.Setter;

public class DefaultManaBar implements IManaBar
{
    @Getter @Setter
    private double mana;

    @Getter @Setter
    private int regenCoolDown;

    @Getter @Setter
    private double magicExperience;

    @Getter @Setter
    private int magicLevel;

    /**
     * ���� MP ֵ
     *
     * @param mana ���ĵ� MP ��
     */
    @Override
    public boolean consumeMana(double mana)
    {
        if (this.mana >= mana)
        {
            this.mana -= mana;
            return true;
        }
        return false;
    }

    /**
     * ����ħ������ֵ
     *
     * @param exp ����ֵ
     */
    @Override
    public void addMagicExperience(double exp)
    {
        this.magicExperience += exp;
    }

    /**
     * ÿ tick ����һ�Σ����ڻظ���ȴ����ʱ
     *
     * @return �Ƿ���Կ�ʼ�ظ�
     */
    @Override
    public boolean coolDown()
    {

        if (regenCoolDown <= 0)
        {
            regenCoolDown = 0;
            return true;
        }
        regenCoolDown--;
        return false;
    }

	@Override
	public double getMana() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setMana(double mana) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getRegenCoolDown() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setRegenCoolDown(int coolDown) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getMagicExperience() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setMagicExperience(double exp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getMagicLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setMagicLevel(int level) {
		// TODO Auto-generated method stub
		
	}
}
