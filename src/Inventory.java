import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> inventory;

    public Inventory() {
        inventory = new ArrayList<>();
    }

    // addItem adds an item to the inventory
    public void addItem(Item item) {
        inventory.add(item);
    }

    // removeItem removes an item from the inventory
    public void removeItem(Item item) {
        inventory.remove(item);
    }

    // getInventory returns the inventory
    public ArrayList<Item> getInventory() {
        return inventory;
    }

    // showInventory prints out the contents of the inventory
    public void showInventory() {
        for (Item item : inventory) {
            System.out.println(item);
        }
    }
}
