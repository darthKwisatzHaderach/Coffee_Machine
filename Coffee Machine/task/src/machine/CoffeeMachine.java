package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;
    private int money;

    CoffeeMachine(int water, int milk, int coffeeBeans, int disposableCups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.disposableCups = disposableCups;
        this.money = money;
    }

    public int getWater() {
        return water;
    }

    public void addWater(int water) {
        this.water += water;
    }

    public void subtractWater(int water) {
        this.water -= water;
    }

    public int getMilk() {
        return milk;
    }

    public void addMilk(int milk) {
        this.milk += milk;
    }

    public void subtractMilk(int milk) {
        this.milk -= milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public void addCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans += coffeeBeans;
    }

    public void subtractCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans -= coffeeBeans;
    }

    public int getDisposableCups() {
        return disposableCups;
    }

    public void addDisposableCups(int disposableCups) {
        this.disposableCups += disposableCups;
    }

    public void subtractDisposableCups(int disposableCups) {
        this.disposableCups -= disposableCups;
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int money) {
        this.money += money;
    }

    public void takeMoney() {
        System.out.println("I gave you $" + this.money);
        this.money = 0;
    }

    public boolean haveIngredients(Beverage beverage) {
        if (beverage.getWater() > this.water) {
            System.out.println("Sorry, not enough water!");
            return false;
        }
        if (beverage.getMilk() > this.milk) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }
        if (beverage.getCoffeeBeans() > this.coffeeBeans) {
            System.out.println("Sorry, not enough coffeeBeans!");
            return false;
        }

        System.out.println("I have enough resources, making you a coffee!");
        return true;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append("The coffee machine has:\n")
                .append(water + " of water\n")
                .append(milk + " of milk\n")
                .append(coffeeBeans + " of coffee beans\n")
                .append(disposableCups + " of disposable cups\n")
                .append(money + " of money\n");

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);
        Scanner scanner = new Scanner(System.in);
        Action action;

        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            action = Action.valueOf(scanner.nextLine().toUpperCase().trim());

            switch (action) {
                case BUY:
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                    int num = 0;
                    String stringCommand = scanner.nextLine();
                    try {
                        num = Integer.valueOf(stringCommand);
                    } catch (RuntimeException ex) {
                        if (Action.valueOf(stringCommand.toUpperCase().trim()) == Action.BACK) {
                            break;
                        } else {
                            System.out.println("Wrong number format.");
                        }
                    }

                    Beverage beverage = null;

                    switch (num) {
                        case 1:
                            beverage = new Espresso();
                            break;
                        case 2:
                            beverage = new Latte();
                            break;
                        case 3:
                            beverage = new Cappuccino();
                            break;
                        default:
                            System.out.println("Wrong number of beverage.");
                            break;
                    }

                    if (coffeeMachine.haveIngredients(beverage)) {
                        coffeeMachine.subtractWater(beverage.getWater());
                        coffeeMachine.subtractMilk(beverage.getMilk());
                        coffeeMachine.subtractCoffeeBeans(beverage.getCoffeeBeans());
                        coffeeMachine.subtractDisposableCups(1);
                        coffeeMachine.addMoney(beverage.getCost());
                    }
                    break;
                case FILL:
                    System.out.println("Write how many ml of water do you want to add:");
                    coffeeMachine.addWater(Integer.valueOf(scanner.nextLine()));
                    System.out.println("Write how many ml of milk do you want to add:");
                    coffeeMachine.addMilk(Integer.valueOf(scanner.nextLine()));
                    System.out.println("Write how many grams of coffee beans do you want to add:");
                    coffeeMachine.addCoffeeBeans(Integer.valueOf(scanner.nextLine()));
                    System.out.println("Write how many disposable cups of coffee do you want to add:");
                    coffeeMachine.addDisposableCups(Integer.valueOf(scanner.nextLine()));
                    break;
                case TAKE:
                    coffeeMachine.takeMoney();
                    break;
                case REMAINING:
                    System.out.print(coffeeMachine.toString());
                    break;
                case EXIT:
                    break;
                default:
                    System.out.println("Select correct action: buy, fill, take.");
                    break;
            }
            System.out.println();
        } while (action != Action.EXIT);
        scanner.close();
    }
}
