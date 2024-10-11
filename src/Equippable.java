public interface Equippable {
    // equipItem allows the player to equip an item
    void equipItem(Item item, Player player);
    // unequipItem allows the player to unequip an item
    void unequipItem(Item item, Player player);
    // durabilityDamage is used when items take durability damage
    void durabilityDamage();
    // repairDurability is used to repair damaged item. Either by the player or a shop
    void repairDurability();
    // restoreCharges is used to restore depleted magical items. Either by the player or a shop
    void restoreCharges();
}
