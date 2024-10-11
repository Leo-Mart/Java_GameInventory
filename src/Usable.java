public interface Usable {
    void useItem(Item item);
    void readScroll(Item item);
    void drinkPotion(DefensiveConsumable potion, Player player);
    void setTrap(Item item);
}
