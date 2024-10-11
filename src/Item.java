public abstract class Item {
    private String name;
    private int valueInGold;
    private int repairCostInGold;
    private String type;
    private double weight;
    private boolean equippable;

    // constructor
    public Item(String name, int valueInGold, int repairCostInGold, String type, double weight, boolean equippable) {
        this.name = name;
        this.valueInGold = valueInGold;
        this.repairCostInGold = repairCostInGold;
        this.type = type;
        this.weight = weight;
        this.equippable = equippable;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValueInGold() {
        return valueInGold;
    }

    public void setValueInGold(int valueInGold) {
        this.valueInGold = valueInGold;
    }

    public int getRepairCostInGold() {
        return repairCostInGold;
    }

    public void setRepairCostInGold(int repairCostInGold) {
        this.repairCostInGold = repairCostInGold;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isEquippable() {
        return equippable;
    }

    @Override
    public String toString() {
        return  "Item name=" + name +
                ", Gold Value=" + valueInGold +
                ", Repair Cost=" + repairCostInGold +
                ", Type=" + type +
                ", Weight=" + weight + " ";
    }
}
