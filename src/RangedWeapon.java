public class RangedWeapon extends Weapon implements RangedAttack{
    private DamageType primaryDamageType;
    private DamageType secondaryDamageType;
    private int ammunition;
    private int range;

    // constructor
    public RangedWeapon(String name, int value, int repairCost, String type, double weight, int meleeDamage, int rangedDamage, int durability, String additionalEffect, double attackSpeed, DamageType primaryDamageType, DamageType secondaryDamageType, int ammunition, int range, boolean equippable) {
        super(name, value, repairCost, type, weight, meleeDamage, rangedDamage, durability, additionalEffect, attackSpeed, equippable);
        this.primaryDamageType = primaryDamageType;
        this.secondaryDamageType = secondaryDamageType;
        this.range = range;
        this.ammunition = ammunition;
    }

    // rangedAttack let's the player or enemy do a ranged attack
    @Override
    public void rangedAttack() {
        System.out.printf("You aim your %s and fire, dealing %d damage\n", getName(), getRangedDamage());
    }
}
