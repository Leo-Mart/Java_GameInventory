import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Encounter {
    private Player player;
    private Enemy enemy;

    private static Random rand = new Random();

    public Encounter(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public void combat(Scanner sc) {
        combatMenu();

        String choice = sc.nextLine();

        while(enemy.getEnemyHealth() > 0 ) {

            switch (choice.toUpperCase()) {
                case "A" -> {
                    if(player.getPlayerhealth() <= 0) {
                        System.out.println("You have died! Try again!");
                        System.exit(1);
                    }
                    System.out.println("These are the weapons you have equipped");

                    checkForAvailableWeapons(player.getEquippedItems());

                    System.out.println("Write the name of the weapon you wish to attack with: ");

                    String weaponName = sc.nextLine();

                    Weapon foundWeapon = (Weapon) HelperMethods.searchForItem(weaponName, player.getEquippedItems());

                    attackWithCorrectWeapon(foundWeapon);

                    System.out.println("The enemy retaliates!");
                    enemy.getEquippedMeleeWeapon().meleeAttack();
                    player.takeDamage(enemy.getEquippedMeleeWeapon().getMeleeDamage());

                    combatMenu();

                    choice = sc.nextLine();
                }
                case "D" -> {
                    System.out.println("Drink potion");
                    System.out.println("Do you wish to drink a potion? [Y/N]");

                    choice = sc.nextLine();

                    boolean hasPotions = false;

                    if(choice.equalsIgnoreCase("Y")) {
                        for(Item item: player.getPlayerInventory().getInventory()) {
                            if(item instanceof DefensiveConsumable) {
                                ((DefensiveConsumable) item).drinkPotion(((DefensiveConsumable) item), player);
                                System.out.println("You drink the potion, healing for " + ((DefensiveConsumable) item).getHealingAmount() );
                                hasPotions = true;
                            }
                        }

                        if(!hasPotions) {
                            System.out.println("You don't have any potions!");
                        }

                        combatMenu();

                        choice = sc.nextLine();

                    } else if(choice.equalsIgnoreCase("N")) {
                        combatMenu();

                        choice = sc.nextLine();
                    }

                }

                case "U" -> {
                    System.out.println("Use an item");
                    combatMenu();
                }

                case "T" -> {
                    System.out.println("Throw an item at the enemy!");
                    combatMenu();
                }
            }
        }
        System.out.println("You have defeated the " + enemy.getEnemyName());
        System.out.println("Do you wish to search the body? [Y/N]");

        choice = sc.nextLine();

        boolean looting = true;

        while(looting) {
            if(choice.equalsIgnoreCase("y")) {
                boolean lootExists = true;

                while(lootExists){
                    System.out.println("This is what the " + enemy.getEnemyName() + " has");
                    for(Item item : enemy.getEnemyEquippedItems()) {
                        System.out.println(item);
                    }

                    System.out.println("Write the name of the item you wish to loot or write \"all\" to pickup everything");

                    choice = sc.nextLine();

                    if (choice.equalsIgnoreCase("all")) {
                        for(Item item : enemy.getEnemyEquippedItems()) {
                            player.getPlayerInventory().addItem(item);
                        }
                        enemy.getEnemyEquippedItems().clear(); // have to put this out here otherwise concurrentModificationException
                    }

                    Item foundItem = HelperMethods.searchForItem(choice, enemy.getEnemyEquippedItems());

                    if (foundItem != null) {
                        for(Item item : enemy.getEnemyEquippedItems()) {
                            if(item.equals(foundItem)) {
                                System.out.println("You pick up " + foundItem.getName());
                                player.getPlayerInventory().addItem(foundItem);
                            }
                        }
                        enemy.getEnemyEquippedItems().remove(foundItem); // have to put this out here otherwise concurrentModificationException
                    } else {
                        System.out.println("Could not find item, try again!");
                    }

                    if(enemy.getEnemyEquippedItems().isEmpty()) {
                        lootExists = false;
                    }
                }


                System.out.println("You also find a few gold coins, and put them in you gold purse");
                player.addGold(rand.nextInt(2) + 1);
                System.out.println("You've looted everything on the body");
                System.out.println("You make your way back to the path");
                looting = false;

            } else {
                System.out.println("You leave the body alone, and make your way back to the path.");
                looting = false;
            }
        }



    }

    public void combatMenu() {
        System.out.println("Enemy " + enemy.getEnemyName());
        System.out.println("Enemy level: " + enemy.getEnemyLevel() + " Enemy health: " + enemy.getEnemyHealth());
        System.out.println("Your level: " + player.getPlayerLevel() + " Your Health: " + player.getPlayerhealth());
        System.out.println("Choose your action: ");
        System.out.println("[A]ttack [D]rink potion");
        System.out.println("[U]se Item [T]hrow consumable");
    }

    public void supriseAttack(Scanner sc) {
        int successfullSupriseAttack = rand.nextInt(5) + 1;

        if(successfullSupriseAttack > 3) {
            System.out.println("You catch the enemy of guard and get a free attack!");

            if(!hasWeaponEquipped(player.getEquippedItems())) {
                System.out.println("Oh no! You have no weapon equipped!");
                System.out.println("In a state of panic, you punch the goblin, it's not very effective");
                combat(sc);
            }

            if (hasWeaponEquipped(player.getEquippedItems())) {
                System.out.println("These are the weapons you have equipped");

                checkForAvailableWeapons(player.getEquippedItems());

                System.out.println("Write the name of the weapon you wish to attack with: ");

                String weaponName = sc.nextLine();

                Weapon foundWeapon = (Weapon) HelperMethods.searchForItem(weaponName, player.getEquippedItems());

                attackWithCorrectWeapon(foundWeapon);

                combat(sc);
            }
        } else {
            System.out.println("He noticed you!");
            combat(sc);
        }

    }

    public boolean hasWeaponEquipped(ArrayList<Item> equippedItems) {
        boolean hasWeaponEquipped  = false;

        for (Item item : equippedItems) {
            if (item instanceof Weapon ) {
                hasWeaponEquipped = true;
            }
        }

        return hasWeaponEquipped;
    }

    public void checkForAvailableWeapons(ArrayList<Item> equippedItems) {
        ArrayList<Weapon> playerWeapons = new ArrayList<>();

        for (Item item : equippedItems) {
            if(item instanceof MeleeWeapon || item instanceof RangedWeapon || item instanceof MagicWeapon) {
                playerWeapons.add(((Weapon) item).getWeapon());
            }
        }

        for (Weapon weapon : playerWeapons) {
            System.out.println(weapon);
        }
    }

    public void attackWithCorrectWeapon(Weapon foundWeapon) {
        if(foundWeapon !=null) {
            System.out.println("You attack with your equipped weapon");
            if(foundWeapon instanceof MeleeWeapon) {
                ((MeleeWeapon) foundWeapon).meleeAttack();
                enemy.takeDamage(foundWeapon.getMeleeDamage());
            } else if(foundWeapon instanceof RangedWeapon) {
                ((RangedWeapon) foundWeapon).rangedAttack();
                enemy.takeDamage(foundWeapon.getRangedDamage());
            } else if(foundWeapon instanceof MagicWeapon) {
                ((MagicWeapon) foundWeapon).magicAttack();
                enemy.takeDamage(foundWeapon.getRangedDamage());
            }
        } else {
            System.out.println("Could not find weapon in inventory, try again");
        }
    }
}
