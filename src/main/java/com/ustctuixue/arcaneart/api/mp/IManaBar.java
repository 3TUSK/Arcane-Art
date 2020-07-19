package com.ustctuixue.arcaneart.api.mp;


public interface IManaBar
{
    /**
     * @return ��ȡ���ﵱǰ MP ֵ
     */
    double getMana();

    /**
     * �������ﵱǰ�� MP ֵ������� MP ֵ�Ƿ񳬳�����
     * @param mana ���õ�ֵ�����С�� 0 ����Ϊ�� 0
     */
    void setMana(double mana);


    /**
     * ���� MP ֵ
     * @param mana ���ĵ� MP ��
     * @return ���㹻�� MP �������򷵻� true������Ϊ false
     */
    boolean consumeMana(double mana);

    /**
     *
     * @return ���� MP �ظ���ȴʱ�䣬��λΪ tick
     */
    int getRegenCoolDown();

    /**
     * ���� MP �ظ���ȴʱ��
     * @param coolDown ��λΪ tick
     */
    void setRegenCoolDown(int coolDown);

    /**
     * ÿ tick ����һ�Σ����ڻظ���ȴ����ʱ
     * @return �Ƿ���Կ�ʼ�ظ�
     */
    boolean coolDown();


    /**
     * ��ȡ��ǰħ������ֵ������ʱ����
     * @return ħ������
     */
    double getMagicExperience();

    /**
     * ���õ�ǰ��ħ������ֵ
     * @param exp ����ֵ
     */
    void setMagicExperience(double exp);

    /**
     * ����ħ������ֵ
     * @param exp ����ֵ
     */
    void addMagicExperience(double exp);

    /**
     * ��õ�ǰ��ħ���ȼ�
     * @return ħ���ȼ�
     */
    int getMagicLevel();

    /**
     * ����ħ���ȼ�
     * @param level �ȼ�
     */
    void setMagicLevel(int level);
}
