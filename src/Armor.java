public class Armor extends Item implements Equippable{
    private int defense;
    private int durability;
    private ArmorType armorType;
    private String additionalEffect;
    private int resistance;
    private DamageType resistanceType;

    // constructor
    public Armor(String name, int value, int repairCost, String type, double weight, int defense, int durability, ArmorType armorType, String additionalEffect, int resistance, DamageType resistanceType, boolean equippable) {
        super(name, value, repairCost, type, weight, equippable);
        this.defense = defense;
        this.durability = durability;
        this.armorType = armorType;
        this.additionalEffect = additionalEffect;
        this.resistance = resistance;
        this.resistanceType = resistanceType;
    }

    @Override
    public String toString() {
        return super.toString() +
                "defense=" + defense +
                ", durability=" + durability +
                ", armorType=" + armorType +
                ", additionalEffect=" + additionalEffect +
                ", resistance=" + resistance +
                ", resistanceType=" + resistanceType;

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
