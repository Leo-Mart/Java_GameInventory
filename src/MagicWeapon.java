public class MagicWeapon extends Weapon implements MagicAttack{
    private DamageType primaryDamageType;
    private DamageType secondaryDamageType;
    private int charges;

    // constructor
    public MagicWeapon(String name, int value, int repairCost, String type, double weight, int meleeDamage, int rangedDamage, int durability, String additionalEffect, double attackSpeed, int charges, DamageType primaryDamageType, DamageType secondaryDamageType, boolean equippable) {
        super(name, value, repairCost, type, weight, meleeDamage, rangedDamage, durability, additionalEffect, attackSpeed, equippable);
        this.primaryDamageType = primaryDamageType;
        this.secondaryDamageType = secondaryDamageType;
        this.charges = charges;
    }

    // magicAttack lets the player or enemy attack using magic item or weapons
    @Override
    public void magicAttack() {
        System.out.printf("You hold up the %s focusing its energies and fire a ball of %s, dealing %d\n", getName(), primaryDamageType, getRangedDamage() );
    }



}
