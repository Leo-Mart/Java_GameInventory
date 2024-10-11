import java.util.Scanner;

public class Shop {
    private Inventory shopInventory;
    private String shopName;
    private Player player;
    private int shopGold;

    public Shop(String shopName, Player player) {
        this.shopInventory = new Inventory();
        this.shopName = shopName;
        this.player = player;
        this.shopGold = 200;
    }

    public void buyItem(Scanner sc) {
        boolean buying = true;
        Item foundItem = null;

        while (buying) {
            System.out.println("What do you want to buy?");
            browseShop();

            System.out.println("Enter the name of the item you would like to buy: ");
            System.out.println("Otherwise type exit to return to the main shop menu");
            String itemName = sc.nextLine();

            if (itemName.equalsIgnoreCase("Exit")) {
                buying = false;
                break;
            }

            foundItem = HelperMethods.searchForItem(itemName, shopInventory.getInventory());

            if (foundItem == null) {
                System.out.println("Sorry, I don't have that item in stock");
            } else {
                System.out.println("You wish to buy " + foundItem.getName() + "?");
                System.out.println("Sure that will be " + foundItem.getValueInGold() + " gold");
                System.out.println("Do you want to buy this item [Y/N]");
                System.out.println("You currently have " + player.getPlayerGold() + " gold");

                String choice = sc.nextLine();

                if (choice.equalsIgnoreCase("Y")) {

                    if (foundItem.getValueInGold() > player.getPlayerGold()) {
                        System.out.println("Seems like you don't have enough gold to buy this item");
                        System.out.println("Maybe you have something to sell?");
                        break;
                    }

                    player.getPlayerInventory().addItem(foundItem);
                    shopInventory.removeItem(foundItem);
                    shopGold += foundItem.getValueInGold();
                    player.removeGold(foundItem.getValueInGold());
                    System.out.println("Enjoy!");
                    System.out.println("You bought " + foundItem.getName() + " for " + foundItem.getValueInGold() + " gold");
                    break;
                } else if (choice.equalsIgnoreCase("N")) {
                    System.out.println("Alright, maybe next time");
                    break;
                }
            }
        }
    }

    public void sellItem(Scanner sc) {
        boolean selling = true;
        Item foundItem = null;

        while (selling) {
            System.out.println("What do you want to sell?");
            player.getPlayerInventory().showInventory();
            System.out.println("Enter the name of the item you would like to sell: ");
            System.out.println("Otherwise type [exit] to return to the main shop menu");
            String itemName = sc.nextLine();

            if (itemName.equalsIgnoreCase("Exit")) {
                selling = false;
                break;
            }

            foundItem = HelperMethods.searchForItem(itemName, player.getPlayerInventory().getInventory() );

            if (foundItem == null) {
                System.out.println("Sorry, doesn't seem like you have that item");
            } else {
                System.out.println("You wish to sell " + foundItem.getName() + "?");
                System.out.println("Sure, I'll take it off your hands for " + foundItem.getValueInGold() + " gold");
                System.out.println("Do you want to sell this item [Y/N]");

                String choice = sc.nextLine();
                if (choice.equalsIgnoreCase("Y")) {

                    if (foundItem.getValueInGold() > shopGold) {
                        System.out.println("Seems like I've run out of money, I can't buy that from you right now");
                        break;
                    }

                    player.getPlayerInventory().removeItem(foundItem);
                    shopInventory.addItem(foundItem);
                    player.addGold(foundItem.getValueInGold());
                    shopGold -= foundItem.getValueInGold();
                    break;
                } else if (choice.equalsIgnoreCase("N")) {
                    System.out.println("Alright, maybe next time");
                    break;
                }
            }
        }
    }

    public void browseShop() {
        System.out.println("This is what I have in stock right now");

        shopInventory.showInventory();

    }


    public Inventory getShopInventory() {
        return shopInventory;
    }

    public void showShopMainMenu(Scanner sc) {
        boolean shopping = true;

        while (shopping) {
            System.out.println("Welcome to " + shopName + " can I interest you in my wares?");
            System.out.println("1. Buy an item");
            System.out.println("2. Sell an item");
            System.out.println("3. Browse the shop");
            System.out.println("4. Exit");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> buyItem(sc);
                case 2 -> sellItem(sc);
                case 3 -> browseShop();
                case 4 -> shopping = false;
            }
        }
    }
}
