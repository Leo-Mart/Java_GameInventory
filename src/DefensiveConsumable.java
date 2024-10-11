public class DefensiveConsumable extends Consumable implements Usable {
    private boolean isBuff;
    private int healingAmount;
    private String buffEffect; // might be able to use a separate class or enums for this and possibly effectName as well.
    private String effectName;

    // constructor
    public DefensiveConsumable(String name, int value, int repairCost, String type, double weight, double duration, boolean isBuff, int healingAmount, String buffEffect, String effectName, boolean equippable) {
        super(name, value, repairCost, type, weight, duration, equippable);
        this.isBuff = isBuff;
        this.healingAmount = healingAmount;
        this.buffEffect = buffEffect;
        this.effectName = effectName;
    }

    public int getHealingAmount() {
        return healingAmount;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Buff =" + isBuff +
                ", Healing Amount=" + healingAmount +
                ", Buff Effect=" + buffEffect +
                ", Effect Name=" + effectName;

    }


    @Override
    public void useItem(Item item) {

    }

    @Override
    public void readScroll(Item item) {

    }

    @Override
    public void drinkPotion(DefensiveConsumable potion, Player player) {
        player.setPlayerHealth(player.getPlayerhealth() + potion.healingAmount);
    }

    @Override
    public void setTrap(Item item) {

    }
}
