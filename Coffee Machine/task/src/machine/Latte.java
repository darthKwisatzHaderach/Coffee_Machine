package machine;

public class Latte extends Beverage {
    private static final int water = 350;
    private static final int milk = 75;
    private static final int coffeeBeans = 20;
    private static final int cost = 7;

    Latte() {
        super(water, milk, coffeeBeans, cost);
    }
}
