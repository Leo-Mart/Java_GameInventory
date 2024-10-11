import java.util.ArrayList;

public class Enemy {
    private final String enemyName;
    private final String enemyClass;
    private int enemyLevel;
    private final Inventory inventory;
    private ArrayList<Item> enemyEquippedItems;
    private MeleeWeapon equippedMeleeWeapon;
    private int enemyHealth;
    private int enemyMana;
    private int enemyStamina;

    public Enemy(String enemyName, String enemyClass, int enemyLevel, int enemyHealth, int enemyMana, int enemyStamina) {
        this.enemyName = enemyName;
        this.enemyClass = enemyClass;
        this.enemyLevel = enemyLevel;
        this.inventory = new Inventory();
        this.enemyEquippedItems = new ArrayList<>();
        this.enemyHealth = enemyHealth;
        this.enemyMana = enemyMana;
        this.enemyStamina = enemyStamina;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public String getEnemyClass() {
        return enemyClass;
    }

    public int getEnemyLevel() {
        return enemyLevel;
    }

    public void setEnemyLevel(int enemyLevel) {
        this.enemyLevel = enemyLevel;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public void setEnemyHealth(int enemyHealth) {
        this.enemyHealth = enemyHealth;
    }

    public int getEnemyMana() {
        return enemyMana;
    }

    public void setEnemyMana(int enemyMana) {
        this.enemyMana = enemyMana;
    }

    public int getEnemyStamina() {
        return enemyStamina;
    }

    public void setEnemyStamina(int enemyStamina) {
        this.enemyStamina = enemyStamina;
    }

    public ArrayList<Item> getEnemyEquippedItems() {
        return enemyEquippedItems;
    }

    public void takeDamage(int damage) {
        this.enemyHealth -= damage;
    }

    public MeleeWeapon getEquippedMeleeWeapon() {
        return equippedMeleeWeapon;
    }

    public void setEquippedMeleeWeapon(MeleeWeapon equippedMeleeWeapon) {
        this.equippedMeleeWeapon = equippedMeleeWeapon;
    }
}
