import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // instantiate a new inventory for the player and the shop. Instantiate a new shop and player
        Player player1 = new Player("Onrack", "Warrior", 1);
        Shop shop1 = new Shop("Ye Olde Shoppe", player1);
        Enemy goblin = new Enemy("Goblin", "fighter", 1, 15, 0, 100);
        Encounter encounter = new Encounter(player1, goblin);

        Scanner sc = new Scanner(System.in);

        // creates a few items
        OffensiveConsumable fireBomb = new OffensiveConsumable("Small Firebomb", 1, 0, "bomb", 0.2, 10, 15, DamageType.fire, "Leaves a burning pool for 10 seconds after explosion", true);
        DefensiveConsumable smallHealthPotion = new DefensiveConsumable("Small Health Potion", 1, 0, "Health Potion", 0.3, 0, false, 50, "none", "Healing", true);
        MeleeWeapon shortSword = new MeleeWeapon("Short Sword", 5, 1, "melee", 2.5, 15, 0, 100, "none", 1.4, DamageType.physical, DamageType.none, true);
        MeleeWeapon dagger = new MeleeWeapon("dagger", 3, 1, "melee", 1.5, 10, 0, 100, "none", 1.7, DamageType.physical, DamageType.none, true);
        Armor boiledLeatherTunic = new Armor("Boiled Leather Tunic", 10, 2, "armor", 5, 10, 100, ArmorType.chest, "none", 0, DamageType.none, true);
        RangedWeapon shortBow = new RangedWeapon("Short Bow", 2, 1, "ranged", 3, 0, 10, 100, "none", 0.7, DamageType.physical, DamageType.none, 100, 20, true);
        MeleeWeapon chippedSword = new MeleeWeapon("Chipped Short Sword", 1, 1, "melee", 2.5, 8, 0, 50, "none", 1.4, DamageType.physical, DamageType.none, true);
        Armor raggedTunic = new Armor("Ragged Tunic", 1, 1, "armor", 2, 5, 50, ArmorType.chest, "none", 0, DamageType.none, true);
        OffensiveConsumable throwingDaggers = new OffensiveConsumable("Throwing Daggers", 1, 0, "offensive consumable", 0.3, 0, 5, DamageType.physical, "none", true);

        // add some items to the goblin
        goblin.setEquippedMeleeWeapon(chippedSword);
        goblin.getEnemyEquippedItems().add(chippedSword);
        goblin.getEnemyEquippedItems().add(raggedTunic);
        goblin.getEnemyEquippedItems().add(throwingDaggers);

        // add an item to the player inventory
        player1.getPlayerInventory().addItem(dagger);
        player1.getPlayerInventory().addItem(boiledLeatherTunic);
        player1.getPlayerInventory().addItem(shortBow);

        // add a few items to the shop inventory
        shop1.getShopInventory().addItem(shortSword);
        shop1.getShopInventory().addItem(fireBomb);
        shop1.getShopInventory().addItem(smallHealthPotion);

        boolean gameRunning = true;

        while (gameRunning) {

            mainMenu();

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.println("You keep walking along the path, after an hour or so you see a light between the trees");
                    System.out.println("You keep walking towards the light and when you reach it you see a shop in the middle of the forest");
                    shop1.showShopMainMenu(sc);

                }
                case 2 -> {
                    findGoblinMenu();

                    int attackChoice = Integer.parseInt(sc.nextLine());

                    switch (attackChoice) {
                        case 1 -> {
                            System.out.println("You rush out and attack the goblin!");
                            encounter.supriseAttack(sc);

                        }
                        case 2 -> System.out.println("You sneak back to the road");
                    }
                }
                case 3 -> {
                    System.out.println("You check your inventory ");

                    for (Item item : player1.getPlayerInventory().getInventory()) {
                        System.out.println(item);
                    }
                }
                case 4 -> {
                    if (player1.getPlayerInventory().getInventory().isEmpty()) {
                        System.out.println("You don't have any items in your inventory");
                        break;
                    }

                    System.out.println("You have these items in your inventory that are not equipped: ");

                    for (Item item : player1.getPlayerInventory().getInventory()) {
                        if(item.isEquippable()) {
                            System.out.println(item);
                        }
                    }

                    System.out.println("Write the name of the item you wish to equip: ");
                    System.out.println("Or [exit] to return to main menu");

                    String itemName = sc.nextLine();

                    Item foundItem = HelperMethods.searchForItem(itemName, player1.getPlayerInventory().getInventory());

                    if (foundItem != null) {
                        if (foundItem instanceof Weapon) {
                            ((Weapon) foundItem).equipItem(foundItem, player1); // downcasting, https://www.baeldung.com/java-type-casting
                        } else if (foundItem instanceof Armor) {
                            ((Armor) foundItem).equipItem(foundItem, player1);
                        }
                        System.out.printf("You equipped %s\n", foundItem.getName());
                    } else {
                        System.out.println("That item does not exist in your inventory");
                    }
                }
                case 5 -> {
                    if(player1.getEquippedItems().isEmpty()) {
                        System.out.println("You don't have any items equipped");
                        break;
                    }

                    System.out.println("These items are currently equipped: ");

                    for (Item item : player1.getEquippedItems()) {
                        System.out.println(item);
                    }

                    System.out.println("Write the name of the item you wish to unequip: ");
                    System.out.println("Or [exit] to return to main menu");

                    String itemName = sc.nextLine();
                    System.out.println(itemName);

                    Item foundItem = HelperMethods.searchForItem(itemName, player1.getEquippedItems());

                    if (foundItem != null) {
                        if (foundItem instanceof Weapon) {
                            ((Weapon) foundItem).unequipItem(foundItem, player1); // downcasting, https://www.baeldung.com/java-type-casting
                        } else if (foundItem instanceof Armor) {
                            ((Armor) foundItem).unequipItem(foundItem, player1);
                        }
                        System.out.printf("You unequipped %s\n", foundItem.getName());
                    } else {
                        System.out.println("You do not have that item equipped");
                    }
                }
                case 6 -> {
                    System.out.println("You decided this adventuring business is not for you so you turn around and head home");
                    gameRunning = false;
                }
            }
        }
    }

    static void mainMenu() {
        System.out.println("You find yourself on a forest path");
        System.out.println("Ahead of you, the path snakes between the trees");
        System.out.println("On all sides the forest looms darkly, you think you can hear faints sounds from between the trees");
        System.out.println("What do you wish to do: ");
        System.out.println("1. Keep heading along the path");
        System.out.println("2. Go of the path into the forest");
        System.out.println("3. Check your inventory");
        System.out.println("4. Equip an item");
        System.out.println("5. Unequip an item");
        System.out.println("6. Return from whence you came.");
    }

    static void findGoblinMenu() {
        System.out.println("You pick your way between the tree into the thick forest, heading towards the faint sound you heard");
        System.out.println("Gradually the sound gets clearer");
        System.out.println("You see a goblin, muttering to himself, while rummaging through a pack!");

        System.out.println("What do you do: ");
        System.out.println("1. Attack the goblin!");
        System.out.println("2. Sneak back to the path");
    }
}