import java.util.ArrayList;

public class HelperMethods {
    public static Item searchForItem(String itemName, ArrayList<Item> inventory) {
        Item foundItem = null;

        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                foundItem = item;
            }
        }
        return foundItem;
    }
}
