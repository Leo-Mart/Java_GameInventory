public class OffensiveConsumable extends Consumable implements Usable, Equippable {
    private int damage;
    private DamageType damageType;
    private String additionalEffect; // could maybe be an enum as well? Or a separate class if I want more involved effects?

    public OffensiveConsumable(String name, int value, int repairCost, String type, double weight, double duration, int damage, DamageType damageType, String additionalEffect, boolean equippable) {
        super(name, value, repairCost, type, weight, duration, equippable);
        this.damage = damage;
        this.damageType = damageType;
        this.additionalEffect = additionalEffect;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Damage=" + damage +
                ", Damage Type=" + damageType +
                ", Additional Effect=" + additionalEffect;

    }

    @Override
    public void useItem(Item item) {

    }

    @Override
    public void readScroll(Item item) {

    }

    @Override
    public void drinkPotion(DefensiveConsumable potion, Player player) {

    }

    @Override
    public void setTrap(Item item) {

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
