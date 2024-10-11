public class MeleeWeapon extends Weapon implements MeleeAttack{
    private DamageType primaryDamageType;
    private DamageType secondaryDamageType;

    // constructor
    public MeleeWeapon(String name, int value, int repairCost, String type, double weight, int meleeDamage, int rangedDamage, int durability, String additionalEffect, double attackSpeed, DamageType primaryDamageType, DamageType secondaryDamageType, boolean equippable) {
        super(name, value, repairCost, type, weight, meleeDamage, rangedDamage, durability, additionalEffect, attackSpeed, equippable);
        this.primaryDamageType = primaryDamageType;
        this.secondaryDamageType = secondaryDamageType;
    }

    @Override
    public void meleeAttack() {
        System.out.printf("Swing with %s, dealing %d %s damage\n", getName(), getMeleeDamage(), primaryDamageType);
        // TODO: add durability damage, and maybe modifiers depending on a player class. If I make one of those. Could also give it a chance to miss, and the enemies statistics would impact the damage. Say they have high defense or some such.
    }

}
