public class Weapon extends Item implements Equippable{
    private int meleeDamage;
    private int rangedDamage;
    private int durability;
    private String additionalEffect;
    private double attackSpeed;



    // constructors
    public Weapon(String name, int value, int repairCost, String type, double weight, int meleeDamage, int rangedDamage, int durability, String additionalEffect, double attackSpeed, boolean equippable) {
        super(name, value, repairCost, type, weight, equippable);
        this.meleeDamage = meleeDamage;
        this.rangedDamage = rangedDamage;
        this.durability = durability;
        this.additionalEffect = additionalEffect;
        this.attackSpeed = attackSpeed;
    }

    // getters and setters
    public int getMeleeDamage() {
        return meleeDamage;
    }

    public void setMeleeDamage(int meleeDamage) {
        this.meleeDamage = meleeDamage;
    }

    public int getRangedDamage() {
        return rangedDamage;
    }

    public void setRangedDamage(int rangedDamage) {
        this.rangedDamage = rangedDamage;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public String getAdditionalEffect() {
        return additionalEffect;
    }

    public void setAdditionalEffect(String additionalEffect) {
        this.additionalEffect = additionalEffect;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public Weapon getWeapon() {
        return this;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "Melee Damage=" + meleeDamage +
                ", Ranged Damage=" + rangedDamage +
                ", Durability=" + durability +
                ", Additional Effect=" + additionalEffect +
                ", Attack Speed=" + attackSpeed;

    }

    @Override
    public void equipItem(Item item, Player player) {
        player.getEquippedItems().add(item);
        player.getPlayerInventory().removeItem(item);
    }

    @Override
    public void unequipItem(Item item, Player player) {
        player.getEquippedItems().remove(item);
        player.getPlayerInventory().addItem(item);
    }

    @Override
    public void durabilityDamage() {

    }

    @Override
    public void repairDurability() {

    }

    @Override
    public void restoreCharges() {

    }
}
