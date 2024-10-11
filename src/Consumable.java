public class Consumable extends Item {
    private double duration;

    // constructor
    public Consumable(String name, int value, int repairCost, String type, double weight, double duration, boolean equippable) {
        super(name, value, repairCost, type, weight, equippable);
        this.duration = duration;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "Duration=" + duration;

    }
}
