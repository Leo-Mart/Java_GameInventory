import java.util.ArrayList;

public class Player {
    private final String playerName;
    private final String playerClass;
    private int playerLevel;
    private final Inventory playerInventory;
    private final ArrayList<Item> equippedItems;
    private double carryWeight;
    private int playerHealth;
    private int playerMana;
    private int playerStamina;
    private int playerGold;


    public Player(String playerName, String playerClass, int playerLevel) {
        this.playerName = playerName;
        this.playerClass = playerClass;
        this.playerLevel = playerLevel;
        this.playerInventory = new Inventory();
        this.equippedItems = new ArrayList<>();
        this.carryWeight = 100;
        this.playerHealth = 200;
        this.playerMana = 100;
        this.playerStamina = 100;
        this.playerGold = 3;
    }

    // getPlayerInventory returns the players inventory
    public Inventory getPlayerInventory() {
        return playerInventory;
    }

    public ArrayList<Item> getEquippedItems() {
        return equippedItems;
    }

    // addGold increases the players gold by a value
    public void addGold(int gold) {
        playerGold += gold;
    }

    // addGold decreases the players gold by a value
    public void removeGold(int gold) {
        playerGold -= gold;
    }

    // getPlayerGold return the current value of playerGold
    public int getPlayerGold() {
        return playerGold;
    }

    public void takeDamage(int damage) {
        this.playerHealth -= damage;
    }

    public int getPlayerhealth() {
        return playerHealth;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    public void setPlayerHealth(int health) {
        this.playerHealth = health;
    }
}
